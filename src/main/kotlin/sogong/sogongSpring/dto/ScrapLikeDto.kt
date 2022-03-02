package sogong.sogongSpring.dto

import java.io.Serializable

data class ScrapLikeDto(
    val scrapid: Int? = null,
    val userid: UserLoginDto? = null,
    val postid: EntirePostDto? = null,
    val category: Boolean? = null
) : Serializable
