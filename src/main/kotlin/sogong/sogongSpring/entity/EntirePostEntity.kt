package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.hibernate.annotations.GeneratorType
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "ENTIRE_POST")
class EntirePostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val postid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private val userid : UserLoginEntity,

    @Column(nullable = false, length = 30)
    private var subject : String,

    @Column(nullable = false, columnDefinition = "TEXT")
    private var content : String,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private var date : Date,

    //추후 변경될 수 있음
    @Column(nullable = false)
    private var picture : String,

    @Column(nullable = false, length = 50)
    private var hashtag : String,

    @Column(columnDefinition = "integer default 0")
    private var countcomment : Int,

    @Column(columnDefinition = "integer default 0")
    private var countlike : Int
)