package ParkingArea;


import Car.CarManagementSystem;
import Car.CombustionCar;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void test_remove_car_from_station(){

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        CombustionCar combustionCar1 = new CombustionCar(carManagementSystem);
        CombustionCar combustionCar2 = new CombustionCar(carManagementSystem);
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        parkingArea.assignCarToStation(combustionCar1);
        parkingArea.assignCarToStation(combustionCar2);

        parkingArea.removeCarFromStation(combustionCar2);

        assertEquals(1,parkingArea.availableCars.size());

    }


    @Test
    void test_get_index_in_station_carID_list(){

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        CombustionCar combustionCar1 = new CombustionCar(carManagementSystem);
        CombustionCar combustionCar2 = new CombustionCar(carManagementSystem);
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        parkingArea.assignCarToStation(combustionCar1);
        parkingArea.assignCarToStation(combustionCar2);

        assertEquals(1,parkingArea.getIndexInStationCarIDList(combustionCar2));

    }


    @Test
    void test_car_is_being_used(){

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        CombustionCar combustionCar1 = new CombustionCar(carManagementSystem);
        CombustionCar combustionCar2 = new CombustionCar(carManagementSystem);
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        parkingArea.assignCarToStation(combustionCar1);
        parkingArea.assignCarToStation(combustionCar2);

        parkingArea.carIsBeingUsed(combustionCar1);

        assertEquals(1,parkingArea.notAvailableCars.size());
    }

    @Test
    void test_car_is_no_longer_being_used(){

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        CombustionCar combustionCar1 = new CombustionCar(carManagementSystem);
        CombustionCar combustionCar2 = new CombustionCar(carManagementSystem);
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        parkingArea.assignCarToStation(combustionCar1);
        parkingArea.assignCarToStation(combustionCar2);

        parkingArea.carIsBeingUsed(combustionCar1);
        parkingArea.carIsNoLongerBeingUsed(combustionCar1);

        assertEquals(0,parkingArea.notAvailableCars.size());
        assertEquals(2, parkingArea.availableCars.size());

    }


    @Test
    void test_print_all_cars_in_station(){

        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
        CarManagementSystem carManagementSystem = new CarManagementSystem();

        CombustionCar combustionCar1 = new CombustionCar(carManagementSystem);
        CombustionCar combustionCar2 = new CombustionCar(carManagementSystem);
        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);

        parkingArea.assignCarToStation(combustionCar1);
        parkingArea.assignCarToStation(combustionCar2);

        System.out.println(
                parkingArea.getCarsInStation()
        );

    }


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