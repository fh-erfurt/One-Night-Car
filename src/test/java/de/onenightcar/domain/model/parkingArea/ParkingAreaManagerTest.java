package de.onenightcar.domain.model.parkingArea;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



class ParkingAreaManagerTest {


    @Test
    void testing_of_the_counter_return_and_increment_function(){
        ParkingAreaManager list = new ParkingAreaManager();

        ParkingArea Anger1 = new ParkingArea(list);

        assertEquals(100, Anger1.getMaxCapacity());
        assertEquals(2, list.getAndIncrementCounter());
    }

    @Test
    void testing_add_electric_parking_area_into_electric_parking_areas(){
        ParkingAreaManager electricParkingAreas = new ParkingAreaManager();

        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingAreas);

        electricParkingAreas.addElectricParkingAreaIntoElectricParkingAreas(Area1);

        assertEquals(1,electricParkingAreas.getSizeOfElectricParkingAreas());

    }

    @Test
    void testing_removing_electric_parking_area_from_electric_parking_areas(){
        ParkingAreaManager electricParkingAreas = new ParkingAreaManager();

        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingAreas);

        electricParkingAreas.removeParkingAreaIntoParkingAreas(Area1);

        assertEquals(1,electricParkingAreas.getSizeOfParkingAreas());
    }

    @Test
    void testing_get_size_from_electric_parking_area() {

        ParkingAreaManager electricParkingAreas = new ParkingAreaManager();

        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingAreas);
        ElectricParkingArea Area2 = new ElectricParkingArea(electricParkingAreas);

        electricParkingAreas.addElectricParkingAreaIntoElectricParkingAreas(Area1);
        electricParkingAreas.addElectricParkingAreaIntoElectricParkingAreas(Area2);

        assertEquals(2, electricParkingAreas.getSizeOfParkingAreas());
    }

    @Test
    void testing_get_parkID_from_electric_parking_areas() {

        ParkingAreaManager electricParkingAreas = new ParkingAreaManager();

        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingAreas);
        ElectricParkingArea Area2 = new ElectricParkingArea(electricParkingAreas);
        ElectricParkingArea Area3 = new ElectricParkingArea(electricParkingAreas);

        electricParkingAreas.addElectricParkingAreaIntoElectricParkingAreas(Area1);
        electricParkingAreas.addElectricParkingAreaIntoElectricParkingAreas(Area2);
        electricParkingAreas.addElectricParkingAreaIntoElectricParkingAreas(Area3);

        assertEquals(2, electricParkingAreas.getParkIDFromElectricParkingAreas(Area3));
    }

    @Test
    void testing_return_parking_area_with_index() {

        ParkingAreaManager parkingAreas = new ParkingAreaManager();

        ParkingArea Area1 = new ParkingArea(parkingAreas);
        ParkingArea Area2 = new ParkingArea(parkingAreas);

        parkingAreas.addParkingAreaIntoParkingAreas(Area1);
        parkingAreas.addParkingAreaIntoParkingAreas(Area2);

        assertEquals(1, parkingAreas.returnParkingAreaWithIndex(Area2));

    }

    @Test
    void testing_return_electric_parking_area_with_index() {

        ParkingAreaManager electricParkingAreas = new ParkingAreaManager();

        ElectricParkingArea Area1 = new ElectricParkingArea(electricParkingAreas);
        ParkingArea Area2 = new ParkingArea(electricParkingAreas);

        electricParkingAreas.addParkingAreaIntoParkingAreas(Area1);
        electricParkingAreas.addParkingAreaIntoParkingAreas(Area2);

        assertEquals(0, electricParkingAreas.returnElectricParkingAreaWithIndex(Area1));

    }
}