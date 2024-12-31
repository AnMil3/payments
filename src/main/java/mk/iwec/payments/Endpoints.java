package mk.iwec.payments;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endpoints {
    public static final String LOCATION = "/locations";
    public static final String CUSTOMER = "/customers";
    public static final String PAYMENT = "/payments";
}
