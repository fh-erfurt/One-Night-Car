package de.onenightcar.model.car;

import de.onenightcar.model.parkingArea.ParkingArea;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CombustionCarTest {
    @Test
    void testChangeCarState(){


        ParkingArea parkingArea = new ParkingArea();
        CombustionCar car1 = new CombustionCar(parkingArea);
        car1.changeCarState(Car.State.DAMAGED);

        /* assertEquals(Expected         , Actual            ); */
        assertEquals(Car.State.DAMAGED, car1.getCarState());
    }

    @Test
    void testGetTankedAndSetFuelLevel()
    {

        ParkingArea parkingArea = new ParkingArea();
        CombustionCar car1 = new CombustionCar(parkingArea);
        car1.setFuelLevel(29);
        car1.getTanked();
        assertEquals(100, car1.getFuelLevel());
    }

}