package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.board.EntirePostDto
import sogong.sogongSpring.dto.hashtag.PostHashtagDto
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
    private lateinit var hotPostRepository: HotPostRepository
    @Autowired
    private lateinit var bestPostRepository: BestPostRepository
    @Autowired
    private lateinit var scrapLikeRepository: ScrapLikeRepository


    //MutableList<EntirePostEntity>로 반환하면 Json 형태로 잘 돌려보내줘요.
    @Transactional
    fun saveBoard(entirePostDto: EntirePostDto): EntirePostEntity {

        //Board DTO에 저장된 userid를 User Repository에 조회해보자!
        val postUserId = userLoginRepository.findById(entirePostDto.userid)

        //userid가 조회가 될 때!
        if (postUserId.isPresent) {
            //DTO를 EntirePostEntity에 저장해라.
            val entirePostEntity = EntirePostEntity(
                userId = postUserId.get(), //위에서 userid를 조회한 객체를 Entity의 userid 값으로 넣자!
                subject = entirePostDto.subject, //나머지들은 그냥 있는 그대로 넣기.
                content = entirePostDto.content,
                date = LocalDateTime.now(),
                picture = entirePostDto.picture,
                countComment = entirePostDto.countcomment,
                countLike = entirePostDto.countlike
            )
            entirePostRepository.save(entirePostEntity) //자 이제 Repository에 저장해주세요
            return entirePostEntity //전체 글 조회해주세요^^
        }
        //userid가 조회가 되지 않을 때!
        else throw java.lang.IllegalArgumentException("Userid Error!!!!") //응 userid 잘못된거니까 던져
    }

    //////////////////////////////////////////////////////////////

    @Transactional
    fun saveComment(entireCommentDto: EntireCommentDto) : EntireCommentEntity{
        val commentUserId = userLoginRepository.findById(entireCommentDto.userid)
        val commentPostId = entirePostRepository.findById(entireCommentDto.postid)

        if(commentUserId.isPresent and commentPostId.isPresent){
            val entireCommentEntity = EntireCommentEntity(
                userId = commentUserId.get(),
                postId = commentPostId.get(),
                date = LocalDateTime.now(),
                content = entireCommentDto.content
            )
            entireCommentRepository.save(entireCommentEntity) //댓글 저장
            //게시글의 댓글 수가 1씩 증가하도록 저장.
            commentPostId.get().countComment = commentPostId.get().countComment + 1
            entirePostRepository.save(commentPostId.get())

            if (commentPostId.get().countComment == 10){
                val hotPostEntity = HotPostEntity(postId=commentPostId.get(), date=LocalDateTime.now())
                hotPostRepository.save(hotPostEntity)
            }

            return entireCommentEntity
        }
        else throw java.lang.IllegalArgumentException("Userid & Postid Error!!!")
    }
    ////////////////////////////////////////////////////////////////


    @Transactional
    fun saveScrapLike(scrapLikeDto: ScrapLikeDto){
        val scrapLikeUserId = userLoginRepository.findById(scrapLikeDto.userid)
        val scrapLikePostId = entirePostRepository.findById(scrapLikeDto.postid)

        //usreid와 postid가 존재한다면
        if (scrapLikeUserId.isPresent and scrapLikePostId.isPresent) {
            //스크랩과 좋아요가 미리 있으면 취소해주기 위한 변수
            val editScrapLike = scrapLikeRepository.findByUserIdAndPostIdAndCategory(
                scrapLikeUserId.get(), scrapLikePostId.get(), scrapLikeDto.category)
            val countLike : Int = scrapLikePostId.get().countLike //게시글 내 좋아요 개수

            //스크랩, 좋아요가 없으면 등록
            if(editScrapLike == null) {
                val scrapLikeEntity = ScrapLikeEntity(
                    userId = scrapLikeUserId.get(),
                    postId = scrapLikePostId.get(),
                    category = scrapLikeDto.category
                )
                scrapLikeRepository.save(scrapLikeEntity)
                //좋아요일 때 게시글의 좋아요 수가 1씩 증가하도록 저장.
                if (scrapLikeDto.category) {
                    scrapLikePostId.get().countLike = countLike + 1
                    entirePostRepository.save(scrapLikePostId.get())

                    //좋아요가 10개 될 때 best 게시글에 저장.
                    if(scrapLikePostId.get().countLike == 10){
                        val bestPostEntity = BestPostEntity(postId=scrapLikePostId.get(), date= LocalDateTime.now())
                        bestPostRepository.save(bestPostEntity)
                    }
                }
            }
            //스크랩, 좋아요가 있으면 삭제
            else {
                val scrapid : Long = editScrapLike.scrapId!!
                scrapLikeRepository.deleteById(scrapid)
                //좋아요를 취소하므로 좋아요 수가 1씩 감소하도록 저장.
                scrapLikePostId.get().countLike = countLike - 1
            }
        } else throw java.lang.IllegalArgumentException("Userid & Postid Error!!")
    }

}