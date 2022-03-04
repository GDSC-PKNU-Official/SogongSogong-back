package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.BasicLoginEntity

@Repository
interface BasicLoginRepository : JpaRepository<BasicLoginEntity, Long> {
}