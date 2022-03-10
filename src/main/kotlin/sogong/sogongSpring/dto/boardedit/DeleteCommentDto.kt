package sogong.sogongSpring.dto.boardedit

data class DeleteCommentDto(
    val commentid : Long,
    val postid : Long
) : java.io.Serializable