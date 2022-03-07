package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "SCRAP_LIKE")
data class ScrapLikeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val scrapid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userid",nullable = false)
    val userid : UserLoginEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="postid",nullable = false)
    val postid : EntirePostEntity,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    val category : Boolean
)