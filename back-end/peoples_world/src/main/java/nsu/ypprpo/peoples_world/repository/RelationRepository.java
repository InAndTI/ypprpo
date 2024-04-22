package nsu.ypprpo.peoples_world.repository;

import nsu.ypprpo.peoples_world.models.Relation;
import nsu.ypprpo.peoples_world.models.Relation_pk;
import nsu.ypprpo.peoples_world.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RelationRepository extends JpaRepository<Relation, Relation_pk> {
//    @Query(value = "SELECT * FROM relations WHERE user1_id =?1", nativeQuery = true)
//    Optional<User> findByUser1Id(String username);
//    List<Relation> findByUser1Id(Long user1);
//    void deleteByUser1IdAndUser2Id(User user1, User user2);
}
