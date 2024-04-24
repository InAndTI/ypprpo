package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class Relation_pk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user1Id;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user2Id;
}
