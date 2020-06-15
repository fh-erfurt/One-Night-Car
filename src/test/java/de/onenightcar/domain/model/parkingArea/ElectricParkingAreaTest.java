package de.onenightcar.domain.model.parkingArea;

import de.onenightcar.domain.model.car.ElectricCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricParkingAreaTest {

    @Test
    void testing_assign_electric_car_to_station() {


        ElectricParkingArea Area1 = new ElectricParkingArea();



        ElectricParkingArea electricParkingArea2 = new ElectricParkingArea();

        ElectricCar electricCar1 = new ElectricCar(electricParkingArea2);


        Area1.assignElectricCarToStation(electricCar1);

        assertEquals(1,Area1.electricCarsInStation.size());
    }

    @Test
    void testing_remove_electric_car_from_station() {

        ElectricParkingArea Area1 = new ElectricParkingArea();



        ElectricParkingArea electricParkingArea2 = new ElectricParkingArea();

        ElectricCar electricCar1 = new ElectricCar(electricParkingArea2);
        ElectricCar electricCar2 = new ElectricCar(electricParkingArea2);


        Area1.assignElectricCarToStation(electricCar1);
        Area1.assignElectricCarToStation(electricCar2);

        Area1.removeElectricCarFromStation(electricCar1);

        assertEquals(1,Area1.electricCarsInStation.size());

    }

    @Test
    void testing_get_max_electric_cars_capacity() {

        ElectricParkingArea Area1 = new ElectricParkingArea();


        Area1.setMaxElectricCarCapacity(100);

        assertEquals(100,Area1.getMaxElectricCarCapacity());

    }

}