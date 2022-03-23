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
    @Query(value = "select distinct p.postId from PostHashtagEntity p where p.hashId in (:hashIds) order by p.postId DESC")
    fun findByHashIds(@Param("hashIds") hashIds:List<HashtagDbEntity>) : List<EntirePostEntity>

    @Query(value = "select hashId from POST_HASHTAG where postId = :postId", nativeQuery = true)
    fun findHashByPost(@Param("postId") postId:Long) : List<Long>

    @Query(value = "select * from POST_HASHTAG where postId = :postId", nativeQuery = true)
    fun findAllByPost(@Param("postId") postId:Long) : List<PostHashtagEntity>
}
