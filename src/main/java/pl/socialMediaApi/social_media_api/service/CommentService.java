package pl.socialMediaApi.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.socialMediaApi.social_media_api.model.Comment;
import pl.socialMediaApi.social_media_api.model.Post;
import pl.socialMediaApi.social_media_api.model.User;
import pl.socialMediaApi.social_media_api.repo.CommentRepo;
import pl.socialMediaApi.social_media_api.repo.PostRepo;
import pl.socialMediaApi.social_media_api.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo, UserRepo userRepo, PostRepo postRepo) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }


    public List<Comment> getComments() {
        return commentRepo.findAll();
    }

    public Optional<Comment> getCommentById(long id) {
        Optional<Comment> comment = commentRepo.findById(id);

        if (comment.isEmpty()){
            throw new IllegalStateException("There is no comment with given id");
        }

        return commentRepo.findById(id);
    }


    public Comment createComment(Comment comment) {
        Optional<User> user = userRepo.findUserById(comment.getOwnerId());
        Optional<Post> post = postRepo.findById(comment.getPostId());

        if (user.isEmpty()){
            throw new IllegalStateException("There is no such user in the database");
        }
        if (post.isEmpty()){
            throw new IllegalStateException("There is no such post in the database");
        }

        Optional<Comment> currentComment = commentRepo.findById(comment.getId());

        if (currentComment.isEmpty()){
            commentRepo.save(comment);
            return comment;
        }

        commentRepo.deleteById(comment.getId());
        commentRepo.save(comment);
        return comment;
    }

    public String deleteAll() {
        commentRepo.deleteAll();
        return "Deleted all comments";
    }


    public String deleteAllByOwnerId(Long id) {
        commentRepo.deleteByownerId(id);
        return "Deleted all comments writen by" + id;
    }

    public Optional<List<Comment>> getCommentsByPostId(long id) {
        return commentRepo.findAllByPostId(id);
    }

    public Optional<List<Comment>> getCommentsByOwnerId(long id) {
        return commentRepo.findAllByOwnerId(id);
    }
}
