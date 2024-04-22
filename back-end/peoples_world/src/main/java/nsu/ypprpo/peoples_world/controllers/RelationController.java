package nsu.ypprpo.peoples_world.controllers;

import nsu.ypprpo.peoples_world.Requests.RelationRequest;
import nsu.ypprpo.peoples_world.models.Relation;
import nsu.ypprpo.peoples_world.services.RelationService;
import nsu.ypprpo.peoples_world.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relations")
@CrossOrigin(origins = "http://localhost:3000")
public class RelationController {
    @Autowired
    private RelationService relationService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // Создание отношения
    @PostMapping
    public ResponseEntity<Relation> createRelation(@RequestBody RelationRequest relation) {
        logger.info(relation.toString());
        Relation newRelation = relationService.createRelation(relation);
        return new ResponseEntity<>(newRelation, HttpStatus.CREATED);
    }

    // Получение всех отношений
    @GetMapping
    public ResponseEntity<List<Relation>> getAllRelations() {
        List<Relation> relations = relationService.getAllRelations();
        return new ResponseEntity<>(relations, HttpStatus.OK);
    }

    // Получение отношения по идентификатору пользователя
    @GetMapping("/{user1Id}")
    public ResponseEntity<List<Relation>> getRelationByIds(@PathVariable Long user1Id) {
        List<Relation> relation = relationService.getRelationById(user1Id);
        return new ResponseEntity<>(relation, HttpStatus.OK);
    }

    // Обновление отношения
    @PutMapping
    public ResponseEntity<Relation> updateRelation(@RequestBody Relation relation) {
        Relation updatedRelation = relationService.updateRelation(relation);
        return new ResponseEntity<>(updatedRelation, HttpStatus.OK);
    }

    // Удаление отношения
    @DeleteMapping("/{user1Id}/{user2Id}")
    public ResponseEntity<Void> deleteRelationByIds(@PathVariable Long user1Id, @PathVariable Long user2Id) {
        relationService.deleteRelationByIds(user1Id, user2Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
