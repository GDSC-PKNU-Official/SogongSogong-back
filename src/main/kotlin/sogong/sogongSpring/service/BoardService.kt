package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.board.EntirePostDto
import sogong.sogongSpring.dto.board.ScrapLikeDto
import sogong.sogongSpring.entity.*
import sogong.sogongSpring.repository.*
import java.time.LocalDateTime
import javax.transaction.Transactional


@Service
class BoardService {
    @Autowired //글을 저장하려는 변수
    private lateinit var entirePostRepository : EntirePostRepository
    @Autowired //글을 저장할 때 userid가 유효한지 검증하려는 변수
    private lateinit var userLoginRepository : UserLoginRepository
    @Autowired //댓글을 저장하려는 변수
    private lateinit var entireCommentRepository: EntireCommentRepository
    @Autowired
    private lateinit var scrapLikeRepository: ScrapLikeRepository


    @Transactional
    fun saveBoard(entirePostDto: EntirePostDto){
        runCatching{
            userLoginRepository.findById(entirePostDto.userId).get()
        }.onSuccess{
            val entirePostEntity = EntirePostEntity(
                userId = it, //위에서 userid를 조회한 객체를 Entity의 userid 값으로 넣자!
                subject = entirePostDto.subject, //나머지들은 그냥 있는 그대로 넣기.
                content = entirePostDto.content,
                date = LocalDateTime.now(),
                picture = entirePostDto.picture
            )
            entirePostRepository.save(entirePostEntity) //자 이제 Repository에 저장해주세요
        }.onFailure{
            throw UserIdException(entirePostDto.userId)
        }
    }

    @Transactional
    fun saveComment(entireCommentDto: EntireCommentDto){
        runCatching {
            userLoginRepository.findById(entireCommentDto.userId).get()
        }.onSuccess { ule ->
            runCatching{
                entirePostRepository.findById(entireCommentDto.postId).get()
            }.onSuccess { epe ->
                val entireCommentEntity = EntireCommentEntity(
                    userId = ule,
                    postId = epe,
                    date = LocalDateTime.now(),
                    content = entireCommentDto.content
                )
                entireCommentRepository.save(entireCommentEntity) //댓글 저장

                //게시글의 댓글 수가 1씩 증가하도록 저장.
                epe.countComment = epe.countComment + 1
                entirePostRepository.save(epe)
            }.onFailure {throw PostIdException(entireCommentDto.postId) }
        }.onFailure {throw UserIdException(entireCommentDto.userId)}
    }

    @Transactional
    fun saveScrapLike(scrapLikeDto: ScrapLikeDto){

        runCatching{
            userLoginRepository.findById(scrapLikeDto.userId).get()
        }.onSuccess { ulr ->
            runCatching {
                entirePostRepository.findById(scrapLikeDto.postId).get()
            }.onSuccess { epr ->
                //스크랩과 좋아요가 미리 있으면 취소해주기 위한 변수
                val editScrapLike = scrapLikeRepository.findByUserIdAndPostIdAndCategory(
                    ulr, epr, scrapLikeDto.category
                )
                val countLike : Int = epr.countLike //게시글 내 좋아요 개수

                //스크랩, 좋아요가 있으면 그냥 저장~
                if(editScrapLike == null) {
                    val scrapLikeEntity = ScrapLikeEntity(
                        userId = ulr,
                        postId = epr,
                        category = scrapLikeDto.category
                    )
                    scrapLikeRepository.save(scrapLikeEntity)
                    //좋아요일 때 게시글의 좋아요 수가 1씩 증가하도록 저장.
                    if (scrapLikeDto.category) {
                        epr.countLike = countLike + 1
                        entirePostRepository.save(epr)
                    }
                }
                //스크랩, 좋아요가 있으면 삭제
                else {
                    scrapLikeRepository.delete(editScrapLike)
                    //좋아요를 취소하므로 좋아요 수가 1씩 감소하도록 저장.
                    epr.countLike = countLike - 1
                }
            }.onFailure {throw PostIdException(scrapLikeDto.postId)}
        }.onFailure {throw UserIdException(scrapLikeDto.userId)}
    }

}