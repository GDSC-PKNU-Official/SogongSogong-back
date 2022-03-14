package sogong.sogongSpring.dto.board


data class PostHashtagDto(
    val postId : Long,
    val hashName : List<String>
):java.io.Serializable