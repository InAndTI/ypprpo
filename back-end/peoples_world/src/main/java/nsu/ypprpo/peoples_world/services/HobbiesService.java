package nsu.ypprpo.peoples_world.services;

import nsu.ypprpo.peoples_world.models.Hobby;
import nsu.ypprpo.peoples_world.repository.HobbiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HobbiesService {
    @Autowired
    private HobbiesRepository hobbyRepository;

    // Создание хобби
    public Hobby createHobby(Hobby hobby) {
        return hobbyRepository.save(hobby);
    }

    // Получение всех хобби
    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }

    // Получение хобби по ID
    public Hobby getHobbyById(Integer id) {
        Optional<Hobby> hobbyOptional = hobbyRepository.findById(id);
        return hobbyOptional.orElse(null);
    }

    // Обновление хобби
    public Hobby updateHobby(Integer id, Hobby hobby) {
        Hobby existingHobby = getHobbyById(id);
        if (existingHobby != null) {
            hobby.setHobby_id(id);
            return hobbyRepository.save(hobby);
        }
        return null;
    }

    // Удаление хобби по ID
    public void deleteHobbyById(Integer id) {
        hobbyRepository.deleteById(id);
    }
}
