package sogong.sogongSpring.dto.hashtag

data class UserHashTagDto(
    val userId:Long,
    val groupId:Long,
    var hashName:List<String>
):java.io.Serializable