package sogong.sogongSpring.dto.user

import java.io.Serializable

data class BusinessAuthDto(
    val num : String,
    var startDate : String,
    val pName : String
):Serializable