package nsu.ypprpo.peoples_world.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


@Entity
@Table(name = "users_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private Long user_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    private Integer age;
    private Integer height;
    @Column(columnDefinition = "text")
    private String sex;
    @Column(columnDefinition = "text")
    private String zodiac_sign;
    @Column(columnDefinition = "text")
    private String habitation;
    @Column(columnDefinition = "text")
    private String language;
    @Column(columnDefinition = "text")
    private String about;
    @Column(columnDefinition = "text")
    private String name;
    private Timestamp date_of_reg;
}
