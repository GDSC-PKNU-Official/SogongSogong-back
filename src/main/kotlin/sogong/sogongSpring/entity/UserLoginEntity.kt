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
    private val userid: Long? = null,

    @Column(length = 45, nullable = false)
    private val name: String,

    @Column(nullable = true)
    private var passwd: String? = null,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private var bday: Date,

    @Column(length = 11, nullable = false)
    private val phone: String,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private val social: Boolean,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private var business: Boolean,

    @Column(length = 50)
    private var sectors: String? = null
)