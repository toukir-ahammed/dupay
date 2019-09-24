package du.iit.payment.dupay.repositories;

import du.iit.payment.dupay.entities.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, String> {
}
