package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@NoArgsConstructor
@Table(name = "USER_HASHTAG")
data class UserHashtagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userhashid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userid", nullable = false)
    val userid : UserLoginEntity,

    @Column(nullable = false)
    var groupid : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hashid", nullable = false)
    var hashid : HashtagDbEntity
)