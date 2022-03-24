package sogong.sogongSpring.entity

import lombok.NoArgsConstructor
import java.sql.Blob
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "PIC")
data class ImgEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val picId : Long? = null,

    @Column(nullable = false, columnDefinition = "MEDIUMBLOB")
    var pic : Blob

    //column 더 만들기~
)