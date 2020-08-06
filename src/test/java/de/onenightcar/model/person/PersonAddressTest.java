package de.onenightcar.model.person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonAddressTest {

    @Test
    void change_street() {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setStreet("1");

//        assertEquals("A", personAddress.getStreet());
    }


}
