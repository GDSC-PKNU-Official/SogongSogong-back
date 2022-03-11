package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.UserLoginEntity

@Repository
interface EntirePostRepository : JpaRepository<EntirePostEntity, Long> {
    fun findByPostIdAndUserId(postId:Long, userId:UserLoginEntity):List<EntirePostEntity>
}