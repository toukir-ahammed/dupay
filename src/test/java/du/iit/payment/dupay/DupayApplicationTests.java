package du.iit.payment.dupay;

import du.iit.payment.dupay.entities.Admin;
import du.iit.payment.dupay.entities.Merchant;
import du.iit.payment.dupay.entities.OTP;
import du.iit.payment.dupay.entities.Payment;
import du.iit.payment.dupay.repositories.OTPRepository;
import du.iit.payment.dupay.services.PaymentService;
import du.iit.payment.dupay.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class DupayApplicationTests {

  @Autowired
  UserService userService;

  @Autowired
  PaymentService paymentService;

  @Autowired
  OTPRepository otpRepository;

  @Test
  public void contextLoads() {
  }

  @Test
  public void userCreationTest(){
    Admin admin = Admin
      .builder()
      .username("chinmoy")
      .email("iit@gmail.com")
      .password("chin")
      .build();

    Admin savedAdmin = userService.createAdmin(admin);
    Assert.assertEquals(savedAdmin.getUsername(), admin.getUsername());

    Merchant merchant = Merchant
      .builder()
      .username("jamil")
      .email("jamil@gmail.com")
      .password("hadi")
      .addedBy(savedAdmin)
      .build();
    Merchant savedMerchant = userService.createMerchant(merchant);

    Assert.assertEquals(merchant.getUsername(), savedMerchant.getUsername());
    Assert.assertEquals(merchant.getAddedBy(), savedAdmin);

  }

  @Test
  public void paymentTest(){
    Admin admin = Admin
      .builder()
      .username("abc")
      .email("iit2@gmail.com")
      .password("def")
      .build();

    Admin savedAdmin = userService.createAdmin(admin);
    Merchant merchant =  Merchant
      .builder()
      .username("xyz")
      .email("ch@gmail.com")
      .password("jamil")
      .addedBy(savedAdmin)
      .build();
    Merchant savedMerchant = userService.createMerchant(merchant) ;

    Payment payment1 = Payment.builder().merchant(savedMerchant).build();
    Payment payment2 = Payment.builder().merchant(savedMerchant).build();

    payment1 = paymentService.createPayment(payment1);
    payment2 = paymentService.createPayment(payment2);

    Assert.assertNotEquals(payment1.getId(), payment2.getId());
    Assert.assertEquals(payment1.getMerchant(), payment2.getMerchant());

    System.out.println(payment1.getPayDate());
    System.out.println(payment1.getId());
    System.out.println(payment2.getId());
  }

  @Test
  public void otp_test(){
    OTP otp = OTP.builder().otpCode("123").otpEmail("xyz@gmail.com").build();
    otp = otpRepository.save(otp);
    Assert.assertNotNull(otp);
    Assert.assertNotNull(otp.getOtpCode());
    Assert.assertNotNull(otp.getOtpEmail());
  }

}
