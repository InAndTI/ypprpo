package nsu.ypprpo.peoples_world.repository;

import nsu.ypprpo.peoples_world.models.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbiesRepository extends JpaRepository<Hobby, Integer> {
}
