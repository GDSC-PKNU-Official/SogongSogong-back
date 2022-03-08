package sogong.sogongSpring.controller

import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import sogong.sogongSpring.dto.EntireCommentDto
import sogong.sogongSpring.dto.EntirePostDto
import sogong.sogongSpring.dto.ScrapLikeDto
import sogong.sogongSpring.entity.EntireCommentEntity
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.ScrapLikeEntity
import sogong.sogongSpring.service.BoardService


@RestController // JSON 형태로 결과 반환해줌!
//@RequiredArgsConstructor // final 객체를 Constructor Injection 해준다! (Autowire 역할)
@RequestMapping("/board")
class BoardController {
    var boardService : BoardService

    constructor(boardService: BoardService){
        this.boardService = boardService
    }

    @PostMapping("/registPost")
    fun registPost(@RequestBody entirePostDto : EntirePostDto): MutableList<EntirePostEntity> {
        return boardService.saveBoard(entirePostDto) //바로 Service로 갑니다^^
    }

    @PostMapping("/registComment")
    fun registComment(@RequestBody entireCommentDto : EntireCommentDto) : MutableList<EntireCommentEntity>{
        return boardService.saveComment(entireCommentDto)
    }

    @PostMapping("/saveScrapLike")
    fun registScrapLike(@RequestBody scrapLikeDto: ScrapLikeDto) : MutableList<ScrapLikeEntity>{
        return boardService.saveScrapLike(scrapLikeDto)
    }

}
