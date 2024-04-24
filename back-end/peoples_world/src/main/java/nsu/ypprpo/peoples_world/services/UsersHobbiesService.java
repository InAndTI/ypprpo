//package nsu.ypprpo.peoples_world.services;
//
//import nsu.ypprpo.peoples_world.Requests.UsersHobbiesRequest;
//import nsu.ypprpo.peoples_world.models.*;
//import nsu.ypprpo.peoples_world.repository.HobbiesRepository;
//import nsu.ypprpo.peoples_world.repository.UserRepository;
//import nsu.ypprpo.peoples_world.repository.UsersHobbiesRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UsersHobbiesService {
//    @Autowired
//    private UsersHobbiesRepository usersHobbiesRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private HobbiesRepository hobbiesRepository;
//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//
//    public UsersHobbies create(UsersHobbiesRequest request) {
//        User user = userRepository.findById(request.getUser()).orElseThrow();
//        Hobby hobby = hobbiesRepository.findById(request.getHobby()).orElseThrow();
//        logger.info(hobby.toString());
//
//        UsersHobbies_pk pk = new UsersHobbies_pk();
//        pk.setUser(user);
//        pk.setHobby(hobby);
//        UsersHobbies uh = new UsersHobbies();
//        uh.setId(pk);
//
//        return usersHobbiesRepository.save(uh);
//    }
//}
