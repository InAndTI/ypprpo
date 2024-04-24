package nsu.ypprpo.peoples_world.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersHobbiesRequest {
    private Long user;
    private Integer hobby;
}
