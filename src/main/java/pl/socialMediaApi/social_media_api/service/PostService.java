package pl.socialMediaApi.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import pl.socialMediaApi.social_media_api.model.Post;
import pl.socialMediaApi.social_media_api.model.User;
import pl.socialMediaApi.social_media_api.repo.PostRepo;
import pl.socialMediaApi.social_media_api.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @Autowired
    public PostService(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }


    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Optional<Post> getPostById(long id) {
        Optional<Post> post = postRepo.findById(id);

        if (post.isEmpty()) {
            throw new IllegalStateException("There is no post with this id");
        }

        return postRepo.findById(id);
    }


    public Optional<Post> createPost(Post post) {
        Optional<User> user = userRepo.findUserById(post.getOwnerId());

        if (user.isEmpty()){
            throw new IllegalStateException("There is no such user");
        }

        Optional<Post> currentPost = postRepo.findById(post.getId());

        if (currentPost.isEmpty()){
            postRepo.save(post);
            return Optional.of(post);
        }

        postRepo.deleteById(post.getId());

        postRepo.save(post);

        return Optional.of(post);
    }


    public void deleteAllPosts() {
        postRepo.deleteAll();
    }

    public String deletePost(long id) {
        Optional<Post> post = postRepo.findById(id);

        if (post.isEmpty()){
            throw new IllegalStateException("There is no post with this id, nothing to delete");
        }

        return "Post deleted";
    }

    public Optional<List<Post>> getAllPostsByOwnerId(long id) {
        Optional<List<Post>> posts = postRepo.findAllByOwnerId(id);

        if (posts.isEmpty()){
            throw new IllegalStateException("No posts to display");
        }

        return posts;
    }

}
