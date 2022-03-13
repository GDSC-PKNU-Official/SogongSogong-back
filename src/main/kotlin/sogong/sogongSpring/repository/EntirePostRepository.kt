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

    @Query(value = "select * from entire_post where countComment >= :countComment", nativeQuery = true)
    fun findHotPost(@Param(value="countComment") countComment : Int, pageable: Pageable) : Page<EntirePostEntity>

    @Query(value = "select * from entire_post where countLike >= :countLike", nativeQuery = true)
    fun findBestPost(@Param(value="countLike") countLike : Int, pageable: Pageable) : Page<EntirePostEntity>
}