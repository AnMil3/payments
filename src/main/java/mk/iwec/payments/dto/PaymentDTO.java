package mk.iwec.payments.dto;

public record PaymentDTO(
        Double amount,
        String type,
        CustomerDTO customer
) {
}
