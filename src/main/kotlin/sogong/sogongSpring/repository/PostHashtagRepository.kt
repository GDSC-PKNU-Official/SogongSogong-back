package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.HashtagDbEntity
import sogong.sogongSpring.entity.PostHashtagEntity

@Repository
interface PostHashtagRepository : JpaRepository<PostHashtagEntity, Long> {
    @Query(value = "select distinct postId from POST_HASHTAG where hashId in (:hashIds) " +
            "order by postId desc limit 20"
        ,nativeQuery=true)
    fun findByHashIds(@Param("hashIds") hashIds:List<Long?>) : List<Long>

    @Query(value = "select distinct postId from POST_HASHTAG where hashId in (:hashIds) and postId < :postId " +
            "order by postId desc limit 20"
        , nativeQuery=true)
    fun findByHashIdsByPost(@Param("hashIds") hashIds:List<Long?>, @Param("postId") lastPost:Long) : List<Long>

    @Query(value = "select hashId from POST_HASHTAG where postId = :postId", nativeQuery = true)
    fun findHashByPost(@Param("postId") postId:Long) : List<Long>

    @Query(value = "select * from POST_HASHTAG where postId = :postId", nativeQuery = true)
    fun findAllByPost(@Param("postId") postId:Long) : List<PostHashtagEntity>
}
