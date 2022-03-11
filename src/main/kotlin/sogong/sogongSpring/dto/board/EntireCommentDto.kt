package sogong.sogongSpring.dto.board

import java.io.Serializable
import java.util.*

data class EntireCommentDto(
    val commentid: Long? = null,
    val userid: Long,
    val postid: Long,
    var date: Date ?= null, //수정 예정
    var content: String
) : Serializable
