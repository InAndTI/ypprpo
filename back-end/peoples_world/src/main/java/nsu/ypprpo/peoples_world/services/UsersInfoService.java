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
    }

    public UserInfo updateUserInfo(Long id, UserInfo userInfo) {
        userInfo.setUser_id(id);
        return userInfoRepository.save(userInfo);
    }

    public void deleteUserInfo(Long id) {
        userInfoRepository.deleteById(id);
    }

    public List<UserInfo> getAllUserInfo() {
        return userInfoRepository.findAll();
    }
}
