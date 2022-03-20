package sogong.sogongSpring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
class SogongSpringApplication

@PostConstruct
fun started(){
	TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
}
fun main(args: Array<String>) {
	runApplication<SogongSpringApplication>(*args)

}
