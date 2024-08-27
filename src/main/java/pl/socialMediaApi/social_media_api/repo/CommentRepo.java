package pl.socialMediaApi.social_media_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.socialMediaApi.social_media_api.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    void deleteByownerId(Long id);

    Optional<List<Comment>> findAllByPostId(long id);

    Optional<List<Comment>> findAllByOwnerId(long id);
}
