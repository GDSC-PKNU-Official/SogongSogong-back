package sogong.sogongSpring.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.user.UserLoginReq
import sogong.sogongSpring.dto.user.UserLoginRes
import sogong.sogongSpring.dto.user.UserRegisterReq
import sogong.sogongSpring.dto.user.UserRegisterRes
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.repository.UserLoginRepository
import sogong.sogongSpring.security.JwtTokenIssue
import java.util.InputMismatchException

@Service
class UserLoginService(private val userLoginRepository: UserLoginRepository,
                       private val jwtTokenIssue: JwtTokenIssue){

    fun findUser(email:String) : UserLoginEntity{
        return userLoginRepository.findByEmail(email).orElseThrow{ InputMismatchException()}
    }

    fun existUser(email:String) : Boolean{
        return userLoginRepository.existsByEmail(email).orElseThrow{ InputMismatchException()}
    }

    fun createUser(userRegisterReq : UserRegisterReq) : UserRegisterRes {
        val user = UserLoginEntity(name = userRegisterReq.name, email = userRegisterReq.email, passwd= userRegisterReq.password)
        userLoginRepository.save(user)

        return UserRegisterRes(user.name, user.email)
    }

    fun login(userLoginReq : UserLoginReq) : UserLoginRes {
        val token:String = jwtTokenIssue.createToken(userLoginReq.email)
        return UserLoginRes(HttpStatus.OK, token)
    }

}