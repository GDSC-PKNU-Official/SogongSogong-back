package sogong.sogongSpring.dto

import java.io.Serializable

data class HashtagDbDto(
    val hashid: Long? = null,
    val hashname: String? = null
) : Serializable
