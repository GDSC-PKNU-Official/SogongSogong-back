package sogong.sogongSpring.entity

import java.text.DateFormat
import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
@Table(name="USER_LOGIN")
data class UserLoginEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private val id : Int,

    @Column(length = 45, nullable = false)
    private val name : String,

    @Column(nullable = false)
    private val bday : DateFormat,

    @Column(length = 11, nullable = false)
    private val phone : String,

    @Column(nullable = false)
    private val social : Boolean,

    @Column(nullable = false)
    private var business : Boolean,

    @Column(length = 50)
    private var sectors : String
)