package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.BasicLoginDto
import sogong.sogongSpring.entity.BasicLoginEntity
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.repository.BasicLoginRepository

@Service
class BasicLoginService {
    @Autowired
    val basicLoginRepository: BasicLoginRepository

    @Autowired
    constructor(basicLoginRepository: BasicLoginRepository){
        this.basicLoginRepository = basicLoginRepository
    }

    fun save(basicLoginDto: BasicLoginDto) {

//        basicLoginRepository.save()
    }

    fun findAll() = basicLoginRepository.findAll()

}