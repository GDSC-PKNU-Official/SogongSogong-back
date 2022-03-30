package sogong.sogongSpring.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import sogong.sogongSpring.service.ImgService
import java.sql.Blob
import javax.sql.rowset.serial.SerialBlob

@RestController
@RequestMapping("/image")
class ImgController(var imgService: ImgService){
    @PostMapping("/save")
    fun saveImg(@RequestParam img : MultipartFile){
        val blob : Blob = SerialBlob(img.bytes)
        imgService.saveImg(blob)
    }

}