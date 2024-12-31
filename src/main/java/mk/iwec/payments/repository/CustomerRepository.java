package mk.iwec.payments.repository;

import mk.iwec.payments.model.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, UUID> {
}
