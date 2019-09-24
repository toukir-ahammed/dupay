package du.iit.payment.dupay.repositories;

import du.iit.payment.dupay.entities.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OTP, String> {
}
