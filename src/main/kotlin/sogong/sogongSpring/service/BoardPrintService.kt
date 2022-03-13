package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.boardprint.PrintEntirePostDto
import sogong.sogongSpring.entity.EntireCommentEntity
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.repository.EntireCommentRepository
import sogong.sogongSpring.repository.EntirePostRepository
import sogong.sogongSpring.repository.ScrapLikeRepository
import sogong.sogongSpring.repository.UserLoginRepository

@Service
class BoardPrintService {

    @Autowired
    private lateinit var entirePostRepository : EntirePostRepository
    @Autowired
    private lateinit var entireCommentRepository: EntireCommentRepository
    @Autowired
    private lateinit var userLoginRepository: UserLoginRepository
    @Autowired
    private lateinit var scrapLikeRepository: ScrapLikeRepository

    @RequestMapping
    fun printEntirePost() : MutableList<PrintEntirePostDto>{
        val postList : MutableList<PrintEntirePostDto> = ArrayList()
        val entirePost = entirePostRepository.findAll()
        entirePost.forEach{ i ->
            postList.add(PrintEntirePostDto(i.postId!!, i.userId.userId!!, i.subject
                , i.date, i.countComment, i.countLike))
        }
        return postList
    }

    @RequestMapping
    fun printComment(postId:Long):MutableList<EntireCommentDto>{
        val commentList : MutableList<EntireCommentDto> = ArrayList()
        val findPost = entirePostRepository.findById(postId)
        val findComment = entireCommentRepository.findByPostId(findPost.get())

        findComment.forEach { i ->
            commentList.add(
                EntireCommentDto(i.commentId, i.userId.userId!!,
                i.postId.postId!!, i.date, i.content)
            )
        }
        return commentList
    }

    @RequestMapping
    fun printScrapLike(userId:Long, scrapLike:Boolean):MutableList<PrintEntirePostDto>{
        val scrapLikeList : MutableList<PrintEntirePostDto> = ArrayList()
        val findUser = userLoginRepository.findById(userId)
        val findScrapLike = scrapLikeRepository.findByUserIdAndCategory(findUser.get(), scrapLike)

        findScrapLike.forEach { i ->
            scrapLikeList.add(
                PrintEntirePostDto(i.postId.postId!!, i.postId.userId.userId!!,
                    i.postId.subject, i.postId.date, i.postId.countComment, i.postId.countLike)
            )
        }
        return scrapLikeList
    }
}