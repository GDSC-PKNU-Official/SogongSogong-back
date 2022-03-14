package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.hashtag.PostHashtagDto
import sogong.sogongSpring.entity.PostHashtagEntity
import sogong.sogongSpring.repository.EntirePostRepository
import sogong.sogongSpring.repository.HashtagDbRepository
import sogong.sogongSpring.repository.PostHashtagRepository
import javax.transaction.Transactional

@Service
class HashtagService {
    @Autowired
    private lateinit var postHashtagRepository: PostHashtagRepository
    @Autowired
    private lateinit var hashtagDbRepository: HashtagDbRepository
    @Autowired
    private lateinit var entirePostRepository : EntirePostRepository

    @Transactional
    fun savePostHashtag(postHashtagDto: PostHashtagDto){
        val hashIds = hashtagDbRepository.findByHashNames(postHashtagDto.hashName)
        val postId = entirePostRepository.findById(postHashtagDto.postId)
        hashIds.forEach { i ->
            val postHashtagEntity = PostHashtagEntity(hashId=i, postId=postId.get())
            postHashtagRepository.save(postHashtagEntity)
        }
    }
}