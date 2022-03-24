package sogong.sogongSpring.service

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class PostIdException(id:Long) : ResponseStatusException(
    HttpStatus.NOT_FOUND, String.format("PostId Error : %d", id)
)
class CommentIdException(id:Long) : ResponseStatusException(
    HttpStatus.NOT_FOUND, String.format("CommentId Error : %d", id)
)
class UserIdException(id:Long) : ResponseStatusException(
    HttpStatus.NOT_FOUND, String.format("UserId Error : %d", id)
)
class HashNameException(hash:List<String>) : ResponseStatusException(
    HttpStatus.NOT_FOUND, String.format("HashName Error : %s", hash)
)