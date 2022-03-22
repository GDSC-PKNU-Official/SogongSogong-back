package sogong.sogongSpring.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.boardedit.EditPostCommentAuthDto
import sogong.sogongSpring.dto.boardedit.DeleteCommentDto
import sogong.sogongSpring.dto.boardedit.EditCommentDto
import sogong.sogongSpring.dto.boardedit.EditPostDto
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

    @Transactional
    fun editAuth(editPostCommentAuthDto: EditPostCommentAuthDto) : Boolean{
        runCatching{
            userLoginRepository.findById(editPostCommentAuthDto.userId).get()
        }.onSuccess { ule ->
            if(editPostCommentAuthDto.commentId==null){
                val postAuth = entirePostRepository.findByPostIdAndUserId(editPostCommentAuthDto.postId, ule)
                return postAuth.isNotEmpty()
            }
            else{
                runCatching{
                    entirePostRepository.findById(editPostCommentAuthDto.postId).get()
                }.onSuccess { epe ->
                    val commentAuth = entireCommentRepository.findByCommentIdAndUserIdAndPostId(
                        editPostCommentAuthDto.commentId, ule, epe)
                    return commentAuth.isNotEmpty()
                }.onFailure {
                    throw PostIdException(editPostCommentAuthDto.postId)
                }
            }
        }.onFailure {
            throw UserIdException(editPostCommentAuthDto.userId)
        }
        throw IllegalStateException("Server Error!!") //왜 return이 필요하지? 이해가 안됨
    }


    @Transactional //공백 content 처리
    fun editPost(postId:Long, editPostDto:EditPostDto){
        runCatching {
            entirePostRepository.findById(postId).get()
        }.onSuccess {
            it.subject = editPostDto.subject
            it.content = editPostDto.content
            it.date = LocalDateTime.now()
            it.picture = editPostDto.picture
        }.onFailure {
            throw PostIdException(postId)
        }
    }

    @Transactional //공백 content 처리
    fun editComment(commentId:Long, editCommentDto:EditCommentDto){
        runCatching{
            entireCommentRepository.findById(commentId).get()
        }.onSuccess {
            it.date = LocalDateTime.now()
            it.content = editCommentDto.content
        }.onFailure {
            throw CommentIdException(commentId)
        }
    }

    @Transactional
    fun deleteComment(deleteCommentDto: DeleteCommentDto){
        runCatching {
            entireCommentRepository.findById(deleteCommentDto.commmentId).get().postId.postId
        }.onSuccess { ecr:Long? ->
            if(ecr == deleteCommentDto.postId) {
                entireCommentRepository.deleteById(deleteCommentDto.commmentId)
                kotlin.runCatching {
                    entirePostRepository.findById(deleteCommentDto.postId).get()
                }.onSuccess { epe : EntirePostEntity ->
                    epe.countComment = epe.countComment - 1
                }.onFailure {
                    throw PostIdException(deleteCommentDto.postId)
                }
            }
            else throw java.lang.IllegalArgumentException("PostId didn't match with CommentId.")
        }.onFailure {
            throw CommentIdException(deleteCommentDto.postId)
        }

    }

    @Transactional
    fun deletePost(postId:Long){
        kotlin.runCatching {
            entirePostRepository.findById(postId).get()
        }.onSuccess { epe ->
            for(sc in scrapLikeRepository.findByPostId(epe))
                scrapLikeRepository.delete(sc)
            for(ec in entireCommentRepository.findByPostId(epe))
                entireCommentRepository.delete(ec)
            entirePostRepository.deleteById(postId)
        }.onFailure {
            throw PostIdException(postId)
        }
    }
}