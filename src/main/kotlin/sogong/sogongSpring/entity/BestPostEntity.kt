package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "BEST_POST")
class BestPostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val bestid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postid", nullable = false)
    private val postid : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private var date : Date
) {
    override fun toString(): String {
        return "BestPostEntity(bestid=$bestid, postid=$postid, date=$date)"
    }
}