package sogong.sogongSpring.dto.board

import java.io.Serializable
import java.time.LocalDateTime

data class EntirePostDto(
    val postId: Long? = null,
    val userId: Long,
    var subject: String,
    var content: String,
    var picture: String? = null,
    var countComment: Int = 0,
    var countLike: Int = 0
) : Serializable
