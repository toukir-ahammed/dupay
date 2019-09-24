package du.iit.payment.dupay.services;

import du.iit.payment.dupay.entities.Admin;
import du.iit.payment.dupay.entities.Merchant;
import du.iit.payment.dupay.repositories.AdminRepository;
import du.iit.payment.dupay.repositories.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
  private AdminRepository adminRepository;
  private MerchantRepository merchantRepository;

  @Autowired
  public UserService(AdminRepository adminRepository, MerchantRepository merchantRepository){
    this.adminRepository = adminRepository;
    this.merchantRepository = merchantRepository;
  }

  public Admin createAdmin(Admin admin){
    log.info(String.format("%s is created", admin));
    return adminRepository.save(admin);
  }

  public Merchant createMerchant(Merchant merchant){
    log.info(String.format("%s is created, added by %s", merchant, merchant.getAddedBy()));
    return merchantRepository.save(merchant);
  }

  public List<Merchant> getAllMerchants(){
    return merchantRepository.findAll();
  }
}
