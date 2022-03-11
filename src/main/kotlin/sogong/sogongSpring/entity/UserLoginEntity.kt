package sogong.sogongSpring.entity

import lombok.Getter
import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

//FK Fetch type 차차 수정할 것!
@Entity
@NoArgsConstructor
@Table(name = "USER_LOGIN")
data class UserLoginEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val userId: Long? = null,

    @Column(length = 45, nullable = false)
    val name: String,

    @Column(nullable = true)
    var passwd: String? = null,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var bday: Date,

    @Column(length = 11, nullable = false)
    val phone: String,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    val social: Boolean,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    var business: Boolean,

    @Column(length = 50)
    var sectors: String? = null
)