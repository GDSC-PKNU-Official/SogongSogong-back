package sogong.sogongSpring.entity

import javax.persistence.*

@Entity
@Table(name = "SCRAP_LIKE")
data class ScrapLikeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val scrapid : Int,

    //외래키 설정 해야함
    @Column(nullable = false)
    private val userid : Int,

    //외래키 설정 해야함
    @Column(nullable = false)
    private val postid : Int,

    @Column(nullable = false)
    private val category : Boolean
)