package mk.iwec.payments.repository;

import mk.iwec.payments.model.Location;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends ListCrudRepository<Location, UUID> {
}
