package pl.socialMediaApi.social_media_api.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.socialMediaApi.social_media_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByName(String name);

    Optional<List<User>> findAllByName(String name);
}
