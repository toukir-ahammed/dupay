package du.iit.payment.dupay.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ToString
@Data
@Builder
@Entity
@Table(name = "otp", indexes = {@Index(name = "idx_otp_email", columnList = "otp_email")})
public class OTP{
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  private String id;

  @CreationTimestamp
  private LocalDateTime otpDate;

  @NotBlank
  @Column(nullable = false)
  private String otpCode;

  @Length(max = 100)
  @Column(nullable = false, name = "otp_email", length = 100)
  @Email(message = "Email should be valid")
  private String otpEmail;
}
