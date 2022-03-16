package sogong.sogongSpring.dto.boardedit

data class DeleteCommentDto(
    val commmentId : Long,
    val postId : Long
) : java.io.Serializable