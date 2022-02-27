package sogong.sogongSpring.entity

import org.springframework.format.annotation.DateTimeFormat
import javax.persistence.*

@Entity
@Table(name = "HOT_POST")
data class HotPostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val hotid : Int,

    //외래키 설정해야 함
    @Column(nullable = false)
    private val postid : Int,

    @Column(nullable = false)
    private var date : DateTimeFormat
)