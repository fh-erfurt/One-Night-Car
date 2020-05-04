package OneNightCar.Car;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class CarManagementSystemTest {
    @Test
    void testAddElectricCarToArrayList(){
       CarManagementSystem electricCarList = new CarManagementSystem();
        ElectricCar car3 = new ElectricCar(electricCarList);

        assertEquals("BMW", electricCarList.electricCarsList.get(0).brand);
    }

    @Test
    void testAddCombustionCarToArrayList(){
        CarManagementSystem listsAdding = new CarManagementSystem();
        CombustionCar car4 = new CombustionCar(listsAdding);
        CombustionCar car5 = new CombustionCar(listsAdding);

        assertEquals(2, listsAdding.combustionCarsList.size());
    }

    @Test
    void testDeleteCarFromCombustion(){
        // First Adding
        CarManagementSystem listsAdding = new CarManagementSystem();
        CombustionCar car4 = new CombustionCar(listsAdding);
        // Second Removing
        listsAdding.deleteCarFromCombustion(car4);
        assertEquals(0, listsAdding.combustionCarsList.size());
    }

    @Test
    void testGetSizeOfElectricCarsList(){
        CarManagementSystem electricCarList = new CarManagementSystem();
        ElectricCar car1 = new ElectricCar(electricCarList);
        ElectricCar car2 = new ElectricCar(electricCarList);
        ElectricCar car3 = new ElectricCar(electricCarList);
        ElectricCar car4 = new ElectricCar(electricCarList);
        ElectricCar car5 = new ElectricCar(electricCarList);
        ElectricCar car6 = new ElectricCar(electricCarList);

        assertEquals(6, electricCarList.getSizeOfElectricCarsList());
    }

    @Test
    void testGetCarIDFromCombustion(){
        CarManagementSystem combustionCarList = new CarManagementSystem();
        CombustionCar car1 = new CombustionCar(combustionCarList);
        CombustionCar car2 = new CombustionCar(combustionCarList);
        CombustionCar car3 = new CombustionCar(combustionCarList);
        CombustionCar car4 = new CombustionCar(combustionCarList);
        CombustionCar car5 = new CombustionCar(combustionCarList);
        CombustionCar car6 = new CombustionCar(combustionCarList);

        assertEquals(5, combustionCarList.getCarIDFromCombustion(car6));

    }
}