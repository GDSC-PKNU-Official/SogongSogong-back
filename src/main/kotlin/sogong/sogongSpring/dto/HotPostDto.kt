package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class HotPostDto(
    val hotid: Int? = null,
    val postid: EntirePostDto? = null,
    var date: Date? = null
) : Serializable
