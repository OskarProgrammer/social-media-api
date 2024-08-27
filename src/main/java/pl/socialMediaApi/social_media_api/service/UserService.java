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

    public Optional<List<User>> getUserByName(String name) {
        return userRepo.findAllByName(name);
    }

    public User addUser(User user) {
        Optional<User> newUser = userRepo.findUserById(user.getId());

        if (newUser.isEmpty()){
            userRepo.save(user);
            return user;
        }

        userRepo.deleteById(user.getId());
        userRepo.save(user);

        return user;
    }

    public void deleteUserWithId(Long id) {
        Optional<User> userById = userRepo.findUserById(id);

        if (!userById.isPresent()){
            throw new IllegalStateException("There is no user with given id ");
        }

        userRepo.deleteById(id);
    }

    public void deleteAll() {

        userRepo.deleteAll();
    }

    public Optional<List<User>> getAllUsersByName(String name) {
        Optional <List<User>> usersList = userRepo.findAllByName(name);

        if (usersList.isEmpty()){
            throw new IllegalStateException("No users with the given name");
        }

        return userRepo.findAllByName(name);
    }
}
