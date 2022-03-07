package sogong.sogongSpring.controller

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import sogong.sogongSpring.dto.UserLoginDto
import sogong.sogongSpring.entity.BasicLoginEntity
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.service.BasicLoginService
import sogong.sogongSpring.service.UserLoginService
/*
@RestController // JSON 형태로 결과 반환해줌!
@RequiredArgsConstructor // final 객체를 Constructor Injection 해준다! (Autowire 역할)
@RequestMapping("/*")*/
 */

@Controller
class ContentsController {
    @GetMapping("")
    fun userLogin(){

    }


    /*
    private val userLoginService: UserLoginService
    private val basicLoginService: BasicLoginService

    constructor(userLoginService: UserLoginService, basicLoginService: BasicLoginService) {
        this.userLoginService = userLoginService
        this.basicLoginService = basicLoginService
    }

    @GetMapping("list")
    fun print(): UserLoginDto {
        val userList: List<UserLoginEntity> = userLoginService.findAllUser()
        val list: MutableList<UserLoginDto>

        println(userList[0])
        println("=======================================")
        println(userList.toList())

        return UserLoginDto(
            userList[0].userid,
            userList[0].name,
            userList[0].passwd,
            userList[0].bday,
            userList[0].phone,
            userList[0].social,
            userList[0].business,
            userList[0].sectors
        )
    }

    @GetMapping("save")
    fun saveUser(){
        val list = BasicLoginEntity(
            basicid = 1,
            userid =
        )
        basicLoginService.save()
    }*/

}
