package sogong.sogongSpring.dto.boardedit

import java.io.Serializable

data class EditPostCommentAuthDto(
    val postid : Long,
    val userid : Long,
    val commentid : Long ?= null
) : Serializable