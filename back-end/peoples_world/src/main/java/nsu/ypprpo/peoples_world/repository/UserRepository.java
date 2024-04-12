package nsu.ypprpo.peoples_world.repository;

import nsu.ypprpo.peoples_world.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE username =?1", nativeQuery = true)
    Optional<User> findByUsername(String username);
}