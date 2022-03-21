package sogong.sogongSpring.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.UserLoginEntity

@Repository
interface EntirePostRepository : JpaRepository<EntirePostEntity, Long> {
    fun findByPostIdAndUserId(postId:Long, userId:UserLoginEntity):MutableList<EntirePostEntity>

    @Query(value = "select * from ENTIRE_POST where countComment >= :countComment " +
            "order by postId desc limit 6", nativeQuery = true)
    fun findHotPost(@Param(value="countComment") countComment : Int) : List<EntirePostEntity>

    @Query(value = "select * from ENTIRE_POST where countComment >= :countComment and postId < :postId " +
            "order by postId desc limit 6", nativeQuery = true)
    fun findHotPostByPost(@Param(value="countComment") countComment : Int,
                     @Param(value="postId") lastPost : Long) : List<EntirePostEntity>

    @Query(value = "select * from ENTIRE_POST where countLike >= :countLike " +
            "order by postId desc limit 6", nativeQuery = true)
    fun findBestPost(@Param(value="countLike") countLike : Int) : List<EntirePostEntity>

    @Query(value = "select * from ENTIRE_POST where countLike >= :countLike and postId < :postId " +
            "order by postId desc limit 6", nativeQuery = true)
    fun findBestPostByPost(@Param(value="countLike") countLike : Int,
                     @Param(value="postId") lastPost : Long) : List<EntirePostEntity>

    @Query(value = "select * from ENTIRE_POST where postId < :postId order by postId desc limit 7",
        nativeQuery=true)
    fun findEntirePostByLastId(@Param("postId") lastPost:Long) : List<EntirePostEntity>

    @Query(value = "select * from ENTIRE_POST order by postId desc limit 7", nativeQuery=true)
    fun findEntirePost():List<EntirePostEntity>
}