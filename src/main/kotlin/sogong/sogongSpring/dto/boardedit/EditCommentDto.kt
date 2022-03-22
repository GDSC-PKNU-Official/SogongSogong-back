package sogong.sogongSpring.dto.boardedit

import java.io.Serializable

data class EditCommentDto(
    val postId: Long,
    var content: String
):Serializable