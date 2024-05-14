package nsu.ypprpo.peoples_world.repository;

import nsu.ypprpo.peoples_world.models.User;
import nsu.ypprpo.peoples_world.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersInfoRepository extends JpaRepository<UserInfo, Long> {
}
