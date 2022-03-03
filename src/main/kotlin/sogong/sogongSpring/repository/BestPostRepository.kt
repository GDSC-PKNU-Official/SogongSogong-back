package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import sogong.sogongSpring.entity.BestPostEntity

interface BestPostRepository : JpaRepository<BestPostEntity, Long> {
}
