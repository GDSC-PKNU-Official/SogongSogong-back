package sogong.sogongSpring.entity

import javax.persistence.*

@Entity
@Table(name = "HASHTAG_DB")
data class HashtagDbEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val hashid : Int,

    @Column(nullable = false, length = 45)
    private val hashname : String
)