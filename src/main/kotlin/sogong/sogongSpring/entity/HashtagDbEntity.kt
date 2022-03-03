package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "HASHTAG_DB")
class HashtagDbEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val hashid : Long,

    @Column(nullable = false, length = 45)
    private val hashname : String
)