package de.onenightcar.model.rental;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.parkingArea.ElectricParkingArea;
import de.onenightcar.model.person.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ElectricRentalTest {

    @Test
    void testSetChargePercentAfter (){

        Customer customer = new Customer();

        ElectricParkingArea Area1 = new ElectricParkingArea();

        LocalDate date = LocalDate.of(2020, 07, 20);

        RentalTimeSlot rentalTimeSlot1 = new RentalTimeSlot(LocalTime.of(8,0), LocalTime.of(9,0));
        RentalTimeSlot rentalTimeSlot2 = new RentalTimeSlot(LocalTime.of(9,0), LocalTime.of(10,0));

        List<RentalTimeSlot> rentalTimeSlotList = new ArrayList<>();

        rentalTimeSlotList.add(rentalTimeSlot1);
        rentalTimeSlotList.add(rentalTimeSlot2);

        ElectricCar electricCar = new ElectricCar(Area1);
        ElectricRental rental1 = new ElectricRental(electricCar, date, customer, rentalTimeSlotList);

        rental1.setOdometerAfter();
        rental1.setChargePercentAfter(electricCar);
        assertEquals(0.6800000071525574, rental1.getChargePercentAfter());

    }

    @Test
    void testElapsedHours(){
        Customer customer = new Customer();

        ElectricParkingArea Area1 = new ElectricParkingArea();
        ElectricCar electricCar = new ElectricCar(Area1);
        ElectricRental rental1 = new ElectricRental(electricCar, customer);

        int days = rental1.calculateElapsedHours();

        assertEquals(1, days);
    }

    @Test
    void testSetOdometerAfter(){
        Customer customer = new Customer();

        ElectricParkingArea Area1 = new ElectricParkingArea();

        ElectricCar electricCar = new ElectricCar(Area1);
        ElectricRental rental1 = new ElectricRental(electricCar, customer);

        rental1.setOdometerAfter();
        long odometer = rental1.getOdometerAfter();
        assertEquals(32, odometer);
    }

}
