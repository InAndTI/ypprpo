package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UsersHobbies_pk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id")
    private Hobby hobby;
}
