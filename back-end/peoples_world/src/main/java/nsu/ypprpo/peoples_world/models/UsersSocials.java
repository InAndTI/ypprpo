package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_socials")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UsersSocials_pk.class)
public class UsersSocials {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Id
    private User user;
    @ManyToOne
    @JoinColumn(name = "social_id")
    @Id
    private SocialNetwork social;
}
