package du.iit.payment.dupay.repository;

import du.iit.payment.dupay.entity.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, String> {
}
