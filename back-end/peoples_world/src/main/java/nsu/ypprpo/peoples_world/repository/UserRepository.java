package nsu.ypprpo.peoples_world.repository;

import nsu.ypprpo.peoples_world.models.Hobby;
import nsu.ypprpo.peoples_world.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE username =?1", nativeQuery = true)
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT h.name FROM hobbies h JOIN users_hobbies uh ON h.hobby_id = uh.hobby_id WHERE uh.user_id = ?1", nativeQuery = true)
    List<String> getUserHobbiesById(Long id);

    @Query(value = "SELECT s.name FROM social_networks s JOIN users_social_networks us ON s.social_id = us.social_id WHERE us.user_id = ?1", nativeQuery = true)
    List<String> getUserSocialsById(Long id);
}