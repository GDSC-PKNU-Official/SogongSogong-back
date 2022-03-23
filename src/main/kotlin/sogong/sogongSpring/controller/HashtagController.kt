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

    @GetMapping("/search-bar")
    fun searchBarPost(@RequestParam hashtag: List<String>, @RequestParam("last-post") lastPost: Long?=null) : List<EntirePostEntity>{
        return hashtagService.searchBarPost(hashtag, lastPost)
    }

    @GetMapping("/hash-board")
    fun hashBoardPost(@RequestParam("user-id") userId: Long, @RequestParam("last-post") lastPost: Long?=null) : Any{
        return hashtagService.hashBoardPost(userId, lastPost)
    }

    @GetMapping("/post/{postId}")
    fun printPostHashtag(@PathVariable postId : Long) : List<String>{
        return hashtagService.printPostHashtag(postId)
    }

    @GetMapping("/user/{userId}")
    fun printUserHashtag(@PathVariable userId:Long) : List<UserHashtagEntity>{
        return hashtagService.printUserHashtag(userId)
    }


}