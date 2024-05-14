package nsu.ypprpo.peoples_world.controllers;

import jakarta.validation.Valid;
import nsu.ypprpo.peoples_world.models.Hobby;
import nsu.ypprpo.peoples_world.models.SocialNetwork;
import nsu.ypprpo.peoples_world.services.UserService;
import nsu.ypprpo.peoples_world.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import nsu.ypprpo.peoples_world.exceptions.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        User createdUser = userService.createUser(user);
        if(createdUser == null){
            throw new CustomException("Пользователь с такими данными уже существует");
        }
        return null;
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // Delete all users
    @DeleteMapping
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "All users have been deleted successfully.";
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{user_id}/hobby/{hobby_id}")
    public void addHobbyToUser(@PathVariable("user_id") Long id, @PathVariable("hobby_id") Integer hobby_id){
        userService.addHobbyToUser(id, hobby_id);
    }

    @PostMapping("/{user_id}/social_network/{social_id}")
    public void addSocialNetworkToUser(@PathVariable("user_id") Long id, @PathVariable("social_id") Integer social_id){
        userService.addSocialNetworkToUser(id, social_id);
    }

    @GetMapping("/{user_id}/hobbies")
    public List<String> getHobbiesByUserId(@PathVariable("user_id") Long userId){
        return userService.getHobbiesByUserId(userId);
    }

    @GetMapping("/{user_id}/social_networks")
    public List<String> getSocialNetworksByUserId(@PathVariable("user_id") Long userId){
        return userService.getSocialNetworksByUserId(userId);
    }
}