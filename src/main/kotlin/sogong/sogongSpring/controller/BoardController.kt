package sogong.sogongSpring.controller

import org.springframework.web.bind.annotation.*
import sogong.sogongSpring.dto.boardedit.EditPostCommentAuthDto
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.board.EntirePostDto
import sogong.sogongSpring.dto.board.ScrapLikeDto
import sogong.sogongSpring.dto.boardedit.DeleteCommentDto
import sogong.sogongSpring.dto.boardedit.EditCommentDto
import sogong.sogongSpring.dto.boardedit.EditPostDto
import sogong.sogongSpring.dto.boardprint.PrintEntirePostDto
import sogong.sogongSpring.entity.EntireCommentEntity
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.service.BoardService
import sogong.sogongSpring.service.BoardEditService
import sogong.sogongSpring.service.BoardPrintService


@RestController // JSON 형태로 결과 반환해줌!
@RequestMapping("/board")
class BoardController (var boardService: BoardService, var boardServiceEdit: BoardEditService, var boardPrintService : BoardPrintService){

    @PostMapping("/post")
    fun registPost(@RequestBody entirePostDto : EntirePostDto){
        boardService.saveBoard(entirePostDto) //바로 Service로 갑니다^^
    }

    @PostMapping("/comment")
    fun registComment(@RequestBody entireCommentDto : EntireCommentDto){
        boardService.saveComment(entireCommentDto)
    }

    @PostMapping("/scrap-like")
    fun registScrapLike(@RequestBody scrapLikeDto: ScrapLikeDto){
        boardService.saveOrDeleteScrapLike(scrapLikeDto)
    }

   @GetMapping(value = ["/post-auth", "/comment-auth"])
    fun editAuth(@RequestParam("user-id") userId:Long, @RequestParam("post-id") postid:Long,
                 @RequestParam("comment-id") commentid:Long?=null) : Boolean{
        return boardServiceEdit.editAuth(EditPostCommentAuthDto(
            postId=postid, userId=userId, commentId=commentid))
    }

    @PutMapping("/post/{postId}")
    fun editPost(@PathVariable postId:Long, @RequestBody editPostDto:EditPostDto){
        boardServiceEdit.editPost(postId, editPostDto)
    }

    @PutMapping("/comment/{commentId}")
    fun editComment(@PathVariable commentId:Long, @RequestBody editCommentDto:EditCommentDto) {
        boardServiceEdit.editComment(commentId, editCommentDto)
    }

    @DeleteMapping("/comment/{commentId}")
    fun deleteComment(@PathVariable commentId : Long, @RequestParam("post-id") postId: Long){
        val deleteCommentDto = DeleteCommentDto(commentId, postId)
        boardServiceEdit.deleteComment(deleteCommentDto)
    }

    @DeleteMapping("/post/{postId}")
    fun deletePost(@PathVariable postId: Long){
        boardServiceEdit.deletePost(postId)
    }

    @GetMapping("/print/all")
    fun printPost(@RequestParam("last") lastPost:Long?=null) : List<EntirePostEntity>{
        return boardPrintService.printEntirePost(lastPost)
    }

    @GetMapping("/print/post")
    fun printOnePost(@RequestParam("id") postId:Long) : EntirePostEntity{
        return boardPrintService.printOnePost(postId)
    }

    @GetMapping("/print/comment")
    fun printComment(@RequestParam("id") postId:Long,
                     @RequestParam("last") lastCom:Long?=null):List<EntireCommentEntity>{
        return boardPrintService.printComment(postId, lastCom)
    }

    @GetMapping("/print/scrap-like")
    fun printScrapLike(@RequestParam("id") userId:Long,
                       @RequestParam("scrap-like") scrapLike:Boolean,
                       @RequestParam("last") lastScrap:Long?=null) : List<PrintEntirePostDto>{
        return boardPrintService.printScrapLike(userId, scrapLike, lastScrap)
    }

    @GetMapping("/print/hot")
    fun printHotPost(@RequestParam("last-post") lastPost:Long?=null) : List<EntirePostEntity>{
        return boardPrintService.printHotPost(lastPost)
    }

    @GetMapping("/print/best")
    fun printBestPost(@RequestParam("last-post") lastPost:Long?=null) : List<EntirePostEntity>{
        return boardPrintService.printBestPost(lastPost)
    }

    @GetMapping("/test")
    fun aatest():String{return "Success"}
}
