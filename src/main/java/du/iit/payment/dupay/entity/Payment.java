package du.iit.payment.dupay.entity;


import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String payId;

    @Column(nullable = false)
    private LocalDateTime payDate;

    private Double payAmount;
    private String payConf;
    private String payWallet;

    @ManyToOne
    private Merchant merchant;

    @PrePersist
    private void createDate(){
        this.payDate = LocalDateTime.now();
    }
}
