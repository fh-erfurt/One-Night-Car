package Car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombustionCarTest {
    @Test
    void testChangeCarState(){
        CombustionCar car1 = new CombustionCar();
        car1.changeCarState(Car.State.DAMAGED);

        /* assertEquals(Expected         , Actual            ); */
        assertEquals(Car.State.DAMAGED, car1.getCarState());
    }

}