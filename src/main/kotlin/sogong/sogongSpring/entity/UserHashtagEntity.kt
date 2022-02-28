package sogong.sogongSpring.entity

import javax.persistence.*


@Entity
@Table(name = "USER_HASHTAG")
data class UserHashtagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val userhashid : Int,

    //외래키 설정 해야함
    @Column(nullable = false)
    private val userid : Int,

    @Column(nullable = false)
    private var groupid : Int,

    //외래키 설정 해야함
    @Column(nullable = false)
    private var hashid : Int
)