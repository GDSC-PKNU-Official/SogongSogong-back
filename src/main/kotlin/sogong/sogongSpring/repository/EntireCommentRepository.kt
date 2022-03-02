package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import sogong.sogongSpring.entity.EntireCommentEntity

interface EntireCommentRepository : JpaRepository<EntireCommentEntity, Int> {
}