package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.EntirePostEntity

@Repository
interface EntirePostRepository : JpaRepository<EntirePostEntity, Long> {
    fun findByContent(content:String):List<EntirePostEntity>
}