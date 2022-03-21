package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner.Mode
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.boardprint.PrintEntirePostDto
import sogong.sogongSpring.entity.EntireCommentEntity
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.ScrapLikeEntity
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
    fun printEntirePost(lastPost:Long?) : List<EntirePostEntity> {
        return if(lastPost==null) entirePostRepository.findEntirePost()
        else entirePostRepository.findEntirePostByLastId(lastPost)
    }

    @RequestMapping
    fun printOnePost(postId:Long) : EntirePostEntity{
        val post = entirePostRepository.findById(postId)
        if (post.isEmpty) throw IllegalArgumentException("PostId Error!!!")
        else return post.get()
    }

    //DTO로 바꿀것!!!
    @RequestMapping
    fun printComment(postId:Long, lastCom:Long?):List<EntireCommentEntity>{
        return if(lastCom==null) entireCommentRepository.selectPost(postId)
        else entireCommentRepository.selectPostByCommentId(postId, lastCom)
    }


    @RequestMapping
    fun printScrapLike(userId:Long, scrapLike:Boolean, lastScrap:Long?):List<PrintEntirePostDto>{
        var scrapLikeList : List<PrintEntirePostDto>
        val findUser = userLoginRepository.findById(userId) //exception용
        var findScrapLike : List<ScrapLikeEntity> =
            if(lastScrap==null) scrapLikeRepository.findByUserIdAndCategory(userId, scrapLike)
            else scrapLikeRepository.findByUserIdAndCategoryAndCommentId(userId, scrapLike, lastScrap)

        scrapLikeList = findScrapLike.map{ f ->
            PrintEntirePostDto(
                f.scrapId ?: 0L,
                f.postId.postId ?: 0L,
                f.postId.userId.userId ?: 0L,
                f.postId.subject,
                f.postId.date,
                f.postId.countComment,
                f.postId.countLike)
        }

        return scrapLikeList
    }

    //N+1 occurred
    @RequestMapping
    fun printHotPost(lastPost: Long?) : List<EntirePostEntity>{
        var hotPost : List<EntirePostEntity> =
            if (lastPost == null) entirePostRepository.findHotPost(10)
            else entirePostRepository.findHotPostByPost(10, lastPost)
        return hotPost
    }

    //N+1 occurred
    @RequestMapping
    fun printBestPost(lastPost: Long?) : List<EntirePostEntity>{
        var bestPost : List<EntirePostEntity> =
            if (lastPost == null) entirePostRepository.findHotPost(10)
            else entirePostRepository.findHotPostByPost(10, lastPost)
        return bestPost
    }
}