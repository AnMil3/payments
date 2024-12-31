package mk.iwec.payments.dto;

public record CustomerDTO(
        String firstName,
        String lastName,
        LocationDTO location
) {
}
