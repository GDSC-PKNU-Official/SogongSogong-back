package sogong.sogongSpring.dto.board

import java.io.Serializable
import java.time.LocalDateTime


data class EntireCommentDto(
    val commentid: Long? = null,
    val userid: Long,
    val postid: Long,
    var date: LocalDateTime ?= null, //수정 예정
    var content: String
) : Serializable
