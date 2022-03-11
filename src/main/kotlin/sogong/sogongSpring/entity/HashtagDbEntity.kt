package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "HASHTAG_DB")
data class HashtagDbEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val hashId : Long? = null,

    @Column(nullable = false, length = 45)
    val hashName : String
)