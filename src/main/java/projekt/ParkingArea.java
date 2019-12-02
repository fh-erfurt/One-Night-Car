package projekt;
import java.util.*;

public class ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    private int parkID;
    private int parkZIP;
    private String parkCity;
    private String parkStreet;
    private String parkHouseNumber;
    // ArrayList in case the number of cars in station changes
    private ArrayList<Integer> stationCarIDList = new ArrayList<Integer>();
    private ArrayList<Integer> availableCarIDList = new ArrayList<Integer>();
    private ArrayList<Integer> notAvailableCarIDList = new ArrayList<Integer>();

    /* /////////////////////Methods/////////////////////////// */

    public ParkingArea(int parkZIP, String parkCity, String parkStreet, String parkHouseNumber) {
        // A ParkingArea manager should be done and here somehow the ID should be given
        this.parkZIP = parkZIP;
        this.parkCity = parkCity;
        this.parkStreet = parkStreet;
        this.parkHouseNumber = parkHouseNumber;
    }

    public void assignCarToStation (int carID){
        stationCarIDList.add(carID);
        availableCarIDList.add(carID);
    }

    private int getIndexInStationCarIDList (int carID){
        int carIDIndex;
        for (carIDIndex = 0; carIDIndex < stationCarIDList.size(); carIDIndex++){
            if (carID == stationCarIDList.get(carIDIndex)){
                break;
            }
        }
        return carIDIndex;
    }

    public void removeCarFromStation (int carID){
        int currentCarIndex = getIndexInStationCarIDList(carID);
        stationCarIDList.remove(currentCarIndex);
        availableCarIDList.remove(currentCarIndex);
    }


    public void carIsBeingUsed (int carID){
        int currentCarIndex = getIndexInStationCarIDList(carID);
        availableCarIDList.remove(currentCarIndex);
        notAvailableCarIDList.add(carID);
    }

    public void carIsNoLongerBeingUsed (int carID){
        int currentCarIndex = getIndexInStationCarIDList(carID);
        availableCarIDList.add(carID);
        notAvailableCarIDList.remove(currentCarIndex);
    }

    public int numberOfCarsAssignedToStation (){
        return stationCarIDList.size();
    }


}
