package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class EntirePostDto(
    val postid: Int? = null,
    val userid: UserLoginDto? = null,
    var subject: String? = null,
    var content: String? = null,
    var date: Date? = null,
    var picture: String? = null,
    var hashtag: String? = null,
    var countcomment: Int? = null,
    var countlike: Int? = null
) : Serializable
