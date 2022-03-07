package sogong.sogongSpring.dto

import java.io.Serializable

data class BasicLoginDto(
    val basicid: Long,
    val userid: Long,
    val realid: String,
    var passwd: String
) : Serializable
