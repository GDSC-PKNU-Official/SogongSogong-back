package sogong.sogongSpring.dto

import java.io.Serializable

data class UserHashtagDto(
    val userhashid: Long? = null,
    val userid: Long,
    var groupid: Long,
    var hashid: Long
) : Serializable
