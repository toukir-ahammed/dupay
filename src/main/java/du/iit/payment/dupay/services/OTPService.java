package du.iit.payment.dupay.services;

import du.iit.payment.dupay.repositories.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {
  private OTPRepository otpRepository;

  @Autowired
  public OTPService(OTPRepository otpRepository) {
    this.otpRepository = otpRepository;
  }
}
