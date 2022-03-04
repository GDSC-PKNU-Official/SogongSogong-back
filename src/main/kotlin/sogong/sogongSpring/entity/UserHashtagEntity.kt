package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@NoArgsConstructor
@Table(name = "USER_HASHTAG")
class UserHashtagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val userhashid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userid", nullable = false)
    private val userid : UserLoginEntity,

    @Column(nullable = false)
    private var groupid : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hashid", nullable = false)
    private var hashid : HashtagDbEntity
) {
    override fun toString(): String {
        return "UserHashtagEntity(userhashid=$userhashid, userid=$userid, groupid=$groupid, hashid=$hashid)"
    }
}