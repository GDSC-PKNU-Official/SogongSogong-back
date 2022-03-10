package sogong.sogongSpring.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "SCRAP_LIKE")
data class ScrapLikeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val scrapId : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="userId",nullable = false)
    val userId : UserLoginEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="postId",nullable = false)
    val postId : EntirePostEntity,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    val category : Boolean
)