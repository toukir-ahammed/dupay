package du.iit.payment.dupay.service;

import du.iit.payment.dupay.entity.Admin;
import du.iit.payment.dupay.entity.Merchant;
import du.iit.payment.dupay.repository.AdminRepository;
import du.iit.payment.dupay.repository.MerchantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    MerchantRepository merchantRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public Admin createAdmin(Admin admin){
        logger.info(String.format("%s is created", admin));
        return adminRepository.save(admin);
    }

    public Merchant createMerchant(Merchant merchant){
        logger.info(String.format("%s is created, added by %s", merchant, merchant.getAddedBy()));
        return merchantRepository.save(merchant);
    }

    public List<Merchant> getAllMerchants(){
        return merchantRepository.findAll();
    }
}
