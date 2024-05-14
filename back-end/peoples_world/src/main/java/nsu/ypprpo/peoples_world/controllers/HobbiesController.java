package nsu.ypprpo.peoples_world.controllers;

import nsu.ypprpo.peoples_world.models.Hobby;
import nsu.ypprpo.peoples_world.services.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hobbies")
public class HobbiesController {
    @Autowired
    private HobbiesService hobbyService;

    // Создание хобби
    @PostMapping
    public ResponseEntity<Hobby> createHobby(@RequestBody Hobby hobby) {
        Hobby newHobby = hobbyService.createHobby(hobby);
        return new ResponseEntity<>(newHobby, HttpStatus.CREATED);
    }

    // Получение всех хобби
    @GetMapping
    public ResponseEntity<List<Hobby>> getAllHobbies() {
        List<Hobby> hobbies = hobbyService.getAllHobbies();
        return new ResponseEntity<>(hobbies, HttpStatus.OK);
    }

    // Получение хобби по ID
    @GetMapping("/{id}")
    public ResponseEntity<Hobby> getHobbyById(@PathVariable Integer id) {
        Hobby hobby = hobbyService.getHobbyById(id);
        return new ResponseEntity<>(hobby, HttpStatus.OK);
    }

    // Обновление хобби
    @PutMapping("/{id}")
    public ResponseEntity<Hobby> updateHobby(@PathVariable Integer id, @RequestBody Hobby hobby) {
        Hobby updatedHobby = hobbyService.updateHobby(id, hobby);
        return new ResponseEntity<>(updatedHobby, HttpStatus.OK);
    }

    // Удаление хобби по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHobbyById(@PathVariable Integer id) {
        hobbyService.deleteHobbyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
