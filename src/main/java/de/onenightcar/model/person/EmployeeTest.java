package de.onenightcar.model.person;

import de.onenightcar.model.car.*;
import de.onenightcar.model.parkingArea.ElectricParkingArea;
import de.onenightcar.model.parkingArea.ParkingArea;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmployeeTest {

    @Test
    void an_employee_type_of_activity_can_be_changed() {
        Employee peter = new Employee();

        peter.setTypeOfActivity(Employee.TypeOfActivity.MAINTAINER);

        assertEquals(Employee.TypeOfActivity.MAINTAINER, peter.getTypeOfActivity());
    }

    @Test
    void an_employee_repairs_an_electric_car(){
        LocalDateTime dateOfBirth;
        dateOfBirth = LocalDateTime.of(1985,2,20,00,00);
        PersonAddress thisAddress = new PersonAddress();
        Employee john = new Employee("John", "Schmidt", dateOfBirth, thisAddress,
                 2000, Employee.TypeOfActivity.MAINTAINER);

        ElectricParkingArea Area1 = new ElectricParkingArea();

        ElectricCar testElectricCar = new ElectricCar(Area1);

        testElectricCar.changeCarState(Car.State.DAMAGED);
        john.employeeRepairsElectricCar(testElectricCar);

        assertNotEquals(Car.State.PERFECT,  testElectricCar.getCarState());
    }

    @Test
    void an_employee_refuels_a_combustion_car(){
        LocalDateTime dateOfBirth;
        dateOfBirth = LocalDateTime.of(1985,2,20,00,00);
        PersonAddress thisAddress = new PersonAddress();
        Employee john = new Employee("John", "Schmidt", dateOfBirth, thisAddress,
                 2000, Employee.TypeOfActivity.MAINTAINER);


        ParkingArea parkingArea = new ParkingArea();

        CombustionCar testCombustionCar = new CombustionCar(parkingArea);

        testCombustionCar.setFuelLevel(20);
        john.employeeRefuelsCar(testCombustionCar);

        assertEquals(100, testCombustionCar.getFuelLevel());
    }

    @Test
    void the_address_of_a_person_can_be_changed(){
        Employee peter = new Employee();
        PersonAddress testAddress = new PersonAddress("07743", "Jena", "Am Planetarium", "38");

        peter.setPersonAddress(testAddress);

        assertEquals("07743", peter.getPersonAddress().getZIP());
        assertEquals("Jena", peter.getPersonAddress().getCity());
        assertEquals("Am Planetarium", peter.getPersonAddress().getStreet());
        assertEquals("38", peter.getPersonAddress().getStreetNumber());
    }

    @Test
    void the_name_of_a_person_can_be_changed(){
        Employee peter = new Employee();

        peter.setNewName("Peter","Muller");

        assertEquals("Peter Muller", peter.getName());
    }
}