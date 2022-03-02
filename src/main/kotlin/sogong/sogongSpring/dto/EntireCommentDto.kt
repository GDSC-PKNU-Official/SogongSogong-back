package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class EntireCommentDto(
    val commentid: Int? = null,
    val userid: UserLoginDto? = null,
    val postid: EntirePostDto? = null,
    var date: Date? = null,
    var content: String? = null
) : Serializable
