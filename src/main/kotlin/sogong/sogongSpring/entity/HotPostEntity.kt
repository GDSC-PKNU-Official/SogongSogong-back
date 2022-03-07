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
    val hotid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postid",nullable = false)
    val postid : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var date : Date
) {
    override fun toString(): String {
        return "HotPostEntity(hotid=$hotid, postid=$postid, date=$date)"
    }
}