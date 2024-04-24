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
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Id
    private User user_id;
    private Integer age;
    private Integer height;
    @Enumerated(EnumType.STRING)
    private Enums.sexType sex;
    private Enums.zodiac zodiac_sign;
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
