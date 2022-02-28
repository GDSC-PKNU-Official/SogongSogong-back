package sogong.sogongSpring.entity

import org.hibernate.annotations.GeneratorType
import org.springframework.format.annotation.DateTimeFormat
import javax.persistence.*

@Entity
@Table(name = "ENTIRE_POST")
data class EntirePostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val postid : Int,

    //외래키 설정해야 함
    @Column(nullable = false)
    private val userid : Int,

    @Column(nullable = false, length = 30)
    private var subject : String,

    @Column(nullable = false, columnDefinition = "TEXT")
    private var content : String,

    @Column(nullable = false)
    private var date : DateTimeFormat,

    //추후 변경될 수 있음
    @Column(nullable = false)
    private var picture : String,

    @Column(nullable = false, length = 50)
    private var hashtag : String,

    @Column
    private var countcomment : Int = 0,

    @Column
    private var countlike : Int = 0
)