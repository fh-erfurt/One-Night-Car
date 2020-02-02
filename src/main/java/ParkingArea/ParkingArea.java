package ParkingArea;

import Car.CombustionCar;


import java.util.*;

/** Represents a ParkingArea
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

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

    /**
     * creates an ParkingArea Constructor with Parameters to use it in the Child class.
     * @param parkID An integer to represent the parkID
     * @param ParkingAreaAddress A ParkingAreaAddress representing the address of the Parking Area
     * @param maxCapacity An integer to represent the maximum capacity of the Parking Area
     * @param parkingAreaManager A Parking Area Manager with the Management of the Parking Areas
     */
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

    /** Creates a ParkingArea with default Values.
     * It is used to increment speed of UnitTests.
     * @param parkingAreaManager A ParkingAreaManager with the management from the Packet ParkingArea
     */

    public ParkingArea(ParkingAreaManager parkingAreaManager) {
        this.parkID = parkingAreaManager.getAndIncrementCounter();
        this.maxCapacity = 100;
        this.parkingAreaAddress = new ParkingAreaAddress();
        this.carsInStation = new ArrayList<CombustionCar>();
        this.availableCars = new ArrayList<CombustionCar>();
        this.notAvailableCars = new ArrayList<CombustionCar>();
        parkingAreaManager.ParkingAreas.add(this);
    }

    /**
     * adds a Combustion Car to the carsInStation and availableCars list
     * @param combustionCar a Combustion Car
     */

    public void assignCarToStation(CombustionCar combustionCar) {
        //carManagementSystem.getCarIDFromCombustion(combustionCar);
        this.carsInStation.add(combustionCar);
        this.availableCars.add(combustionCar);
    }

    /**
     * gets the Index from a Combustion Car from the carsInStation list
     * @param combustionCar a Combustion Car
     * @return returns the Combustion Car Index(id)
     */

    protected int getIndexInStationCarIDList(CombustionCar combustionCar) {                      //protected for Testing purposes
        int carIDIndex;
        for (carIDIndex = 0; carIDIndex < carsInStation.size(); carIDIndex++) {
            if (combustionCar == carsInStation.get(carIDIndex)) {
                break;
            }
        }
        return carIDIndex;
    }

    /**
     * removes a Combustion Car from the carsInStation and available Cars list
     * @param combustionCar a Combustion Car
     */

    public void removeCarFromStation(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        carsInStation.remove(combustionCar);
        availableCars.remove(combustionCar);
    }

    /**
     * sets a Combustion Car in the state notAvailableCars and removes it from availableCars
     * @param combustionCar a Combustion Car
     */

    public void carIsBeingUsed(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.remove(combustionCar);
        notAvailableCars.add(combustionCar);
    }

    /**
     * sets a Combustion Car in the state availableCars and removes t from notAvailableCars
     * @param combustionCar a Combustion Car
     */

    public void carIsNoLongerBeingUsed(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.add(combustionCar);
        notAvailableCars.remove(combustionCar);
    }

    /**
     * Shows the number of cars in the Station
     * @return the size of carsInStation
     */

    public int numberOfCarsAssignedToStation() {
        return carsInStation.size();
    }

    /** gets the Index(id) of the combustionCar list
     * @return  the Index of combustionCarList
     * @param combustionCar a Combustion Car
     * */

    public int getCombustionCarID(CombustionCar combustionCar) {
        return carsInStation.indexOf(combustionCar);
    }

    /**
     * gets the address of the Parking Area
     * @return parkingAreaAddress
     */

    public ParkingAreaAddress getParkingAreaAddress() {return this.parkingAreaAddress;}

    /**
     * gets the max. Capacity of a Parking Area
     * @return maxCapacity
     */

    public int getMaxCapacity() {return this.maxCapacity;}

    /**
     * Shows all Cars in the Station
     * @return carsInStation
     */

    public ArrayList<CombustionCar> getCarsInStation() {
        return carsInStation;
    }




}


