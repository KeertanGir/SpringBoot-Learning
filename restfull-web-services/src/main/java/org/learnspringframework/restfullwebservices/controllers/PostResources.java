package org.learnspringframework.restfullwebservices.controllers;

import jakarta.validation.Valid;
import org.learnspringframework.restfullwebservices.data.Posts;
import org.learnspringframework.restfullwebservices.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class PostResources {

    private final PostsService postsService;


    public PostResources(PostsService postsService) {
        this.postsService = postsService;
    }


    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
       return postsService.getAllPosts();
    }

    @GetMapping("/{id}/posts")
    public List<Posts> getPostsByUserId(@PathVariable Long id){
        return postsService.getAllPostByUserId(id);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public Posts getPostsByUserIdAndPostId(@PathVariable Long userId, @PathVariable Long postId){
        return postsService.getPostByUserIdAndPostId(userId, postId);
    }

    @GetMapping("/{id}/postscount")
    public int getCountOfUserPosts(@PathVariable Long id){
        return postsService.getUsersPostCount(id);
    }

    @PostMapping("/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Long userId, @Valid @RequestBody Posts newPost){
        Posts newPostForUser = postsService.createNewPostForUser(userId, newPost);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(newPostForUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
