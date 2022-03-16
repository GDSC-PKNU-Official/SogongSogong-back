package sogong.sogongSpring.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.boardedit.EditPostCommentAuthDto
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.board.EntirePostDto
import sogong.sogongSpring.dto.boardedit.DeleteCommentDto
import sogong.sogongSpring.dto.boardedit.DeletePostDto
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.repository.EntireCommentRepository
import sogong.sogongSpring.repository.EntirePostRepository
import sogong.sogongSpring.repository.ScrapLikeRepository
import sogong.sogongSpring.repository.UserLoginRepository
import java.time.LocalDateTime
import javax.transaction.Transactional


@Service
class BoardEditService {
    @Autowired //글을 저장하려는 변수
    private lateinit var entirePostRepository : EntirePostRepository
    @Autowired //글을 저장할 때 userid가 유효한지 검증하려는 변수
    private lateinit var userLoginRepository : UserLoginRepository
    @Autowired //댓글을 저장하려는 변수
    private lateinit var entireCommentRepository: EntireCommentRepository
    @Autowired
    private lateinit var scrapLikeRepository: ScrapLikeRepository

    ///////////////////////////////////////////////////////////////
    @Transactional
    fun editAuth(editPostCommentAuthDto: EditPostCommentAuthDto) : Boolean{
        val userAuth = userLoginRepository.findById(editPostCommentAuthDto.userId) //기본적으로 userid부터 조회해야 함

        if(userAuth.isPresent){
            if(editPostCommentAuthDto.commentId == null) { //글 수정 권한 조회일 경우
                val postAuth = entirePostRepository.findByPostIdAndUserId(editPostCommentAuthDto.postId, userAuth.get())
                return postAuth.isNotEmpty()
            }
            else{ //댓글 수정 권한 조회일 경우
                val postAuth = entirePostRepository.findById(editPostCommentAuthDto.postId)
                if(postAuth.isPresent){
                    val commentAuth = entireCommentRepository.findByCommentIdAndUserIdAndPostId(
                        editPostCommentAuthDto.commentId, userAuth.get(), postAuth.get()
                    )
                    return commentAuth.isNotEmpty()
                }
                else throw java.lang.IllegalArgumentException("Postid Error!!") //postid가 잘못 되었을 경우
            }
        }
        else throw java.lang.IllegalArgumentException("Userid Error!!") //userid가 잘못 되었을 경우
    }

    ///////////////////////////////////////////////////////////////
    @Transactional
    fun editPost(editPostDto : EntirePostDto){
        //Dto를 재활용하는 바람에 글 생성될 때 null 허용하던 postid가 여기선 not null로 처리해야되는...
        //Dto 하나 더 만들까 생각 중.
        val editPost = entirePostRepository.findById(editPostDto.postId!!).get()

        editPost.subject = editPostDto.subject
        editPost.content = editPostDto.content
        editPost.date = LocalDateTime.now()
        editPost.picture = editPostDto.picture
        //공백 subject, content는 어떻게 처리?
    }

    @Transactional
    fun editComment(editCommentDto : EntireCommentDto){
        val editComment = entireCommentRepository.findById(editCommentDto.commentId!!).get()
        editComment.date = LocalDateTime.now()
        editComment.content = editCommentDto.content
        //공백 content는 어떻게 처리?
    }

    @Transactional
    fun deleteComment(deleteCommentDto: DeleteCommentDto){
        if (entireCommentRepository.findById(deleteCommentDto.commmentId).get().postId.postId == deleteCommentDto.postId) {
            entireCommentRepository.deleteById(deleteCommentDto.commmentId)
            val decreaseCount = entirePostRepository.findById(deleteCommentDto.postId).get()
            decreaseCount.countComment = decreaseCount.countComment - 1
        }
        else throw java.lang.IllegalArgumentException("Userid Error!!")
    }

    @Transactional
    fun deletePost(deletePostDto: DeletePostDto){
        //==========hotpost 에서도 삭제해야함 참고=============//
        val deletePost = entirePostRepository.findById(deletePostDto.postId)
        if (deletePost.isPresent) {
            val deleteScrapLike = scrapLikeRepository.findByPostId(deletePost.get())
            val deletecomment = entireCommentRepository.findByPostId(deletePost.get())

            deleteScrapLike.forEach { i -> scrapLikeRepository.delete(i) }
            deletecomment.forEach { i -> entireCommentRepository.delete(i) }
            entirePostRepository.deleteById(deletePostDto.postId)
        }
        else throw java.lang.IllegalArgumentException("PostId Error!!")
    }
}