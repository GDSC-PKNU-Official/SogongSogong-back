package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "HOT_POST")
data class HotPostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val hotId : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postId",nullable = false)
    val postId : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var date : Date
)