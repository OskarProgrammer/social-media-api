package pl.socialMediaApi.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.socialMediaApi.social_media_api.model.User;
import pl.socialMediaApi.social_media_api.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public Optional<User> getUserByName(String name) {
        return userRepo.findUserByName(name);
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteUserWithId(Long id) {
        Optional<User> userById = userRepo.findUserById(id);

        if (!userById.isPresent()){
            throw new IllegalStateException("There is no user with given id ");
        }

        userRepo.deleteById(id);
    }


    public void changeUser(Long id, User user) {
        Optional<User> userById = userRepo.findUserById(id);

        if (!userById.isPresent()){
            throw new IllegalStateException("There is no user with given id ");
        }

        userRepo.deleteById(id);
        user.setId(id);
        userRepo.save(user);
    }

    public void deleteAll() {
        userRepo.deleteAll();
    }
}
