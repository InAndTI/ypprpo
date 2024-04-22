package nsu.ypprpo.peoples_world.controllers;

import nsu.ypprpo.peoples_world.Requests.RelationRequest;
import nsu.ypprpo.peoples_world.Requests.UsersHobbiesRequest;
import nsu.ypprpo.peoples_world.models.Relation;
import nsu.ypprpo.peoples_world.models.UsersHobbies;
import nsu.ypprpo.peoples_world.services.RelationService;
import nsu.ypprpo.peoples_world.services.UserService;
import nsu.ypprpo.peoples_world.services.UsersHobbiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users_hobbies")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersHobbiesController {
    @Autowired
    private UsersHobbiesService usersHobbiesService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostMapping
    public ResponseEntity<UsersHobbies> createRelation(@RequestBody UsersHobbiesRequest request) {
        logger.info(request.toString());
        UsersHobbies usersHobbies = usersHobbiesService.create(request);
        return new ResponseEntity<>(usersHobbies, HttpStatus.CREATED);
    }
}
