package nsu.ypprpo.peoples_world.controllers;

import nsu.ypprpo.peoples_world.models.UserInfo;
import nsu.ypprpo.peoples_world.services.UserService;
import nsu.ypprpo.peoples_world.services.UsersInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/userinfo")
public class UsersInfoController {

    @Autowired
    private UsersInfoService userInfoService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @GetMapping
    public ResponseEntity<List<UserInfo>> getAllUserInfo() {
        List<UserInfo> allUserInfo = userInfoService.getAllUserInfo();
        return ResponseEntity.ok(allUserInfo);
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserInfo> createUserInfo(@PathVariable("id") Long id, @RequestBody UserInfo userInfo) {
        userInfoService.createUserInfo(id, userInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserInfoById(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        return ResponseEntity.ok(userInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateUserInfo(@PathVariable Long id, @RequestBody UserInfo userInfo) {
        UserInfo updatedUserInfo = userInfoService.updateUserInfo(id, userInfo);
        return ResponseEntity.ok(updatedUserInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserInfo(@PathVariable Long id) {
        userInfoService.deleteUserInfo(id);
        return ResponseEntity.noContent().build();
    }
}
