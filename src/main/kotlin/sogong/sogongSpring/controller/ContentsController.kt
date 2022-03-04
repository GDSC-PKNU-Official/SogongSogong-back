package sogong.sogongSpring.controller

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import sogong.sogongSpring.dto.BasicLoginDto
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.repository.UserLoginRepository
import sogong.sogongSpring.service.UserLoginService

@RestController // JSON 형태로 결과 반환해줌!
@RequiredArgsConstructor // final 객체를 Constructor Injection 해준다! (Autowire 역할)
@RequestMapping("/*")
class ContentsController {
    private val userLoginService: UserLoginService

    constructor(userLoginService: UserLoginService) {
        this.userLoginService = userLoginService
    }

    // 회원명단 조회
    @GetMapping("list")
    fun List(): List<UserLoginEntity> {
        val userList: List<UserLoginEntity> = userLoginService.findAllUser()
        val user = userList.forEach(::println)
//        println("------------")
//        for(i in userList){
//            println(i)
//        }
        return userList
    }


}
