package de.onenightcar.domain.model.car;
import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class CarManagementSystemTest {
    @Test
    void testAddElectricCarToArrayList(){
       CarManagementSystem electricCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        ElectricCar car3 = new ElectricCar(electricCarList, electricParkingArea);

        assertEquals("BMW", electricCarList.electricCarsList.get(0).brand);
    }

    @Test
    void testAddCombustionCarToArrayList(){
        CarManagementSystem listsAdding = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);
        CombustionCar car4 = new CombustionCar(listsAdding, parkingArea);
        CombustionCar car5 = new CombustionCar(listsAdding, parkingArea);

        assertEquals(2, listsAdding.combustionCarsList.size());
    }



    @Test
    void testGetSizeOfElectricCarsList(){
        CarManagementSystem electricCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        ElectricCar car1 = new ElectricCar(electricCarList, electricParkingArea);
        ElectricCar car2 = new ElectricCar(electricCarList, electricParkingArea);
        ElectricCar car3 = new ElectricCar(electricCarList, electricParkingArea);
        ElectricCar car4 = new ElectricCar(electricCarList, electricParkingArea);
        ElectricCar car5 = new ElectricCar(electricCarList, electricParkingArea);
        ElectricCar car6 = new ElectricCar(electricCarList, electricParkingArea);

        assertEquals(6, electricCarList.getSizeOfElectricCarsList());
    }

    @Test
    void testGetCarIDFromCombustion(){
        CarManagementSystem combustionCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);
        CombustionCar car1 = new CombustionCar(combustionCarList, parkingArea);
        CombustionCar car2 = new CombustionCar(combustionCarList, parkingArea);
        CombustionCar car3 = new CombustionCar(combustionCarList, parkingArea);
        CombustionCar car4 = new CombustionCar(combustionCarList, parkingArea);
        CombustionCar car5 = new CombustionCar(combustionCarList, parkingArea);
        CombustionCar car6 = new CombustionCar(combustionCarList, parkingArea);

        assertEquals(5, combustionCarList.getCarIDFromCombustion(car6));

    }
}