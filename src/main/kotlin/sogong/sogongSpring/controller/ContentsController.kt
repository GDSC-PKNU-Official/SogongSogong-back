package sogong.sogongSpring.controller

import org.springframework.boot.web.server.Cookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import sogong.sogongSpring.entity.UserLoginEntity


@RestController
@RequestMapping("/")
class ContentsController {
    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    fun userLogin(
        userLoginEntity: UserLoginEntity,
        @CookieValue(value = "REMEMBER", required = false)
        rememberCookie: Cookie
    ) {
    }
}
