package du.iit.payment.dupay;

import du.iit.payment.dupay.entity.Admin;
import du.iit.payment.dupay.entity.Merchant;
import du.iit.payment.dupay.entity.OTP;
import du.iit.payment.dupay.entity.Payment;
import du.iit.payment.dupay.repository.OTPRepository;
import du.iit.payment.dupay.service.PaymentService;
import du.iit.payment.dupay.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DupayApplicationTests {

    Logger logger = LoggerFactory.getLogger(DupayApplicationTests.class);

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
        Admin admin = Admin.builder().username("chinmoy").email("iit@gmail.com").build();
        Admin savedAdmin = userService.createAdmin(admin);
        Assert.assertEquals(savedAdmin.getUsername(), admin.getUsername());

        Merchant merchant = Merchant.builder().username("jamil").addedBy(savedAdmin).build();
        Merchant savedMerchant = userService.createMerchant(merchant);

        Assert.assertEquals(merchant.getUsername(), savedMerchant.getUsername());
        Assert.assertEquals(merchant.getAddedBy(), savedAdmin);

    }

    @Test
    public void paymentTest(){
        Admin admin = Admin.builder().username("abc").email("iit@gmail.com").build();
        Admin savedAdmin = userService.createAdmin(admin);
        Merchant merchant =  Merchant.builder().username("xyz").addedBy(savedAdmin).build();
        Merchant savedMerchant = userService.createMerchant(merchant) ;

        Payment payment1 = Payment.builder().merchant(savedMerchant).build();
        Payment payment2 = Payment.builder().merchant(savedMerchant).build();

        payment1 = paymentService.createPayment(payment1);
        payment2 = paymentService.createPayment(payment2);

        Assert.assertNotEquals(payment1.getPayId(), payment2.getPayId());
        Assert.assertEquals(payment1.getMerchant(), payment2.getMerchant());

        System.out.println(payment1.getPayDate());
        System.out.println(payment1.getPayId());
        System.out.println(payment2.getPayId());
    }

    @Test
    public void otp_test(){
        OTP otp = OTP.builder().OTPCode("123").OTPEmail("xyz@gmail.com").build();
        otp = otpRepository.save(otp);
        Assert.assertNotNull(otp);
        Assert.assertNotNull(otp.getOTPCode());
        Assert.assertNotNull(otp.getOTPEmail());
    }

}
