package sogong.sogongSpring.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sogong.sogongSpring.dto.hashtag.PostHashtagDto
import sogong.sogongSpring.service.HashtagService

@RestController
@RequestMapping("/hashtag")
class HashtagController {
    var hashtagService : HashtagService

    constructor(hashtagService: HashtagService) {
        this.hashtagService = hashtagService
    }

    @PostMapping("/registPostHashtag")
    fun registPostHashtag(@RequestBody postHashtagDto: PostHashtagDto){
        hashtagService.savePostHashtag(postHashtagDto)
    }
}