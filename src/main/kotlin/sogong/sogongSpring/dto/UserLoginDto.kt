package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

//class 전체적으로 손 볼 예정
data class UserLoginDto(
    val userid: Long? = null,
    val name: String,
    var passwd: String? = null,
    var bday: Date? = null, //수정 예정
    val phone: String,
    val social: Boolean,
    var business: Boolean,
    var sectors: String? = null
) : Serializable
