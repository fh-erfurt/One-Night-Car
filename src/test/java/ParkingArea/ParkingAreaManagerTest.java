package ParkingArea;

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
    void testing_add_parking_area_into_parking_areas(){
        ParkingAreaManager adding = new ParkingAreaManager();

        ParkingArea Area1 = new ParkingArea(adding);


        assertEquals(1,adding.getSizeOfParkingAreas());

    }

    @Test
    void testing_removing_parking_area_from_parking_areas(){
        ParkingAreaManager adding = new ParkingAreaManager();

        ParkingArea Area1 = new ParkingArea(adding);
        ParkingArea Area2 = new ParkingArea(adding);

        adding.removeParkingAreaIntoParkingAreas(Area1);

        assertEquals(1,adding.getSizeOfParkingAreas());
    }

    @Test
    void testing_get_size_from_parking_area() {

        ParkingAreaManager adding = new ParkingAreaManager();

        ParkingArea Area1 = new ParkingArea(adding);
        ParkingArea Area2 = new ParkingArea(adding);

        assertEquals(2, adding.getSizeOfParkingAreas());
    }

    @Test
    void testing_get_parkID_from_electric_parking_areas() {

        ParkingAreaManager adding = new ParkingAreaManager();

        ParkingArea Area1 = new ParkingArea(adding);
        ParkingArea Area2 = new ParkingArea(adding);
        ParkingArea Area3 = new ParkingArea(adding);

        assertEquals(2, adding.getParkIDFromParkingAreas(Area3));
    }

}