package sogong.sogongSpring.dto.boardprint

import java.io.Serializable
import java.time.LocalDateTime

data class PrintEntirePostDto(
    val postId : Long,
    val userId : Long,
    val subject : String,
    val date : LocalDateTime,
    val countComment:Int,
    val countLike:Int
):Serializable