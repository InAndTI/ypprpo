package nsu.ypprpo.peoples_world.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nsu.ypprpo.peoples_world.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.Valid;


import java.io.IOException;
import nsu.ypprpo.peoples_world.exceptions.CustomException;
import nsu.ypprpo.peoples_world.models.User;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
  private final AuthenticationService service;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody @Valid User user
  ) {
      String jwtToken = service.register(user);
      if(jwtToken == null){
        throw new CustomException("Такой пользователь уже существует");
      }
      return ResponseEntity.ok(AuthenticationResponse.builder()
                                .accessToken(jwtToken)
                                .build());
  }

  @PostMapping("/authenticate")
  public ResponseEntity<Output> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    String jwtToken = service.authenticate(request);
    logger.info(jwtToken);
    if(!userService.isPasswordCorrect(request.getUsername(), request.getPassword())){
      throw new CustomException("Введен неверный адрес или пароль");
    }

    Output output = new Output();
    output.token = AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .build();
    output.id=userService.getUserId(request.getUsername());

    return ResponseEntity.ok(output);
  }



  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
      service.refreshToken(request, response);
  }


}
