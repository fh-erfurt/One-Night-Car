package de.onenightcar.domain.model.car;

import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricCarTest {

    @Test
    void testSetNewLocation(){
        CarManagementSystem electricCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        ElectricCar car1 = new ElectricCar(electricCarList, electricParkingArea);
        car1.setNewLocation(52.5164, 13.3811);
        assertEquals(52.5164, car1.getGPSLatitude());
        assertEquals(13.3811, car1.getGPSLongitude());

    }

    @Test
    void testGetChargedAndSetChargePercent()
    {
        CarManagementSystem electricCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        ElectricCar car1 = new ElectricCar(electricCarList, electricParkingArea);
        car1.setChargePercent(20);
        System.out.println("the Current charge of the car1 after using setChargePercent is: "+ car1.getChargePercent()+"%");
        car1.getChargedUp();
        System.out.println("the Current charge of the car1 after using getChargedUp is: "+ car1.getChargePercent()+"%");

        assertEquals(100, car1.getChargePercent());
    }

    @Test
    void testChangeCarState()
    {
        CarManagementSystem electricCarList = new CarManagementSystem();
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea = new ElectricParkingArea(parkingAreaManager);
        ElectricCar car1 = new ElectricCar(electricCarList, electricParkingArea);
        car1.changeCarState(Car.State.DAMAGED);
        System.out.println(car1.getCarState());
        assertEquals(Car.State.DAMAGED, car1.getCarState());
    }
}