package sogong.sogongSpring.dto.board

import java.io.Serializable

data class ScrapLikeDto(
    val scrapId: Long? = null,
    val userId: Long,
    val postId: Long,
    val category: Boolean
) : Serializable
