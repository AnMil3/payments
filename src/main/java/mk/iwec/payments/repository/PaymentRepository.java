package mk.iwec.payments.repository;

import mk.iwec.payments.model.Payment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends ListCrudRepository<Payment, UUID> {
}
