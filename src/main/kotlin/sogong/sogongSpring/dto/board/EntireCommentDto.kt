package sogong.sogongSpring.dto.board

import java.io.Serializable
import java.time.LocalDateTime

data class EntireCommentDto(
    val commentId: Long? = null,
    val userId: Long,
    val postId: Long,
    var content: String
) : Serializable
