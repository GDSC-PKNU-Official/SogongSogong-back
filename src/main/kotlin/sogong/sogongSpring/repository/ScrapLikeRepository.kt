package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.*

@Repository
interface ScrapLikeRepository : JpaRepository<ScrapLikeEntity, Long> {
    fun findByUserIdAndPostIdAndCategory(userId:UserLoginEntity, postId:EntirePostEntity, category:Boolean) : ScrapLikeEntity?
    fun findByPostId(postId:EntirePostEntity):List<ScrapLikeEntity>
//    fun findByUserIdAndCategory(userId:UserLoginEntity, category: Boolean):List<ScrapLikeEntity>

    @Query("select * from SCRAP_LIKE where userId = :userId and category = :category " +
            "order by scrapId desc limit 7"
        ,nativeQuery=true)
    fun findByUserIdAndCategory(@Param("userId") userId:Long, @Param("category") scrapLike:Boolean) : List<ScrapLikeEntity>

    @Query("select * from SCRAP_LIKE where userId = :userId and category = :category and scrapId < :scrapId " +
            "order by scrapId desc limit 7"
        ,nativeQuery=true)
    fun findByUserIdAndCategoryAndCommentId(@Param("userId") userId:Long,
                                            @Param("category") scrapLike:Boolean,
                                            @Param("scrapId") last_Scrap:Long) : List<ScrapLikeEntity>

}
