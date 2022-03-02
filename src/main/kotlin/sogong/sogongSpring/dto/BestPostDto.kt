package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class BestPostDto(
    val bestid: Int? = null,
    val postid: EntirePostDto? = null,
    var date: Date? = null
) : Serializable
