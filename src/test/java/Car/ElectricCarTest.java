package Car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricCarTest {

    @Test
    void testSetNewLocation(){
        ElectricCar car2 = new ElectricCar();
        car2.setNewLocation(52.5164, 13.3811);
        assertEquals(new Location(52.5164,13.3811), car2.getLocation());
    }
}