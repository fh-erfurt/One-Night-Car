package de.onenightcar.domain.model.car;

import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombustionCarTest {
    @Test
    void testChangeCarState(){
        CarManagementSystem combustionCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);
        CombustionCar car1 = new CombustionCar(combustionCarList, parkingArea);
        car1.changeCarState(Car.State.DAMAGED);

        /* assertEquals(Expected         , Actual            ); */
        assertEquals(Car.State.DAMAGED, car1.getCarState());
    }

    @Test
    void testGetTankedAndSetFuelLevel()
    {
        CarManagementSystem combustionCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);
        CombustionCar car1 = new CombustionCar(combustionCarList, parkingArea);
        car1.setFuelLevel(29);
        car1.getTanked();
        assertEquals(100, car1.getFuelLevel());
    }

}