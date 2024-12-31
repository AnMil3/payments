package mk.iwec.payments.mapper;

import mk.iwec.payments.dto.PaymentDTO;
import mk.iwec.payments.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends GeneralMapper<Payment, PaymentDTO>{
}
