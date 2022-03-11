package sogong.sogongSpring.dto.board

import java.io.Serializable

data class ScrapLikeDto(
    val scrapid: Long? = null,
    val userid: Long,
    val postid: Long,
    val category: Boolean
) : Serializable
