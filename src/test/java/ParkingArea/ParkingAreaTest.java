package ParkingArea;


import Car.CarManagementSystem;
import Car.CombustionCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ParkingArea.ParkingAreaManager;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {

    @Test
    void test_assign_car_to_station() {
        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        CombustionCar combustionCar = new CombustionCar(carManagementSystem);
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        parkingArea.assignCarToStation(combustionCar);

        assertEquals(1, parkingArea.availableCars.size());
        assertEquals(1, parkingArea.carsInStation.size());
    }

    /*
    @Test
    void test_get_index_in_carID_list(){

    }

    @Test
    void test_remove_car_from_station() {

    }

    @Test
    void test_car_is_being_used(){

    }

    @Test
    void test_car_is_no_longer_being_used(){

    }


    @Test
    void test_print_all_cars_in_station(){

    }
*/

 /*   @BeforeEach
    public void init () {
        parkingArea1.assignCarToStation(0);
    }

    @Test
    public void should_Assign_Car_To_Station () {

        parkingArea1.assignCarToStation(0);

        assertEquals(parkingArea1.stationCarIDList.size(), 1);
    }

    @Test
    public void should_Remove_Car_From_Station () {

        parkingArea1.removeCarFromStation(0);

        assertEquals(parkingArea1.getIndexInStationCarIDList(0),0);

    }

    @Test
    public void Car_Should_Be_Used () {
        parkingArea1.carIsBeingUsed(0);

    assertEquals(parkingArea1.notAvailableCarIDList.size(),1);
    }

    @Test
    public void Car_should_no_Longer_Being_Used () {
        parkingArea1.carIsBeingUsed(0);
        parkingArea1.carIsNoLongerBeingUsed(0);

    assertEquals(parkingArea1.availableCarIDList.size(), 1);
}

*/
}