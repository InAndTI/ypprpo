package nsu.ypprpo.peoples_world.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nsu.ypprpo.peoples_world.exceptions.CustomException;
import nsu.ypprpo.peoples_world.repository.UserRepository;
import nsu.ypprpo.peoples_world.security.JwtService;
import nsu.ypprpo.peoples_world.security.UserDetailsImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nsu.ypprpo.peoples_world.models.User;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

  public String register(User request) {
    var user = UserDetailsImpl.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();
    var userFromDB = this.repository.findByUsername(user.getUsername());
    if(userFromDB.isPresent()) {
      logger.info("найден пользователь с такими данными");
      return null;
    }
    repository.save(request);
    return jwtService.generateToken(user);
  }

  public String authenticate(AuthenticationRequest request) {
    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      request.getUsername(),
                      request.getPassword()
              )
      );
    }
    catch (AuthenticationException ex){
      throw new CustomException("Введен неверный адрес или пароль");
    }
    var user = repository.findByUsername(request.getUsername());
    if(user.isEmpty()){
      return null;
    }
    return jwtService.generateToken(new UserDetailsImpl(user.get()));
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String username;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    username = jwtService.extractUsername(refreshToken);
    if (username != null) {
      var user = this.repository.findByUsername(username)
              .orElseThrow();
      if (jwtService.isTokenExpired(refreshToken, new UserDetailsImpl(user))) {
        var accessToken = jwtService.generateToken(new UserDetailsImpl(user));
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
