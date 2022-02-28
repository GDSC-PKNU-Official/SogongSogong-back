package sogong.sogongSpring.entity

import org.springframework.format.annotation.DateTimeFormat
import javax.persistence.*

@Entity
@Table(name = "ENTIRE_COMMENT")
data class EntireCommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val commentid :Int ,

    //외래키 설정해야함
    @Column(nullable = false)
    private val userid : Int,

    //외래키 설정해야함
    @Column(nullable = false)
    private val postid : Int,

    @Column(nullable = false)
    private var date : DateTimeFormat,

    @Column(nullable = false)
    private var content : String
)