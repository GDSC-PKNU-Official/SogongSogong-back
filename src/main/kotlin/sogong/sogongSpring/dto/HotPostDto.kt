package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class HotPostDto(
    val hotid: Long? = null,
    val postid: Long? = null,
    var date: Date? = null
) : Serializable
