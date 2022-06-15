package sogong.sogongSpring.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import sogong.sogongSpring.repository.UserLoginRepository
import java.util.InputMismatchException

@Service
class UserDetailService(private val userLoginRepository: UserLoginRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userLoginRepository.findByEmail(username).orElseThrow{InputMismatchException()}
    }

}