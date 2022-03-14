package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "POST_HASHTAG")
data class PostHashtagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postHashId : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashId", nullable = false)
    var hashId : HashtagDbEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", nullable = false)
    val postId : EntirePostEntity
)