package du.iit.payment.dupay.entities;

import du.iit.payment.dupay.data.MerchantType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@ToString
@Entity
@Table(name = "merchant",
  indexes = {
    @Index(name = "idx_username", columnList = "username", unique = true),
    @Index(name = "idx_email", columnList = "email", unique = true)
  })
public class Merchant {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  private String id;

  @NotBlank
  @Column(length = 20)
  @Length(max = 20)
  private String username;

  @NotBlank
  @Length(max = 100)
  @Column(length = 100)
  @Email(message = "Email should be valid")
  private String email;

  @NotBlank
  @Length(max = 50)
  @Column(length = 50)
  private String password;

  @Length(max = 100)
  @Column(length = 100)
  private String name;

  private String tradeInsurance;

  private String NID;

  private Double balance;

  @Enumerated(EnumType.STRING)
  @Column(length = 25)
  private MerchantType type;

  private String code;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_admin_id"))
  private Admin addedBy;

  @Tolerate
  public Merchant() {

  }
}
