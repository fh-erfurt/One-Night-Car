package ParkingArea;

import java.util.*;

public class ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    private int parkID;
    private int parkZIP;
    private String parkCity;
    private String parkStreet;
    private String parkHouseNumber;
    // ArrayList in case the number of cars in station changes
    protected ArrayList<Integer> stationCarIDList;         //Testing purposes
    protected ArrayList<Integer> availableCarIDList;
    protected ArrayList<Integer> notAvailableCarIDList;

    /* /////////////////////Methods/////////////////////////// */

//   public ParkingArea(int parkZIP, String parkCity, String parkStreet, String parkHouseNumber, List list) {
//        parkID = list.getSizeOfParkingAreas();            //Creates a running counter of Parking Areas in list
//        list.parkingAreas.add(this);                        //Adds the new Parking Area to the global list
//        this.parkZIP = parkZIP;
//        this.parkCity = parkCity;
//        this.parkStreet = parkStreet;
//        this.parkHouseNumber = parkHouseNumber;
//        this.stationCarIDList = new ArrayList<Integer>();
//        this.availableCarIDList = new ArrayList<Integer>();
//        this.notAvailableCarIDList = new ArrayList<Integer>();
//    }

    public void assignCarToStation (int carID){
        stationCarIDList.add(carID);
        availableCarIDList.add(carID);
    }

    protected int getIndexInStationCarIDList (int carID){                      //protected for Testing purposes
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
