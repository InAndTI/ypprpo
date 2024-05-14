package nsu.ypprpo.peoples_world.services;

import jakarta.transaction.Transactional;
import nsu.ypprpo.peoples_world.exceptions.CustomException;
import nsu.ypprpo.peoples_world.models.Hobby;
import nsu.ypprpo.peoples_world.models.SocialNetwork;
import nsu.ypprpo.peoples_world.repository.HobbiesRepository;
import nsu.ypprpo.peoples_world.repository.SocialNetworksRepository;
import nsu.ypprpo.peoples_world.repository.UserRepository;
import nsu.ypprpo.peoples_world.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HobbiesRepository hobbiesRepository;
    @Autowired
    private SocialNetworksRepository socialNetworksRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // Create a new user
    public User createUser(User user) {
        var userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB.isPresent()) {
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean isPasswordCorrect(String username, String password) {
        var userFromDB = userRepository.findByUsername(username);
        if(userFromDB.isEmpty()){
            return false;
        }
        return passwordEncoder.matches(password, userFromDB.get().getPassword());
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update user
    public User updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    // Delete all users
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void addHobbyToUser(Long userId, Integer hobbyId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException("Такой пользователь не найден"));
        Hobby hobby = hobbiesRepository.findById(hobbyId).orElseThrow(() ->
                new CustomException("Такого хобби не найдено"));

        user.getHobbies().add(hobby);
        userRepository.save(user);
    }

    public void addSocialNetworkToUser(Long userId, Integer socialId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException("Такой пользователь не найден"));
        SocialNetwork social = socialNetworksRepository.findById(socialId).orElseThrow(() ->
                new CustomException("Такой социальной сети не найдено"));

        user.getSocial_networks().add(social);
        userRepository.save(user);
    }

    public List<String> getHobbiesByUserId(Long userId){
        return userRepository.getUserHobbiesById(userId);
    }

    public List<String> getSocialNetworksByUserId(Long userId){
        return userRepository.getUserSocialsById(userId);
    }

}
