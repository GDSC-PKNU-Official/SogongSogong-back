package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "ENTIRE_COMMENT")
data class EntireCommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentid :Long ,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userid",nullable = false)
    val userid : UserLoginEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postid",nullable = false)
    val postid : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var date : Date,

    @Column(nullable = false)
    var content : String
)