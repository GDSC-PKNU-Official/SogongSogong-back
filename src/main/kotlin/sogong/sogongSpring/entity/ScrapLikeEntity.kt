package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "SCRAP_LIKE")
class ScrapLikeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val scrapid : Int,

    @ManyToOne
    @JoinColumn(name="userid",nullable = false)
    private val userid : UserLoginEntity,

    @ManyToOne
    @JoinColumn(name="postid",nullable = false)
    private val postid : EntirePostEntity,

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private val category : Boolean
)