package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import sogong.sogongSpring.entity.*

interface HotPostRepository : JpaRepository<HotPostEntity, Int> {
}
