package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class BestPostDto(
    val bestid: Long? = null,
    val postid: Long,
    var date: Date
) : Serializable
