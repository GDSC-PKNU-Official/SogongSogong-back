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
    @Autowired //글을 저장하려는 변수
    lateinit var entirePostRepository : EntirePostRepository
    @Autowired //글을 저장할 때 userid가 유효한지 검증하려는 변수
    lateinit var userLoginRepository : UserLoginRepository

    //MutableList<EntirePostEntity>로 반환하면 Json 형태로 잘 돌려보내줘요.
    fun saveBoard(entirePostDto: EntirePostDto): MutableList<EntirePostEntity> {

        //Board DTO에 저장된 userid를 User Repository에 조회해보자!
        val postUserId = userLoginRepository.findById(entirePostDto.userid)

        //userid가 조회가 될 때!
        if (postUserId.isPresent) {
            //DTO를 EntirePostEntity에 저장해라.
            var entirePostEntity = EntirePostEntity(
                userid = postUserId.get(), //위에서 userid를 조회한 객체를 Entity의 userid 값으로 넣자!
                subject = entirePostDto.subject, //나머지들은 그냥 있는 그대로 넣기.
                content = entirePostDto.content,
                date = Date(), //얘는 수정할거임 나중에.
                picture = entirePostDto.picture,
                hashtag = entirePostDto.hashtag,
                countcomment = entirePostDto.countcomment,
                countlike = entirePostDto.countlike
            )
            var aa = entirePostRepository.save(entirePostEntity) //자 이제 Repository에 저장해주세요
            return entirePostRepository.findAll() //전체 글 조회해주세요^^
        }
        //userid가 조회가 되지 않을 때!
        else {
            throw java.lang.IllegalArgumentException("Userid Error!!!!") //응 userid 잘못된거니까 던져
        }
    }
}