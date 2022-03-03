package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class EntirePostDto(
    val postid: Long? = null,
    val userid: Long? = null,
    var subject: String? = null,
    var content: String? = null,
    var date: Date? = null,
    var picture: String? = null,
    var hashtag: String? = null,
    var countcomment: Int = 0,
    var countlike: Int = 0
) : Serializable
