package sogong.sogongSpring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.NoArgsConstructor
//import org.hibernate.annotations.GeneratorType
//import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
//import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "ENTIRE_POST")
data class EntirePostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "userId", nullable = false)
    val userId: UserLoginEntity,

    @Column(nullable = false, length = 30)
    var subject: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    var date: LocalDateTime,

    //추후 변경될 수 있음
    @Column
    var picture: String? =null,

    @Column(columnDefinition = "integer default 0")
    var countComment: Int = 0,

    @Column(columnDefinition = "integer default 0")
    var countLike: Int = 0
)