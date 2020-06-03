package de.onenightcar.domain.model.parkingArea;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.ElectricCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricParkingAreaTest {

    @Test
    void testing_assign_electric_car_to_station() {


        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);

        CarManagementSystem carManagementSystem = new CarManagementSystem();
        electricParkingArea.addElectricParkingAreaIntoElectricParkingAreas(Area1);

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea2 = new ElectricParkingArea(parkingAreaManager);

        ElectricCar electricCar1 = new ElectricCar(carManagementSystem, electricParkingArea2);


        Area1.assignElectricCarToStation(electricCar1);

        assertEquals(1,Area1.electricCarsInStation.size());
    }

    @Test
    void testing_remove_electric_car_from_station() {

        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);

        CarManagementSystem carManagementSystem = new CarManagementSystem();
        electricParkingArea.addElectricParkingAreaIntoElectricParkingAreas(Area1);

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        ElectricParkingArea electricParkingArea2 = new ElectricParkingArea(parkingAreaManager);

        ElectricCar electricCar1 = new ElectricCar(carManagementSystem, electricParkingArea2);
        ElectricCar electricCar2 = new ElectricCar(carManagementSystem, electricParkingArea2);


        Area1.assignElectricCarToStation(electricCar1);
        Area1.assignElectricCarToStation(electricCar2);

        Area1.removeElectricCarFromStation(electricCar1);

        assertEquals(1,Area1.electricCarsInStation.size());

    }

    @Test
    void testing_get_max_electric_cars_capacity() {

        ParkingAreaManager electricParkingArea = new ParkingAreaManager();
        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingArea);
        electricParkingArea.addElectricParkingAreaIntoElectricParkingAreas(Area1);


        Area1.setMaxElectricCarCapacity(100);

        assertEquals(100,Area1.getMaxElectricCarCapacity());

    }

}