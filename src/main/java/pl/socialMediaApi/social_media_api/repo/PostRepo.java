package pl.socialMediaApi.social_media_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.socialMediaApi.social_media_api.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Long> {
    Optional<List<Post>> findAllByOwnerId(long id);
}
