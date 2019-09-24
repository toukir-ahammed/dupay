package du.iit.payment.dupay.entities;

import du.iit.payment.dupay.data.NotificationStatus;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Data
@Entity
@Table(name = "notification",
  indexes = {@Index(name = "idx_time", columnList = "notification_date")})
public class Notification{
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  private String id;

  @CreationTimestamp
  @Column(name = "notification_date")
  private LocalDateTime notificationDate;

  private String message;

  @Enumerated(EnumType.STRING)
  @Column(length = 25)
  private NotificationStatus status;

  private String senderId;
  private String receiverId;

}
