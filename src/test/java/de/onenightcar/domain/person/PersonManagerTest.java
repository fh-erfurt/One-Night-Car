package de.onenightcar.domain.person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonManagerTest {

    @Test
    void testing_of_the_counter_return_and_increment_function(){
        PersonManager list = new PersonManager();

        Employee peter = new Employee(list);

        assertEquals(1, peter.getEmployeeID());
        assertEquals(2, list.getAndIncrementEmployeeCounter());
    }

    @Test
    void after_creating_a_customer_it_should_have_been_added_to_customers_list (){
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);

        assertEquals("Max", list.customers.get(0).firstName);
        assertEquals("Mustermann", list.customers.get(0).surname);
    }

    @Test
    void after_deleting_a_customer_it_should_not_longer_be_in_customer_list(){
        PersonManager list = new PersonManager();
        Customer max = new Customer(list);

        list.removeCustomerFromCustomers(max);

        assertEquals(true, list.customers.isEmpty());
    }
}

