package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.entity.ImgEntity
import sogong.sogongSpring.repository.ImgRepository
import java.sql.Blob
import javax.transaction.Transactional

@Service
class ImgService {
    @Autowired
    private lateinit var imgRepository: ImgRepository

    @Transactional
    fun saveImg(map: Blob){
        imgRepository.save(ImgEntity(pic = map))
    }
}