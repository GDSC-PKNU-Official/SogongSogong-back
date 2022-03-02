package sogong.sogongSpring.dto

import java.io.Serializable

data class UserHashtagDto(
    val userhashid: Int? = null,
    val userid: UserLoginDto? = null,
    var groupid: Int? = null,
    var hashid: HashtagDbDto? = null
) : Serializable
