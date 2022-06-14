package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
//import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
//import java.util.*
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

//FK Fetch type 차차 수정할 것!
@Entity
@NoArgsConstructor
@Table(name = "USER_LOGIN")
class UserLoginEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val userId: Long? = null,

    @Column(length = 45, nullable = false)
    val name: String,

    @Column(length = 45, nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    var passwd: String

//    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    var bday: Date,
//
//    @Column(length = 11, nullable = false)
//    val phone: String,
//
//    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
//    val social: Boolean,
//
//    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
//    var business: Boolean,
//
//    @Column(length = 50)
//    var sectors: String? = null
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String {
        return passwd
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}