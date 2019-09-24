package du.iit.payment.dupay.entities;

import du.iit.payment.dupay.data.WithdrawStatus;
import du.iit.payment.dupay.data.WithdrawWalletType;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ToString
@Data
@Entity
@Table(name = "withdraw")
public class Withdraw {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  private LocalDateTime withdrawDate;

  @Column(length = 25)
  @Enumerated(EnumType.STRING)
  private WithdrawStatus status;

  @Column(length = 25)
  @Enumerated(EnumType.STRING)
  private WithdrawWalletType type;

  private String withdrawBranch;

  private String withdrawAccNo;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_admin_id"))
  private Admin admin;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_merchant_id"))
  private Merchant merchant;

}
