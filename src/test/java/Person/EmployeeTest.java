package Person;

import Car.*;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmployeeTest {

    @Test
    void an_employee_type_of_activity_can_be_changed() {
        PersonManager list = new PersonManager();
        Employee peter = new Employee(list);

        peter.setTypeOfActivity(Employee.TypeOfActivity.MAINTAINER);

        assertEquals(Employee.TypeOfActivity.MAINTAINER, peter.getTypeOfActivity());
    }

    @Test
    void an_employee_repairs_an_electric_car(){
        PersonManager list = new PersonManager();
        GregorianCalendar dateOfBirth = new GregorianCalendar(1985,GregorianCalendar.FEBRUARY,20);
        PersonAddress thisAddress = new PersonAddress();
        Employee john = new Employee("John", "Schmidt", dateOfBirth, thisAddress,
                list, 2000, Employee.TypeOfActivity.MAINTAINER);
        ElectricCar testElectricCar = new ElectricCar();

        testElectricCar.changeCarState(Car.State.DAMAGED);
        john.employeeRepairsElectricCar(testElectricCar);

        assertNotEquals(Car.State.PERFECT,  testElectricCar.getCarState());
    }

    @Test
    void an_employee_refuels_a_combustion_car(){
        PersonManager list = new PersonManager();
        GregorianCalendar dateOfBirth = new GregorianCalendar(1985,GregorianCalendar.FEBRUARY,20);
        PersonAddress thisAddress = new PersonAddress();
        Employee john = new Employee("John", "Schmidt", dateOfBirth, thisAddress,
                list, 2000, Employee.TypeOfActivity.MAINTAINER);
        CombustionCar testCombustionCar = new CombustionCar();

        testCombustionCar.setFuelLevel(20);
        john.employeeRefuelsCar(testCombustionCar);

        assertEquals(100, testCombustionCar.getFuelLevel());
    }

    @Test
    void the_address_of_a_person_can_be_changed(){
        PersonManager list = new PersonManager();
        Employee peter = new Employee(list);
        PersonAddress testAddress = new PersonAddress("07743", "Jena", "Am Planetarium", "38");

        peter.setPersonAddress(testAddress);

        assertEquals("07743", peter.getPersonAddress().getZIP());
        assertEquals("Jena", peter.getPersonAddress().getCity());
        assertEquals("Am Planetarium", peter.getPersonAddress().getStreet());
        assertEquals("38", peter.getPersonAddress().getStreetNumber());
    }

    @Test
    void the_name_of_a_person_can_be_changed(){
        PersonManager list = new PersonManager();
        Employee peter = new Employee(list);

        peter.setNewName("Peter","Muller");

        assertEquals("Peter Muller", peter.getName());
    }
}