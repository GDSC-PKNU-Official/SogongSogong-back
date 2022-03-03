package sogong.sogongSpring.dto

import java.io.Serializable

data class UserHashtagDto(
    val userhashid: Long? = null,
    val userid: Long? = null,
    var groupid: Long? = null,
    var hashid: Long? = null
) : Serializable
