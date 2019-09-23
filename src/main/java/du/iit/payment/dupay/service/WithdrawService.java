package du.iit.payment.dupay.service;

import du.iit.payment.dupay.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
    @Autowired
    WithdrawRepository withdrawRepository;
}
