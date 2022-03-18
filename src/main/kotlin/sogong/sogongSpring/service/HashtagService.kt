package sogong.sogongSpring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.hashtag.PostHashtagDto
import sogong.sogongSpring.dto.hashtag.UserHashTagDto
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.PostHashtagEntity
import sogong.sogongSpring.entity.UserHashtagEntity
import sogong.sogongSpring.repository.*
import java.lang.Math.abs
import javax.transaction.Transactional

@Service
class HashtagService {
    @Autowired
    private lateinit var postHashtagRepository: PostHashtagRepository
    @Autowired
    private lateinit var hashtagDbRepository: HashtagDbRepository
    @Autowired
    private lateinit var entirePostRepository : EntirePostRepository
    @Autowired
    private lateinit var userHashtagRepository: UserHashtagRepository
    @Autowired
    private lateinit var userLoginRepository: UserLoginRepository

    @Transactional
    fun savePostHashtag(postHashtagDto: PostHashtagDto){
        val hashIds = hashtagDbRepository.findByHashNames(postHashtagDto.hashName)
        val postId = entirePostRepository.findById(postHashtagDto.postId)
        hashIds.forEach { i ->
            val postHashtagEntity = PostHashtagEntity(hashId=i, postId=postId.get())
            postHashtagRepository.save(postHashtagEntity)
        }
    }

    @Transactional
    fun saveUserHashtag(userHashTagDto: UserHashTagDto){
        val user = userLoginRepository.findById(userHashTagDto.userId)

        if(user.isEmpty) throw java.lang.IllegalArgumentException("UserId Error!!")
        else{
            if(hashtagDbRepository.findByHashNames(userHashTagDto.hashName).isEmpty()) throw IllegalArgumentException("HashTag Error!!")
            else {
                for(hash in userHashTagDto.hashName)
                    userHashtagRepository.save(
                        UserHashtagEntity(userId = user.get(), hashName = hash, groupId = userHashTagDto.groupId)
                    )
            }
        }
    }

    @Transactional
    fun editUserHashtag(userHashTagDto: UserHashTagDto){
        val user = userLoginRepository.findById(userHashTagDto.userId)

        //uid 점검은 했는데... hashName 점검을 안했네... 해시가 정해져있는거면 굳이 필요없는 것 같기도
        if(user.isEmpty) throw java.lang.IllegalArgumentException("UserId Error!!!")
        else {
            val uhrs = userHashtagRepository.findByUserIdAndGroupId(user.get(), userHashTagDto.groupId)
            val hash = userHashTagDto.hashName
            var difAndSize = uhrs.size-hash.size

            if(difAndSize>0){ //ex)해시태그 4->2개로
                for(i:Int in 1..difAndSize)
                    userHashtagRepository.delete(uhrs[uhrs.size-i])
                difAndSize = hash.size-1
            }
            else if (difAndSize<0){ //ex)해시태그 2->5개로
                for(i:Int in 1..abs(difAndSize)){
                    userHashtagRepository.save(
                        UserHashtagEntity(
                            userId = user.get(), groupId = userHashTagDto.groupId,
                            hashName = userHashTagDto.hashName[hash.size-i]))
                }
                difAndSize = uhrs.size-1
            }
            else difAndSize=uhrs.size-1 //ex)해시태그 2->2개로

            for (i:Int in 0..difAndSize){
                uhrs.get(i).hashName = hash.get(i)
                userHashtagRepository.save(uhrs.get(i))
            }
        }
    }

    @Transactional
    fun editPostHashtag(postHashtagDto: PostHashtagDto){
        val original = postHashtagRepository.findAllByPost(postHashtagDto.postId)
        val hashes = hashtagDbRepository.findByHashNames(postHashtagDto.hashName)
        for (i:Int in 0 until original.size)
            postHashtagRepository.save(
                PostHashtagEntity(
                    postHashId = original[i].postHashId,
                    postId = original[i].postId,
                    hashId = hashes[i]
                )
            )

    }

    @Transactional
    fun searchOrPost(hashtags: List<String>) : List<EntirePostEntity> {
        val hashIds = hashtagDbRepository.findByHashNames(hashtags)
        return postHashtagRepository.findByHashIds(hashIds) //Dto로 변경?
    }

    @Transactional
    fun printPostHashtag(postId: Long) : List<String>{
        val hashes = hashtagDbRepository.findAllById(postHashtagRepository.findHashByPost(postId))
        if(hashes.isEmpty()) throw java.lang.IllegalArgumentException("postId Error!!")
        else{ return hashes.map { hash -> hash.hashName } }
    }

    @Transactional
    fun printUserHashtag(userId: Long, groupId: Long) : List<UserHashtagEntity>{
        val user = userLoginRepository.findById(userId)
        if(user.isEmpty) throw java.lang.IllegalArgumentException("UserId Error!!")
        else{ return userHashtagRepository.findByUserIdAndGroupId(user.get(), groupId) }
    }

}
