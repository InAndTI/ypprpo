package nsu.ypprpo.peoples_world.repository;

import nsu.ypprpo.peoples_world.models.SocialNetwork;
import nsu.ypprpo.peoples_world.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialNetworksRepository extends JpaRepository<SocialNetwork, Long> {
}
