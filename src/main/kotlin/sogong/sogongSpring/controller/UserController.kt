package sogong.sogongSpring.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import sogong.sogongSpring.dto.user.*
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.service.PasswordNotMatchException
import sogong.sogongSpring.service.UserLoginService
import sogong.sogongSpring.service.UserNotFoundException
import sogong.sogongSpring.service.UserService
import kotlin.Throws
import java.io.IOException

@RestController
@RequestMapping("/user")
class UserController (val userService: UserService,
                      val userLoginService: UserLoginService,
                      val passwordEncoder: PasswordEncoder) {

    @GetMapping("/business")
    @Throws(IOException::class)
    fun validateBusiness(@RequestBody businessAuthDto: BusinessAuthDto) : Boolean{
        return userService.validateBusiness(businessAuthDto)
    }

    @PostMapping("/regist")
    @Throws(IOException::class)
    fun register(@RequestBody userRegisterReq:UserRegisterReq) : ResponseEntity<UserRegisterRes>{
        //userLoginService.existUser(userRegistReq.email)
        userRegisterReq.password = passwordEncoder.encode(userRegisterReq.password)
        return ResponseEntity.ok(userLoginService.createUser(userRegisterReq))
    }

    @PostMapping("/login")
    @Throws(IOException::class)
    fun login(@RequestBody userLoginReq: UserLoginReq) : ResponseEntity<UserLoginRes>{
        if(!userLoginService.existUser(userLoginReq.email)){
            throw UserNotFoundException()
        }
        val user:UserLoginEntity = userLoginService.findUser(userLoginReq.email)

        if(!passwordEncoder.matches(userLoginReq.password, user.password)){
            throw PasswordNotMatchException()
        }
        return ResponseEntity.ok(userLoginService.login(userLoginReq))
    }
}