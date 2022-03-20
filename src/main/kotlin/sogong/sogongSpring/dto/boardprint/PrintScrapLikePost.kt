package sogong.sogongSpring.dto.boardprint

import java.io.Serializable
import java.time.LocalDateTime

data class PrintEntirePostDto(
    var scrapId : Long,
    var postId : Long,
    var userId : Long,
    var subject : String,
    var date : LocalDateTime,
    var countComment:Int,
    var countLike:Int
):Serializable