package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class EntireCommentDto(
    val commentid: Long? = null,
    val userid: Long? = null,
    val postid: Long? = null,
    var date: Date? = null,
    var content: String? = null
) : Serializable
