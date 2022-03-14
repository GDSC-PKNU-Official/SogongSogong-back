package sogong.sogongSpring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.NoArgsConstructor
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "ENTIRE_COMMENT")
data class EntireCommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId :Long? = null,

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="userId",nullable = false)
    val userId : UserLoginEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="postId",nullable = false)
    val postId : EntirePostEntity,

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    var date : LocalDateTime,

    @Column(nullable = false)
    var content : String
)