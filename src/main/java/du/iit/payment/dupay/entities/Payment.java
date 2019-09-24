package du.iit.payment.dupay.entities;


import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@Table(name = "payment", indexes = {
  @Index(name = "idx_pay_date", columnList = "pay_date"),
  @Index(name = "idx_merchant_id", columnList = "merchant_id")})
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  @Column(name = "pay_date")
  private LocalDateTime payDate;

  private Double payAmount;
  private String payConf;
  private String payWallet;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_merchant_id"))
  private Merchant merchant;
}
