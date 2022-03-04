package sogong.sogongSpring.dto

import java.io.Serializable
import java.util.*

data class EntireCommentDto(
    val commentid: Long? = null,
    val userid: Long,
    val postid: Long,
    var date: Date,
    var content: String
) : Serializable
