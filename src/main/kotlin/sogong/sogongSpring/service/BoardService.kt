package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.EntirePostDto
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.repository.EntirePostRepository
import sogong.sogongSpring.repository.UserLoginRepository
import java.util.*


@Service
class BoardService {
    @Autowired
    lateinit var entirePostRepository : EntirePostRepository
    @Autowired
    lateinit var userLoginRepository : UserLoginRepository

//    @Autowired
//    constructor(entirePostRepository: EntirePostRepository, userLoginRepository: UserLoginRepository){
//        this.entirePostRepository = entirePostRepository
//        this.userLoginRepository = userLoginRepository
//    }

    fun saveBoard(entirePostDto: EntirePostDto): MutableList<EntirePostEntity> {
        val postUserId = userLoginRepository.findById(entirePostDto.userid)
        if (postUserId.isPresent) {
            var entirePostEntity = EntirePostEntity(
                userid = postUserId.get(),
                subject = entirePostDto.subject,
                content = entirePostDto.content,
                date = Date(),
                picture = entirePostDto.picture,
                hashtag = entirePostDto.hashtag,
                countcomment = entirePostDto.countcomment,
                countlike = entirePostDto.countlike
            )
            var aa = entirePostRepository.save(entirePostEntity)
            return entirePostRepository.findAll()
        }
        else {
            throw java.lang.IllegalArgumentException("Userid Error!!!!")
        }
    }
}