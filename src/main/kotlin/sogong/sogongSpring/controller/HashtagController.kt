package sogong.sogongSpring.controller

import org.springframework.web.bind.annotation.*
import sogong.sogongSpring.dto.hashtag.PostHashtagDto
import sogong.sogongSpring.dto.hashtag.UserHashTagDto
import sogong.sogongSpring.entity.EntirePostEntity
import sogong.sogongSpring.entity.UserHashtagEntity
import sogong.sogongSpring.repository.EntirePostRepository
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

    @PostMapping("/registUserHashtag")
    fun saveUserHashtag(@RequestBody userHashTagDto: UserHashTagDto){
        hashtagService.saveUserHashtag(userHashTagDto)
    }

    @PostMapping("/editUserHashtag")
    fun editUserHashtag(@RequestBody userHashTagDto: UserHashTagDto){
        hashtagService.editUserHashtag(userHashTagDto)
    }

    @PostMapping("/editPostHashtag")
    fun editPostHashtag(@RequestBody postHashtagDto: PostHashtagDto){
        hashtagService.editPostHashtag(postHashtagDto)
    }

    @GetMapping("/orSearchHashtag")
    fun searchPost(@RequestParam hashtag: List<String>) : List<EntirePostEntity>{
        return hashtagService.searchOrPost(hashtag)
    }

    @GetMapping("/printPostHashtag")
    fun printPostHashtag(@RequestParam postId : Long) : List<String>{
        return hashtagService.printPostHashtag(postId)
    }

    @GetMapping("/printUserHashtag")
    fun printUserHashtag(@RequestParam userId:Long, @RequestParam groupId:Long) : List<UserHashtagEntity>{
        return hashtagService.printUserHashtag(userId, groupId)
    }


}