package du.iit.payment.dupay.service;

import du.iit.payment.dupay.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {
    @Autowired
    private OTPRepository otpRepository;
}
