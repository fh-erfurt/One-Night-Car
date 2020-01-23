package ParkingArea;

import Car.Car;

import java.util.*;

public class ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    private int parkID;
    private String ParkingAreaAddress;
    private int maxCapacity;
    // ArrayList in case the number of cars in station changes
    protected ArrayList<Car> carsInStation;
    protected ArrayList<Car> availableCars;
    protected ArrayList<Car> notAvailableCars;

    /* /////////////////////Methods/////////////////////////// */

    public ParkingArea(int parkID, String ParkingAreaAddress, int maxCapacity,
                       ArrayList carsInStation, ArrayList availableCars,
                       ArrayList notAvailableCars, ParkingAreaManager parkingAreaManager) {

        this.maxCapacity = maxCapacity;
        this.carsInStation = new ArrayList<Car>();
        this.availableCars = new ArrayList<Car>();
        this.notAvailableCars = new ArrayList<Car>();
        this.parkID = parkingAreaManager.getAndIncrementCounter();
        parkingAreaManager.ParkingAreas.add(this);                               //Adds this ParkingArea to the ParkingAreas List
    }

    public ParkingArea() {

    }


    public void assignCarToStation(Car carID) {
        carsInStation.add(carID);
        availableCars.add(carID);
    }

    protected int getIndexInStationCarIDList(Car carID) {                      //protected for Testing purposes
        int carIDIndex;
        for (carIDIndex = 0; carIDIndex < carsInStation.size(); carIDIndex++) {
            if (carID == carsInStation.get(carIDIndex)) {
                break;
            }
        }
        return carIDIndex;
    }

    public void removeCarFromStation(Car carID) {
        int currentCarIndex = getIndexInStationCarIDList(carID);
        carsInStation.remove(currentCarIndex);
        availableCars.remove(currentCarIndex);
    }


    public void carIsBeingUsed(Car carID) {
        int currentCarIndex = getIndexInStationCarIDList(carID);
        availableCars.remove(currentCarIndex);
        notAvailableCars.add(carID);
    }

    public void carIsNoLongerBeingUsed(Car carID) {
        int currentCarIndex = getIndexInStationCarIDList(carID);
        availableCars.add(carID);
        notAvailableCars.remove(currentCarIndex);
    }

    public int numberOfCarsAssignedToStation() {
        return carsInStation.size();
    }


}


