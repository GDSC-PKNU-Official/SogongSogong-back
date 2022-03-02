package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.UserLoginEntity

/**
 * 로그인 페이지에서 CRUD가 무엇이 필요할까?
 * Userid, PWD
 */

@Repository
interface UserLoginRepository: JpaRepository<UserLoginEntity, Int> {
}