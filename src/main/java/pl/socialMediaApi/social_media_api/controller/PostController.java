package pl.socialMediaApi.social_media_api.controller;

import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.socialMediaApi.social_media_api.model.Post;
import pl.socialMediaApi.social_media_api.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/posts/")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("getPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("getPostById/{id}")
    public Optional<Post> getPostById(@PathVariable("id") long id){
        return postService.getPostById(id);
    }

    @GetMapping("getAllPostsByOwnerId/{id}")
    public Optional<List<Post>> getAllPostsByOwnerId(@PathVariable("id") long id){
        return postService.getAllPostsByOwnerId(id);
    }

    @PostMapping("createPost")
    public Optional<Post> createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllPosts(){
        postService.deleteAllPosts();
    }

    @DeleteMapping("deletePost/{id}")
    public String deletePost(@PathVariable long id){
        return postService.deletePost(id);
    }

    @PutMapping("changePost/{id}")
    public Optional<Post> changePost(@PathVariable long id, @RequestBody Post post){
        return postService.changePost(id, post);
    }


}
