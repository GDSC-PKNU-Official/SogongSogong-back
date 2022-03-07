package sogong.sogongSpring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.NoArgsConstructor
import org.hibernate.annotations.GeneratorType
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "ENTIRE_POST")
data class EntirePostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postid: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "userid", nullable = false)
    val userid: UserLoginEntity,

    @Column(nullable = false, length = 30)
    var subject: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var date: Date,

    //추후 변경될 수 있음
    @Column
    var picture: String? =null,

    @Column(nullable = false, length = 50)
    var hashtag: String,

    @Column(columnDefinition = "integer default 0")
    var countcomment: Int = 0,

    @Column(columnDefinition = "integer default 0")
    var countlike: Int = 0
)