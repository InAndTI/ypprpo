package nsu.ypprpo.peoples_world.services;

import nsu.ypprpo.peoples_world.exceptions.CustomException;
import nsu.ypprpo.peoples_world.models.User;
import nsu.ypprpo.peoples_world.models.UserInfo;
import nsu.ypprpo.peoples_world.repository.UserRepository;
import nsu.ypprpo.peoples_world.repository.UsersInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UsersInfoService {
    @Autowired
    private UsersInfoRepository userInfoRepository;
    @Autowired
    private UserRepository userRepository;

    public UserInfo getUserInfoById(Long id) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(id);
        return userInfoOptional.orElse(null);
    }

    public void createUserInfo(Long id, UserInfo userInfo) {
        userInfo.setDate_of_reg(new Timestamp(System.currentTimeMillis()));
        userInfo.setUser(userRepository.findById(id).orElseThrow(()-> new CustomException("Такой пользователь не найден")));
        userInfo.setUser_id(null);
        userInfoRepository.save(userInfo);
    }

    public UserInfo updateUserInfo(Long id, UserInfo newUserInfo) {
        UserInfo existingUserInfo = userInfoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Такой пользователь не найден"));

        // Здесь вы можете установить поля из newUserInfo в existingUserInfo
        existingUserInfo.setAbout(newUserInfo.getAbout());
        existingUserInfo.setAge(newUserInfo.getAge());
        existingUserInfo.setHeight(newUserInfo.getHeight());
        existingUserInfo.setSex(newUserInfo.getSex());
        existingUserInfo.setZodiac_sign(newUserInfo.getZodiac_sign());
        existingUserInfo.setHabitation(newUserInfo.getHabitation());
        existingUserInfo.setLanguage(newUserInfo.getLanguage());
        existingUserInfo.setAbout(newUserInfo.getAbout());
        existingUserInfo.setName(newUserInfo.getName());
        existingUserInfo.setDescription(newUserInfo.getDescription());
        existingUserInfo.setPath_to_photo(newUserInfo.getPath_to_photo());

        // После изменения полей, сохраняем обновленную информацию
        return userInfoRepository.save(existingUserInfo);
    }

    public void deleteUserInfo(Long id) {
        userInfoRepository.deleteById(id);
    }

    public List<UserInfo> getAllUserInfo() {
        return userInfoRepository.findAll();
    }
}
