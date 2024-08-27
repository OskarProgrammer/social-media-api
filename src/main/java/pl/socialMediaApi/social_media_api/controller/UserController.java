package pl.socialMediaApi.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import pl.socialMediaApi.social_media_api.model.User;
import pl.socialMediaApi.social_media_api.repo.UserRepo;
import pl.socialMediaApi.social_media_api.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "getUserById/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping(path = "getUserByName/{name}")
    public Optional<User> getUserById(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }

    @PostMapping(path = "createUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }


    @DeleteMapping(path = "deleteAll")
    public void deleteUser(){
        userService.deleteAll();
    }

    @DeleteMapping(path = "deleteUserWithId/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserWithId(id);
    }

    @PutMapping(path = "changeUser/{id}")
    public void changeUser(@PathVariable("id") Long id,
                           @RequestBody User user){
        userService.changeUser(id, user);
    }

}
