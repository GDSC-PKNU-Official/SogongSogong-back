package sogong.sogongSpring.entity

import javax.persistence.*

@Entity
@Table(name = "BASIC_LOGIN")
data class BasicLoginEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val basicid : Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    val userid : UserLoginEntity,

    @Column(nullable = false, length = 15)
    val realid : String,

    @Column(nullable = false, length = 20)
    var passwd : String
) {
    override fun toString(): String {
        return "BasicLoginEntity(basicid=$basicid, userid=$userid, realid='$realid', passwd='$passwd')"
    }
}