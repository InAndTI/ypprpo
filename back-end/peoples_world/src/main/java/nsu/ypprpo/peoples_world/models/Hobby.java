package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hobbies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hobby_id;
    @Column(nullable=false, columnDefinition = "text")
    private String name;

    @ManyToMany(mappedBy = "hobbies")
    private Set<User> users = new HashSet<>();

}
