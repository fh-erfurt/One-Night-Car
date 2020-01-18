package Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;


class CarManagementSystemTest {
    @Test
    void testAddElectricCarToArrayList(){
        CarManagementSystem listsAdding = new CarManagementSystem();
        ElectricCar car3 = new ElectricCar();

        listsAdding.addCarIntoElectrics(car3);
        assertEquals(1, listsAdding.electricCarsList.size());
    }

    @Test
    void testAddCombustionCarToArrayList(){
        CarManagementSystem listsAdding = new CarManagementSystem();
        CombustionCar car4 = new CombustionCar();

        listsAdding.addCarIntoCombustion(car4);
        assertEquals(1, listsAdding.combustionCarsList.size());
    }


}