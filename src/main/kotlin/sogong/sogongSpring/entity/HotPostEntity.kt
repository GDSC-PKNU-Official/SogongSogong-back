package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "HOT_POST")
class HotPostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val hotid : Int,

    @ManyToOne
    @JoinColumn(name="postid",nullable = false)
    private val postid : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private var date : Date
)