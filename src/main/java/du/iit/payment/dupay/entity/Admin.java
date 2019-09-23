package du.iit.payment.dupay.entity;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.Id;
@Builder
@Data
@ToString
@Entity
public class Admin {
    @Id
    private String username;
    private String email;
    private String password;
    private String name;
    @Tolerate
    public Admin(){

    }
}
