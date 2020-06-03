package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.ElectricCar;
import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import de.onenightcar.domain.model.person.Customer;
import de.onenightcar.domain.model.person.PersonManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalManagerTest {

    @Test
    void testGetAndIncrementCounter() {
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        assertEquals(2, rentalManager.getAndIncrementCounter());
    }

    @Test
    void testAddRentalIntoElectricRentals() {
        RentalManager rentalManager = new RentalManager();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);

        assertEquals(1, rentalManager.getAndIncrementCounter());

        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        assertEquals(3, rentalManager.getAndIncrementCounter());
    }

    @Test
    void testRemoveRentalFromElectricRentals() {
        RentalManager rentalManager = new RentalManager();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        assertEquals(2, rentalManager.getAndIncrementCounter());

        rentalManager.removeRentalFromElectricsRentals(rental1);

        assertEquals(2, rentalManager.getAndIncrementCounter());
    }

    @Test
    void testGetSizeOfElectricRentals(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        Customer customer2 = new Customer(personManager);
        ElectricCar electricCar2 = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental2 = new ElectricRental(rentalManager, carManagementSystem, customer2.getCustomerID(), electricCar2);


        assertEquals(2, rentalManager.getSizeOfElectricRentals());
    }

    @Test
    void testGetRentalIDFromElectricRentals(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        assertEquals(1, rentalManager.getRentalIDFromElectricRentals(rental1));
    }

    @Test
    void testReturnElectricRentalWithIndex(){
        RentalManager rentalManager = new RentalManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();
        PersonManager personManager = new PersonManager();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        Customer customer = new Customer(personManager);
        ElectricCar electricCar = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental1 = new ElectricRental(rentalManager, carManagementSystem, customer.getCustomerID(), electricCar);

        Customer customer2 = new Customer(personManager);
        ElectricCar electricCar2 = new ElectricCar(carManagementSystem, electricParkingArea);
        ElectricRental rental2 = new ElectricRental(rentalManager, carManagementSystem, customer2.getCustomerID(), electricCar2);

        assertEquals(1, rentalManager.returnElectricRentalWithIndex(rental2));
    }
}
