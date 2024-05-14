package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "social_networks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer social_id;
    @Column(nullable=false, columnDefinition = "text")
    private String name;

    @ManyToMany(mappedBy = "social_networks")
    private Set<User> users = new HashSet<>();
}
