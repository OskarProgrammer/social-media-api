package pl.socialMediaApi.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.socialMediaApi.social_media_api.model.Comment;
import pl.socialMediaApi.social_media_api.service.CommentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/comments/")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("getComments")
    public List<Comment> getComments(){
        return commentService.getComments();
    }

    @GetMapping("getCommentById/{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") long id){
        return commentService.getCommentById(id);
    }

    @GetMapping("getCommentsByPostId/{postId}")
    public Optional<List<Comment>> getCommentsByPostId(@PathVariable("postId") long id){
        return commentService.getCommentsByPostId(id);
    }

    @GetMapping("getCommentsByOwnerId/{ownerId}")
    public Optional<List<Comment>> getCommentsByOwnerId(@PathVariable("ownerId") long id){
        return commentService.getCommentsByOwnerId(id);
    }

    @PostMapping("createComment")
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    @DeleteMapping("deleteAll")
    public String deleteAll(){
        return commentService.deleteAll();
    }

    @DeleteMapping("deleteAllByOwnerId/{id}")
    public String deleteAllByOwnerId(@PathVariable("id") Long id){
        return commentService.deleteAllByOwnerId(id);
    }
}
