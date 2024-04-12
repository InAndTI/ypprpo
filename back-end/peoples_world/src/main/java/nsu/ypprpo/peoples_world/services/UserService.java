package nsu.ypprpo.peoples_world.services;

import nsu.ypprpo.peoples_world.repository.UserRepository;
import nsu.ypprpo.peoples_world.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
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

}
