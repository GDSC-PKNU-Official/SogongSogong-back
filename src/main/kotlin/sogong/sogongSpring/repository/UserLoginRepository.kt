package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.UserLoginEntity
import java.util.*

/**
 * 로그인 페이지에서 CRUD가 무엇이 필요할까?
 * Userid, PWD
 */

@Repository
interface UserLoginRepository: JpaRepository<UserLoginEntity, Long> {
    fun findByEmail(email:String):Optional<UserLoginEntity>
    fun existsByEmail(email:String):Optional<Boolean>
}