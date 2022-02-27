package sogong.sogongSpring.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class ContentsController {
    @GetMapping
    fun testpage():ResponseEntity<String>{
        val hello = "Hello!! API!! 하이하이!!"
        return ResponseEntity.ok(hello)
    }
}