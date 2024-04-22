package nsu.ypprpo.peoples_world.services;

import nsu.ypprpo.peoples_world.Requests.RelationRequest;
import nsu.ypprpo.peoples_world.exceptions.CustomException;
import nsu.ypprpo.peoples_world.models.Relation;
import nsu.ypprpo.peoples_world.models.Relation_pk;
import nsu.ypprpo.peoples_world.models.User;
import nsu.ypprpo.peoples_world.repository.RelationRepository;
import nsu.ypprpo.peoples_world.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationService {
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);



    // Создание отношения
    public Relation createRelation(RelationRequest relation) {
        User user1 = userRepository.findById(relation.getUser1Id()).orElseThrow();
        User user2 = userRepository.findById(relation.getUser2Id()).orElseThrow();

        Relation_pk pk = new Relation_pk(user1, user2);

        Relation relation1 = new Relation();
        relation1.setId(pk);
        relation1.setDirection(relation.getDirection());

        return relationRepository.save(relation1);
    }


    // Получение всех отношений
    public List<Relation> getAllRelations() {
        return relationRepository.findAll();
    }

    // Получение отношения по идентификаторам пользователей
    public List<Relation> getRelationById(Long user1Id) {
//        return relationRepository.findByUser1Id(user1Id);
        return null;
    }

    // Обновление отношения
    public Relation updateRelation(Relation relation) {
        return relationRepository.save(relation);
    }

    // Удаление отношения по идентификаторам пользователей
    public void deleteRelationByIds(Long user1Id, Long user2Id) {
//        relationRepository.deleteByUser1IdAndUser2Id(userRepository.findById(user1Id).orElseThrow(),
//                userRepository.findById(user2Id).orElseThrow());
    }
}
