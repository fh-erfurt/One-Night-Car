package Person;

import Person.Customer;
import ZuLöschen.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.GregorianCalendar;

class CustomerTest {

    List customers = new List();
    Customer customer1 = new Customer("Mustermann", "Max", "99099","Marktstraße",
            "12",new GregorianCalendar(1990,GregorianCalendar.AUGUST,14),
             Customer.CustomerType.REGULARUSER,"1", Customer.CardType.CREDITCARD,
            new GregorianCalendar(2019,GregorianCalendar.DECEMBER,31),"STU56BN",customers);


   /* @Test
    public void test_If_State_Is_Changed_When_Customer_Damages_Car () {

        customer1.customerDamagesCar();
    } */

   @Test
    public void should_Change_Payment_Method () {

       customer1.modifyPaymentMethod("2", Customer.CardType.CREDITCARD,
               new GregorianCalendar(2020,GregorianCalendar.DECEMBER,31), "VKN85JK");

       assertEquals(customer1.getCardNumber(),"2");
   }
}