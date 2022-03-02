package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import sogong.sogongSpring.entity.HashtagDbEntity

interface HashtagDbRepository : JpaRepository<HashtagDbEntity, Int> {
}