package mk.iwec.payments.mapper;

import mk.iwec.payments.dto.CustomerDTO;
import mk.iwec.payments.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends GeneralMapper<Customer, CustomerDTO>{
}
