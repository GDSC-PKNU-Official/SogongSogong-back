package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.*

@Repository
interface ScrapLikeRepository : JpaRepository<ScrapLikeEntity, Long> {
    fun findByUserIdAndPostIdAndCategory(userId:UserLoginEntity, postId:EntirePostEntity, category:Boolean) : ScrapLikeEntity?
    fun findByPostId(postId:EntirePostEntity):List<ScrapLikeEntity>
    fun findByUserIdAndCategory(userId:UserLoginEntity, category: Boolean):List<ScrapLikeEntity>
}
