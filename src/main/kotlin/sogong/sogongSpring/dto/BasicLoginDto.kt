package sogong.sogongSpring.dto

import java.io.Serializable

data class BasicLoginDto(
    val basicid: Int? = null,
    val userid: UserLoginDto,
    val realid: String,
    var passwd: String
) : Serializable
