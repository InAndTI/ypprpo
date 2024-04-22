package nsu.ypprpo.peoples_world.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersSocials_pk implements Serializable {
    private Long user;
    private Long social;
    public UsersSocials_pk(Long user, Long social) {
        this.user = user;
        this.social = social;
    }
}
