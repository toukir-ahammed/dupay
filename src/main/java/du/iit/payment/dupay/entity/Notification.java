package du.iit.payment.dupay.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDateTime;

@ToString
@Data
@Entity
public class Notification{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String ntfId;
    private LocalDateTime notificationDate;
    private String message;
    private NotificationStatus status;

    private String senderId;
    private String receiverId;

}
