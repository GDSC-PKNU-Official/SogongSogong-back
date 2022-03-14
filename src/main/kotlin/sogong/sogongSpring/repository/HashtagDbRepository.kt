package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.HashtagDbEntity

@Repository
interface HashtagDbRepository : JpaRepository<HashtagDbEntity, Long> {
    @Query(value = "select * from hashtag_db as h where h.hashName in (:hashName)", nativeQuery = true)
    fun findByHashNames(@Param("hashName") hashName:List<String>) : List<HashtagDbEntity>
}