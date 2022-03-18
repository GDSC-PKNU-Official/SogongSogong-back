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
class HashtagController (var hashtagService: HashtagService){

    @PostMapping("/post")
    fun registPostHashtag(@RequestBody postHashtagDto: PostHashtagDto){
        hashtagService.savePostHashtag(postHashtagDto)
    }

    @PostMapping("/user")
    fun saveUserHashtag(@RequestBody userHashTagDto: UserHashTagDto){
        hashtagService.saveUserHashtag(userHashTagDto)
    }

    @PutMapping("/user")
    fun editUserHashtag(@RequestBody userHashTagDto: UserHashTagDto){
        hashtagService.editUserHashtag(userHashTagDto)
    }

    @PutMapping("/post")
    fun editPostHashtag(@RequestBody postHashtagDto: PostHashtagDto){
        hashtagService.editPostHashtag(postHashtagDto)
    }

    @GetMapping("/or-search")
    fun searchPost(@RequestParam hashtag: List<String>) : List<EntirePostEntity>{
        return hashtagService.searchOrPost(hashtag)
    }

    @GetMapping("/post/{postId}")
    fun printPostHashtag(@PathVariable postId : Long) : List<String>{
        return hashtagService.printPostHashtag(postId)
    }

    @GetMapping("/user/{userId}")
    fun printUserHashtag(@PathVariable userId:Long, @RequestParam("group-id") groupId:Long) : List<UserHashtagEntity>{
        return hashtagService.printUserHashtag(userId, groupId)
    }


}