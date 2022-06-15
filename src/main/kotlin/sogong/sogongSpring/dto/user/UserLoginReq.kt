package sogong.sogongSpring.dto.user

import java.io.Serializable

data class UserLoginReq(
    var email : String,
    var password : String
):Serializable