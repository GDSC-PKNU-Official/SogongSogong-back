package sogong.sogongSpring.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import sogong.sogongSpring.dto.user.BusinessAuthDto
import sogong.sogongSpring.service.UserService
import kotlin.Throws
import java.io.IOException

@RestController
@RequestMapping("/user")
class UserController {

    var userService : UserService
    constructor(userService: UserService){
        this.userService = userService
    }

    @GetMapping("/business")
    @Throws(IOException::class)
    fun validateBusiness(@RequestBody businessAuthDto: BusinessAuthDto) : Boolean{
        return userService.validateBusiness(businessAuthDto)
    }
}