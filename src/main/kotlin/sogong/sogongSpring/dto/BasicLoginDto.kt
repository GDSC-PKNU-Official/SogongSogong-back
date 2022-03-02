package sogong.sogongSpring.dto

import java.io.Serializable

data class BasicLoginDto(
    val basicid: Int? = null,
    val userid: UserLoginDto? = null,
    val realid: String? = null,
    var passwd: String? = null
) : Serializable
