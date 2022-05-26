package sogong.sogongSpring.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenIssue (private val userDetailsService : UserDetailsService) {
    private var secretKey = "#$#%#$%#$%$!@$!@!@$%%#$#$$%^&%$&&%&$" //secretKey는 비밀^^
    private val secretKeyToArray : Key = Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))
    private val tokenValidTime = 30*60*1000L //30분이라함

    @PostConstruct
    protected fun init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray()) //Base64 인코딩
    }

    //JWT 토큰 생성
    fun createToken(userId : String) : String{

        val claims : Claims = Jwts.claims() //JWT paylaod에 저장되는 정보들
            .setSubject(userId) //저장 구분 단위
            .setIssuedAt(Date()) //토큰 생성일 : 현재 시간
            .setExpiration(Date(Date().time + tokenValidTime)) //토큰 만료일 : 현재시간+tokenValidTime
        claims["userId"] = userId //담고 싶은 값

        val jwt : String = Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setClaims(claims) //claim 넣자
            .signWith(secretKeyToArray, SignatureAlgorithm.HS256) //비밀키와 암호화 알고리즘 설정
            .compact()

        return jwt
    }

    //JWT 토큰 값 가져오기
    fun getToken(request:HttpServletRequest) : String?{
        return request.getHeader("Authorization")
    }

    //JWT 토큰 정보 확인
    fun getUserId(token:String):String {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }

    //JWT 토큰의 인증 정보 조회
    fun getAuthentication(token:String): Authentication{
        val userDetails = userDetailsService.loadUserByUsername(getUserId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    //JWT 토큰의 유효성 확인
    fun validateToken(jwtToken:String):Boolean{
        return try{
            val claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwtToken)
            !claims.body.expiration.before(Date()) //지금 날짜 기준으로 만료되면 true 아니면 false
        }catch (e:JwtException){
            return false
        }
    }
}