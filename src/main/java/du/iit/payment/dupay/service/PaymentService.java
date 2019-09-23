package du.iit.payment.dupay.service;

import du.iit.payment.dupay.entity.Payment;
import du.iit.payment.dupay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

}
