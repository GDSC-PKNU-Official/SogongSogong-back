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
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
class SpringSecurityConfig : WebSecurityConfigurerAdapter(){

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
            .httpBasic().disable() //rest api
                .csrf().disable() //localhost에서 테스트하기 위해 csrf 취소
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션 말고 토큰할거임
            .and()
                .authorizeRequests() //요청 사용 권한
                .anyRequest().authenticated() //일단 전부 허용
//            .and()
//                .addFilterBefore(, ) //JWT Token 만들면 여기에 적용하면 됨
            .and()
                .logout().logoutUrl("/logout") //요청 url로 로그아웃 받기
                .logoutSuccessUrl("/login") //logout 성공시 url 이동...인가? 잘 모르겠음
    }
}