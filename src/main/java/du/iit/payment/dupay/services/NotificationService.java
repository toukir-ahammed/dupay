package du.iit.payment.dupay.services;

import du.iit.payment.dupay.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  private NotificationRepository notificationRepository;

  @Autowired
  public NotificationService(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }
}
