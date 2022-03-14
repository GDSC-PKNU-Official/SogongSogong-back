package sogong.sogongSpring.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import sogong.sogongSpring.dto.boardedit.EditPostCommentAuthDto
import sogong.sogongSpring.dto.board.EntireCommentDto
import sogong.sogongSpring.dto.board.EntirePostDto
import sogong.sogongSpring.dto.board.PostHashtagDto
import sogong.sogongSpring.dto.board.ScrapLikeDto
import sogong.sogongSpring.dto.boardedit.DeleteCommentDto
import sogong.sogongSpring.dto.boardedit.DeletePostDto
import sogong.sogongSpring.dto.boardprint.PrintEntirePostDto
import sogong.sogongSpring.entity.EntireCommentEntity
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.service.BoardService
import sogong.sogongSpring.service.BoardEditService
import sogong.sogongSpring.service.BoardPrintService


@RestController // JSON 형태로 결과 반환해줌!
//@RequiredArgsConstructor // final 객체를 Constructor Injection 해준다! (Autowire 역할)
@RequestMapping("/board")
class BoardController {
    var boardService : BoardService
    var boardServiceEdit : BoardEditService
    var boardPrintService : BoardPrintService

    constructor(boardService: BoardService, boardServiceEdit: BoardEditService, boardPrintService: BoardPrintService){
        this.boardService = boardService
        this.boardServiceEdit = boardServiceEdit
        this.boardPrintService = boardPrintService
    }

    @PostMapping("/registPost")
    fun registPost(@RequestBody entirePostDto : EntirePostDto): EntirePostEntity {
        return boardService.saveBoard(entirePostDto) //바로 Service로 갑니다^^
    }

    @PostMapping("/registPostHashtag")
    fun registPostHashtag(@RequestBody postHashtagDto: PostHashtagDto){
        boardService.savePostHashtag(postHashtagDto)
    }

    @PostMapping("/registComment")
    fun registComment(@RequestBody entireCommentDto : EntireCommentDto) : EntireCommentEntity{
        return boardService.saveComment(entireCommentDto)
    }

    @PostMapping("/saveScrapLike")
    fun registScrapLike(@RequestBody scrapLikeDto: ScrapLikeDto){
        boardService.saveScrapLike(scrapLikeDto)
    }

    @PostMapping(value = ["/editPostAuth", "/editCommentAuth"])
    fun editAuth(@RequestBody editPostCommentDto: EditPostCommentAuthDto) : Boolean{
        return boardServiceEdit.editAuth(editPostCommentDto)
    }

    @PostMapping("/editPost")
    fun editPost(@RequestBody editPostDto : EntirePostDto) : EntirePostEntity{
        return boardServiceEdit.editPost(editPostDto)
    }

    @PostMapping("/editComment")
    fun editComment(@RequestBody editCommentDto : EntireCommentDto) {
        boardServiceEdit.editComment(editCommentDto)
    }

    @PostMapping("/deleteComment")
    fun deleteComment(@RequestBody deleteCommentDto: DeleteCommentDto){
        boardServiceEdit.deleteComment(deleteCommentDto)
    }

    @PostMapping("/deletePost")
    fun deletePost(@RequestBody deletePostDto: DeletePostDto){
        boardServiceEdit.deletePost(deletePostDto)
    }

    @GetMapping("/printEntirePost")
    fun printPost(pageable: Pageable) : Page<EntirePostEntity> {
        return boardPrintService.printEntirePost(pageable)
    }

    @GetMapping("/printCommentByPost")
    fun printComment(@RequestParam("postId") postId : Long): MutableList<EntireCommentEntity>{
        return boardPrintService.printComment(postId)
    }

    @GetMapping("/printScrapLike")
    fun printScrapLike(@RequestParam("userId") userId:Long,
                       @RequestParam("scrapLike") scrapLike:Boolean) : MutableList<PrintEntirePostDto>{
        return boardPrintService.printScrapLike(userId, scrapLike)
    }

    @GetMapping("/printHotPost")
    fun printHotPost(pageable: Pageable) : List<EntirePostEntity>{
        return boardPrintService.printHotPost(pageable).content //content만 적용
    }

    @GetMapping("/printBestPost")
    fun printBestPost(pageable: Pageable) : Page<EntirePostEntity>{
        return boardPrintService.printBestPost(pageable) //page 전체만 적용
    }
}
