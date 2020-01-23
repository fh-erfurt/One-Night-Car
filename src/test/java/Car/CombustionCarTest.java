package Car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombustionCarTest {
    @Test
    void testChangeCarState(){
        CarManagementSystem combustionCarList = new CarManagementSystem();
        CombustionCar car1 = new CombustionCar(combustionCarList);
        car1.changeCarState(Car.State.DAMAGED);

        /* assertEquals(Expected         , Actual            ); */
        assertEquals(Car.State.DAMAGED, car1.getCarState());
    }

    @Test
    void testGetTankedAndSetFuelLevel()
    {
        CarManagementSystem combustionCarList = new CarManagementSystem();
        CombustionCar car1 = new CombustionCar(combustionCarList);
        car1.setFuelLevel(29);
        car1.getTanked();
        assertEquals(100, car1.getFuelLevel());
    }

}