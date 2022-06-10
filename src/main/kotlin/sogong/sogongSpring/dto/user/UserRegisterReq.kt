package sogong.sogongSpring.dto.user

import java.io.Serializable

data class UserRegisterReq(
    var name :String,
    var email : String,
    var password : String
):Serializable