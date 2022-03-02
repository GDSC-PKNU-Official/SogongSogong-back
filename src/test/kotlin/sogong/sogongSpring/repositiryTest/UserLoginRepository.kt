package sogong.sogongSpring.repositiryTest

import lombok.extern.slf4j.Slf4j
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import sogong.sogongSpring.entity.UserLoginEntity

@Slf4j  // 로깅에 대한 추상 레이어를 제공하는 인터페이스 모음
class UserLoginRepository {

    @Autowired
    private val userLoginRepository: sogong.sogongSpring.repository.UserLoginRepository? = null

    @Test
    fun create() {
        val userLoginEntity: UserLoginEntity.
    }
}