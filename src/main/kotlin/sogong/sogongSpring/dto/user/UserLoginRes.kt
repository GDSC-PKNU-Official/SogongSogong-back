package sogong.sogongSpring.dto.user

import org.springframework.http.HttpStatus
import java.io.Serializable

data class UserLoginRes(
    var status : HttpStatus,
    var token : String
):Serializable