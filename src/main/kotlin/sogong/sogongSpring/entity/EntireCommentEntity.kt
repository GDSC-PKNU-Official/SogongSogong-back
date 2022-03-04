package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "ENTIRE_COMMENT")
class EntireCommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val commentid :Long ,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userid",nullable = false)
    private val userid : UserLoginEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postid",nullable = false)
    private val postid : EntirePostEntity,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private var date : Date,

    @Column(nullable = false)
    private var content : String
) {
    override fun toString(): String {
        return "EntireCommentEntity(commentid=$commentid, userid=$userid, postid=$postid, date=$date, content='$content')"
    }
}