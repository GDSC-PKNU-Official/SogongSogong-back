package sogong.sogongSpring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import sogong.sogongSpring.dto.UserLoginDto
import sogong.sogongSpring.entity.UserLoginEntity
import sogong.sogongSpring.repository.UserLoginRepository
import java.util.*

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //걍 DB 오류나서 넣음. 테스트라서 db 설정이 좀 다른듯.
class Test {
    @Autowired
    lateinit var loginR : UserLoginRepository

    @org.junit.jupiter.api.Test
    fun test(){
        val date = Date()
        var loginRequest : UserLoginDto = UserLoginDto(
            name ="Chodakk1", bday =date, phone ="01022224444", business =false, social =true
        ) //Dto를 대충 저장해보자

        //그냥 Entity에 Dto값 대입하자~ id값 없어도 됨.
        var loginE = UserLoginEntity(
            name=loginRequest.name,
            bday=loginRequest.bday,
            phone=loginRequest.phone,
            business = loginRequest.business,
            social=true,
            sectors = loginRequest.sectors //@Param에 sector 값 없어도 null값을 자동으로 넣어준다~
        )

        println("============================Save 잘 되나요==============================")
        var reallogin = loginR.save(loginE)
        println(reallogin)
        println("============================findAll 잘 되나요==============================")
        println(loginR.findAll()) //참조값으로 나오는듯
        println("============================findByName 잘 되나요==============================")
        val testfindByName = loginR.findByName("Chodakk")//위에서 입력한 값이 아닌 미리 db에 값이 저장됨.
        println(testfindByName)
    }
}