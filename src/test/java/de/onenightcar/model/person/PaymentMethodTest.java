package de.onenightcar.model.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentMethodTest {

    @Test
    void change_CardNumber() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setCardNumber("0000 0000 0000 0002");

        assertEquals("0000 0000 0000 0002", paymentMethod.getCardNumber());
    }

}
