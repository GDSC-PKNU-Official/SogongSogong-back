package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import sogong.sogongSpring.entity.EntirePostEntity

interface EntirePostRepository : JpaRepository<EntirePostEntity, Int> {
}