package sogong.sogongSpring.entity

import javax.persistence.*

@Entity
@Table(name = "BASIC_LOGIN")
data class BasicLoginEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val basicId : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    val userId : UserLoginEntity,

    @Column(nullable = false, length = 15)
    val realId : String,

    @Column(nullable = false, length = 20)
    var passwd : String
)