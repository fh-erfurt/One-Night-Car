package ParkingArea;

import Car.Car;
import Car.CombustionCar;
import Car.ElectricCar;
import Car.CarManagementSystem;

import java.util.*;

public class ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    private int parkID;
    private String ParkingAreaAddress;
    private int maxCapacity;
    ParkingAreaAddress parkingAreaAddress;
    // ArrayList in case the number of cars in station changes
    public ArrayList<Car> carsInStation;
    public ArrayList<Car> availableCars;
    public ArrayList<Car> notAvailableCars;

    /* /////////////////////Methods/////////////////////////// */

    public ParkingArea(int parkID, ParkingAreaAddress ParkingAreaAddress, int maxCapacity
            , ParkingAreaManager parkingAreaManager) {

        this.maxCapacity = maxCapacity;
        this.parkingAreaAddress = new ParkingAreaAddress();  // könnte mit Parameter sein oder default
        this.carsInStation = new ArrayList<Car>();
        this.availableCars = new ArrayList<Car>();
        this.notAvailableCars = new ArrayList<Car>();
        this.parkID = parkingAreaManager.getAndIncrementCounter();
        parkingAreaManager.ParkingAreas.add(this);                               //Adds this ParkingArea to the ParkingAreas List
    }

    public ParkingArea(ParkingAreaManager parkingAreaManager) {
        this.parkID = parkingAreaManager.getAndIncrementCounter();
        this.parkingAreaAddress = new ParkingAreaAddress();
        this.maxCapacity = 100;
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
        int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        carsInStation.remove(currentCarIndex);
        availableCars.remove(currentCarIndex);
    }


    public void carIsBeingUsed(CombustionCar combustionCar) {
        int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.remove(currentCarIndex);
        notAvailableCars.add(combustionCar);
    }

    public void carIsNoLongerBeingUsed(CombustionCar combustionCar) {
        int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.add(combustionCar);
        notAvailableCars.remove(currentCarIndex);
    }

    public int numberOfCarsAssignedToStation() {
        return carsInStation.size();
    }

   // public int getCarID(Car carID) {return this.carID;}

    public ParkingAreaAddress getParkingAreaAddress() {return this.parkingAreaAddress;}

    public int getMaxCapacity() {return this.maxCapacity;}

    public ArrayList<Car> getCarsInStation() {
        return carsInStation;
    }




}


