package sogong.sogongSpring.dto

import java.io.Serializable
import java.time.LocalDateTime

data class BestPostDto(
    val bestid: Long? = null,
    val postid: Long,
    var date: LocalDateTime? = null //수정 예정
) : Serializable
