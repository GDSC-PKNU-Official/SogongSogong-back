package sogong.sogongSpring.dto.boardprint

import java.io.Serializable
import java.util.*

data class PrintEntirePostDto(
    val postid : Long,
    val userid : Long,
    val subject : String,
    val date : Date,
    val countcomment:Int,
    val countlike:Int
):Serializable