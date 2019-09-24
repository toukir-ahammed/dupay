package du.iit.payment.dupay.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Builder
@Data
@ToString
@Entity
public class Merchant {
    @Id
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String tradeInsurance;
    private String NID;
    private Double balance;
    private MerchantType type;
    private String code;

    @NotNull
    @ManyToOne
    private Admin addedBy;

    @Tolerate
    public Merchant(){

    }
}
