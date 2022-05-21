package sogong.sogongSpring.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
class SpringSecurityConfig : WebSecurityConfigurerAdapter(){

    @Throws(Exception::class)
    override fun configure(http : HttpSecurity) {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .defaultSuccessUrl("", true)
                .permitAll()
            .and()
                .logout()
    }
}