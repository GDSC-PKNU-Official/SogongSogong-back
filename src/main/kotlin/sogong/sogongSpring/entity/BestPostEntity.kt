package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "BEST_POST")
data class BestPostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bestId : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", nullable = false)
    val postId : EntirePostEntity,

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    var date : LocalDateTime
)