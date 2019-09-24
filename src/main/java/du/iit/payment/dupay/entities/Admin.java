package du.iit.payment.dupay.entities;

import lombok.*;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@Entity
@Table(name = "admin",
    indexes = {
      @Index(name = "idx_username", columnList = "username", unique = true),
      @Index(name = "idx_email", columnList = "email", unique = true)
})
public class Admin {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Length(max = 20)
  @Column(length = 20)
  private String username;

  @NotBlank
  @Email(message = "Email should be valid")
  @Column(length = 100)
  private String email;

  @NotBlank
  @Length(max = 50)
  @Column(length = 50)
  private String password;

  @Length(max = 100)
  @Column(length = 100)
  private String name;

  @Tolerate
  public Admin(){

  }
}
