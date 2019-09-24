package du.iit.payment.dupay.services;

import du.iit.payment.dupay.entities.Payment;
import du.iit.payment.dupay.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  private PaymentRepository paymentRepository;

  @Autowired
  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public Payment createPayment(Payment payment){
    return paymentRepository.save(payment);
  }

}
