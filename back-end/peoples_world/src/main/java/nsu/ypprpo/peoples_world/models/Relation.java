package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "relations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Relation {
    @EmbeddedId
    private Relation_pk id;

    /**
    * values: <br>
     * user1 - user1 sends request to user2 <br>
     * user2 - user2 sends request to user1 <br>
     * 0 - they are friends
    **/
    @Column
    private Integer direction;
}
