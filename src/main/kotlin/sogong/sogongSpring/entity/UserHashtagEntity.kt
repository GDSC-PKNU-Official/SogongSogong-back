package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@NoArgsConstructor
@Table(name = "USER_HASHTAG")
data class UserHashtagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userHashId : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId", nullable = false)
    val userId : UserLoginEntity,

    @Column(nullable = false)
    var groupId : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hashId", nullable = false)
    var hashId : HashtagDbEntity
)