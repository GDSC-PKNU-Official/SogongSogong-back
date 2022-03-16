package sogong.sogongSpring.dto.boardedit

import java.io.Serializable

data class EditPostCommentAuthDto(
    val postId : Long,
    val userId : Long,
    val commentId : Long ?= null
) : Serializable