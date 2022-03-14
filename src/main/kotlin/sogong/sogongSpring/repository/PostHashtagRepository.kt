package sogong.sogongSpring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sogong.sogongSpring.entity.PostHashtagEntity

@Repository
interface PostHashtagRepository : JpaRepository<PostHashtagEntity, Long> {
}
