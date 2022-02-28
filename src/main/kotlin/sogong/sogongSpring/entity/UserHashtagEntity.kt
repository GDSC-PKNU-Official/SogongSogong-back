package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@NoArgsConstructor
@Table(name = "USER_HASHTAG")
class UserHashtagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val userhashid : Int,

    @ManyToOne
    @JoinColumn(name="userid", nullable = false)
    private val userid : UserLoginEntity,

    @Column(nullable = false)
    private var groupid : Int,

    @ManyToOne
    @JoinColumn(name="hashid", nullable = false)
    private var hashid : HashtagDbEntity
)