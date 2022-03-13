package sogong.sogongSpring.dto.boardprint

import java.io.Serializable
import java.time.LocalDateTime

data class PrintEntirePostDto(
    val postid : Long,
    val userid : Long,
    val subject : String,
    val date : LocalDateTime,
    val countcomment:Int,
    val countlike:Int
):Serializable