package ParkingArea;

import Car.Car;
import Car.CombustionCar;
import Car.ElectricCar;
import Car.CarManagementSystem;

import java.util.*;

public class ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    private int parkID;
    private int maxCapacity;
    ParkingAreaAddress parkingAreaAddress;
    // ArrayList in case the number of cars in station changes
    public ArrayList<CombustionCar> carsInStation;
    public ArrayList<CombustionCar> availableCars;
    public ArrayList<CombustionCar> notAvailableCars;

    /* /////////////////////Methods/////////////////////////// */

    public ParkingArea(int parkID, ParkingAreaAddress ParkingAreaAddress, int maxCapacity
            , ParkingAreaManager parkingAreaManager) {

        this.maxCapacity = maxCapacity;
        this.parkingAreaAddress = new ParkingAreaAddress();  // könnte mit Parameter sein oder default
        this.carsInStation = new ArrayList<CombustionCar>();
        this.availableCars = new ArrayList<CombustionCar>();
        this.notAvailableCars = new ArrayList<CombustionCar>();
        this.parkID = parkingAreaManager.getAndIncrementCounter();
        parkingAreaManager.ParkingAreas.add(this);                               //Adds this ParkingArea to the ParkingAreas List
    }

    public ParkingArea(ParkingAreaManager parkingAreaManager) {
        this.parkID = parkingAreaManager.getAndIncrementCounter();
        this.maxCapacity = 100;
        this.parkingAreaAddress = new ParkingAreaAddress();
        this.carsInStation = new ArrayList<CombustionCar>();
        this.availableCars = new ArrayList<CombustionCar>();
        this.notAvailableCars = new ArrayList<CombustionCar>();
        parkingAreaManager.ParkingAreas.add(this);
    }

    public void assignCarToStation(CombustionCar combustionCar) {
        //carManagementSystem.getCarIDFromCombustion(combustionCar);
        this.carsInStation.add(combustionCar);
        this.availableCars.add(combustionCar);
    }

    protected int getIndexInStationCarIDList(CombustionCar combustionCar) {                      //protected for Testing purposes
        int carIDIndex;
        for (carIDIndex = 0; carIDIndex < carsInStation.size(); carIDIndex++) {
            if (combustionCar == carsInStation.get(carIDIndex)) {
                break;
            }
        }
        return carIDIndex;
    }

    public void removeCarFromStation(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        carsInStation.remove(combustionCar);
        availableCars.remove(combustionCar);
    }


    public void carIsBeingUsed(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.remove(combustionCar);
        notAvailableCars.add(combustionCar);
    }

    public void carIsNoLongerBeingUsed(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.add(combustionCar);
        notAvailableCars.remove(combustionCar);
    }

    public int numberOfCarsAssignedToStation() {
        return carsInStation.size();
    }

    /** gets the Index(id) of the combustionCar list
     * @return  the Index of combustionCarList
     * */

    public int getCombustionCarID(CombustionCar combustionCar) {
        return carsInStation.indexOf(combustionCar);
    }

    public ParkingAreaAddress getParkingAreaAddress() {return this.parkingAreaAddress;}

    public int getMaxCapacity() {return this.maxCapacity;}

    public ArrayList<CombustionCar> getCarsInStation() {
        return carsInStation;
    }




}


