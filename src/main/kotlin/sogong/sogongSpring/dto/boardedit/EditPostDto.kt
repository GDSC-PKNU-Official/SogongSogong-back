package sogong.sogongSpring.dto.boardedit
import java.io.Serializable

data class EditPostDto(
    val userId: Long,
    var subject: String,
    var content: String,
    var picture: String? = null
): Serializable

