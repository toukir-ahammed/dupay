package du.iit.payment.dupay.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@ToString
@Data
@Builder
@Entity
public class OTP{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String OTPId;

    private LocalDateTime OTPDate;

    @NotBlank
    @Column(nullable = false)
    private String OTPCode;

    @Column(nullable = false)
    @Email(message = "Email should be valid")
    private String OTPEmail;
}
