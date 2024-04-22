package nsu.ypprpo.peoples_world.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import nsu.ypprpo.peoples_world.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, columnDefinition = "text")
    private String username;
    @Column(nullable = false, columnDefinition = "text")
    @Size(min = 8, message = "Пароль должен содержать не менее 8 символов")
    private String password;

}