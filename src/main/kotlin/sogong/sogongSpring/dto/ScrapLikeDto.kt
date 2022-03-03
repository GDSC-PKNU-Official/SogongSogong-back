package sogong.sogongSpring.dto

import java.io.Serializable

data class ScrapLikeDto(
    val scrapid: Long? = null,
    val userid: Long? = null,
    val postid: Long? = null,
    val category: Boolean? = null
) : Serializable
