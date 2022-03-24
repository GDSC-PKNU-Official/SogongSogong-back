package sogong.sogongSpring.service

class PostIdException(id:Long) : Exception(String.format("PostId Error : %d", id))
class CommentIdException(id:Long) : Exception(String.format("CommentId Error : %d", id))
class UserIdException(id:Long) : Exception(String.format("UserId Error : %d", id))
class HashNameException(hash:List<String>) : Exception(String.format("HashName Error : %s", hash))

private fun errorMsg(){

}