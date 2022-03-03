package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class UserLoginDto(
    val userid: Long? = null,
    val name: String? = null,
    var passwd: String? = null,
    var bday: Date? = null,
    val phone: String? = null,
    val social: Boolean? = null,
    var business: Boolean? = null,
    var sectors: String? = null
) : Serializable
