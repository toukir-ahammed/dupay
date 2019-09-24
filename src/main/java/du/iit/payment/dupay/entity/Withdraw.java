package du.iit.payment.dupay.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Data
@Entity
public class Withdraw {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String withdrawId;
    private LocalDateTime withdrawDate;
    private WithdrawStatus status;
    private WithdrawWalletType type;
    private String withdrawBranch;
    private String withdrawAccNo;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Merchant merchant;

    @PrePersist
    private void createDate(){
        this.withdrawDate = LocalDateTime.now();
    }
}
