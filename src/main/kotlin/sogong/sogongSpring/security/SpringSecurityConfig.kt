package sogong.sogongSpring.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
class SpringSecurityConfig(private val jwtTokenIssue: JwtTokenIssue) : WebSecurityConfigurerAdapter(){

    //비밀번호 encoder 사용
    @Bean
    fun passwordEncoder() : PasswordEncoder{
        return BCryptPasswordEncoder()
    }

    //원하는 시점에 로그인하기
    @Bean
    override fun authenticationManagerBean():AuthenticationManager{
        return super.authenticationManagerBean()
    }

    //인증 절차에 관한 설정
    @Throws(Exception::class)
    override fun configure(http : HttpSecurity) {
        http
            .httpBasic().disable() //로그인 기본 창이 없어진다~
                .csrf().disable() //localhost에서 테스트하기 위해 csrf 취소
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션 말고 토큰할거임
            .and()
                .authorizeRequests() //rest 사용권한
                .antMatchers("/board/print/hot").permitAll()
                .antMatchers("/board/print/best").permitAll()
                .antMatchers("/board/print/post/**").permitAll()
                .antMatchers("/board/print/all").permitAll()
                .antMatchers("/board/test").authenticated()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
                //.antMatchers("/api/**").authenticated() // 나머지 url은 요청받아야함
                //.antMatchers("/signup/**", "/signin/**", "/logout/**").permitAll() //회원가입, 로그인, 로그아웃은 모두 허용
            .and()
                .addFilterBefore(
                    JwtAuthenticationFilter(jwtTokenIssue)
                    , UsernamePasswordAuthenticationFilter::class.java)
    }
}