package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.repository.UserLoginRepository

@Service
class UserLoginService {
    @Autowired
    private val userLoginRepository: UserLoginRepository

    @Autowired
    constructor(userLoginRepository: UserLoginRepository){
        this.userLoginRepository = userLoginRepository
    }


}