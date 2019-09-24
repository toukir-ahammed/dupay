package du.iit.payment.dupay.services;

import du.iit.payment.dupay.repositories.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
  private WithdrawRepository withdrawRepository;

  @Autowired
  public WithdrawService(WithdrawRepository withdrawRepository) {
    this.withdrawRepository = withdrawRepository;
  }
}
