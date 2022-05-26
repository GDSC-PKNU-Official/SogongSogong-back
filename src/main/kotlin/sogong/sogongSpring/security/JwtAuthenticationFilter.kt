package sogong.sogongSpring.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import kotlin.jvm.Throws

class JwtAuthenticationFilter(private val jwtTokenIssue: JwtTokenIssue) : GenericFilterBean() {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {

        //헤더에서 JWT 추출
        val token:String? = jwtTokenIssue.getToken((request as HttpServletRequest))

        //유효 토큰 검증 작업
        if(token!=null && jwtTokenIssue.validateToken(token)){
            val auth = jwtTokenIssue.getAuthentication(token) //유저 정보 받아오기

            //security context에 auth 객체 저장
            SecurityContextHolder.getContext().authentication = auth
        }
        chain.doFilter(request, response)
    }
}