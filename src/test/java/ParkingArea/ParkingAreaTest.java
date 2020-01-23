package ParkingArea;

import ParkingArea.ParkingArea;
import ZuLöschen.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {


    List parkingAreas = new List();
    ParkingArea parkingArea1 = new ParkingArea(99098,"Erfurt",
                                               "Marktstraße","1", parkingAreas);

    @BeforeEach
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


}