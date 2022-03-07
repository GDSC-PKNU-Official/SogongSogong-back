package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "BEST_POST")
data class BestPostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bestid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postid", nullable = false)
    val postid : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var date : Date
)