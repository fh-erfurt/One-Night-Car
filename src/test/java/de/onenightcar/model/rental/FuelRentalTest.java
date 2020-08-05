package de.onenightcar.model.rental;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.parkingArea.ParkingArea;
import de.onenightcar.model.person.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FuelRentalTest {

    @Test
    void testSetFuelLevelAfter(){
        Customer customer = new Customer();

        ParkingArea parkingArea = new ParkingArea();

        LocalDate date = LocalDate.of(2020, 07, 11);

        RentalTimeSlot rentalTimeSlot1 = new RentalTimeSlot(LocalTime.of(8,0), LocalTime.of(9,0));
        RentalTimeSlot rentalTimeSlot2 = new RentalTimeSlot(LocalTime.of(9,0), LocalTime.of(10,0));

        List<RentalTimeSlot> rentalTimeSlotList = new ArrayList<>();

        rentalTimeSlotList.add(rentalTimeSlot1);
        rentalTimeSlotList.add(rentalTimeSlot2);


        CombustionCar CombustionCar = new CombustionCar(parkingArea);
        FuelRental rental2 = new FuelRental( CombustionCar, date, customer, rentalTimeSlotList);
        rental2.setOdometerAfter();
        rental2.setFuelLevelAfter(CombustionCar);
        assertEquals(-1, rental2.getFuelLevelAfter(), "The car had to be refueled already in order to drive this far.");
    }

}
