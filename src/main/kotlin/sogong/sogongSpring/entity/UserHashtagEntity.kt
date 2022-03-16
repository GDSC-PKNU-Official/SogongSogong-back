package sogong.sogongSpring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @JsonIgnore
    @JoinColumn(name="userId", nullable = false)
    val userId : UserLoginEntity,

    @Column(nullable = false)
    val groupId : Long,

    @Column(nullable = false)
    var hashName : String
)