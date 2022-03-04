package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class UserLoginDto(
    val userid: Long? = null,
    val name: String,
    var passwd: String? = null,
    var bday: Date,
    val phone: String,
    val social: Boolean,
    var business: Boolean,
    var sectors: String? = null
) : Serializable
