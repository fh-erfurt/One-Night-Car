package de.onenightcar.model.parkingArea;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.util.AbstractDatabaseEntity;


import javax.persistence.*;
import java.util.*;

/** Represents a OneNightCar.ParkingArea
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class ParkingArea extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    // ArrayList in case the number of cars in station changes
    @OneToMany
    public List<CombustionCar> carsInStation;

    @OneToMany
    public List<CombustionCar> availableCars;

    @OneToMany
    public List<CombustionCar> notAvailableCars;

    @OneToOne
    protected ParkingAreaAddress parkingAreaAddress;

    protected int maxCapacity;

    /* /////////////////////Constructors/////////////////////////// */

    /**
     * creates an OneNightCar.ParkingArea Constructor with Parameters to use it in the Child class.
     * @param parkingAreaAddress A ParkingAreaAddress representing the address of the Parking Area
     * @param maxCapacity An integer to represent the maximum capacity of the Parking Area
     */
    public ParkingArea(ParkingAreaAddress parkingAreaAddress, int maxCapacity) {

        this.maxCapacity = maxCapacity;
        this.parkingAreaAddress = parkingAreaAddress;
        this.carsInStation = new ArrayList<CombustionCar>();
        this.availableCars = new ArrayList<CombustionCar>();
        this.notAvailableCars = new ArrayList<CombustionCar>();
    }

    /** Creates a OneNightCar.ParkingArea with default Values.
     * It is used to increment speed of UnitTests.
     */
    public ParkingArea() {
        this.maxCapacity = 100;
        this.parkingAreaAddress = new ParkingAreaAddress();
        this.carsInStation = new ArrayList<CombustionCar>();
        this.availableCars = new ArrayList<CombustionCar>();
        this.notAvailableCars = new ArrayList<CombustionCar>();
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    /**
     * gets the max. Capacity of a Parking Area
     * @return maxCapacity
     */
    public int getMaxCapacity() {return this.maxCapacity;}

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Shows all Cars in the Station
     * @return carsInStation
     */
    public List<CombustionCar> getCarsInStation() {
        return carsInStation;
    }

    public void setCarsInStation(List<CombustionCar> carsInStation) {
        this.carsInStation = carsInStation;
    }

    public List<CombustionCar> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(List<CombustionCar> availableCars) {
        this.availableCars = availableCars;
    }

    public List<CombustionCar> getNotAvailableCars() {
        return notAvailableCars;
    }

    public void setNotAvailableCars(List<CombustionCar> notAvailableCars) {
        this.notAvailableCars = notAvailableCars;
    }

    /**
     * gets the address of the Parking Area
     * @return parkingAreaAddress
     */
    public ParkingAreaAddress getParkingAreaAddress() {return this.parkingAreaAddress;}


    public void setParkingAreaAddress(ParkingAreaAddress parkingAreaAddress) {
        this.parkingAreaAddress = parkingAreaAddress;
    }

    /* /////////////////////Methods/////////////////////////// */

    /**
     * adds a Combustion OneNightCar.Car to the carsInStation and availableCars list
     * @param combustionCar a Combustion OneNightCar.Car
     */
    public void assignCarToStation(CombustionCar combustionCar) {
        //carManagementSystem.getCarIDFromCombustion(combustionCar);
        this.carsInStation.add(combustionCar);
        this.availableCars.add(combustionCar);
    }

    /**
     * gets the Index from a Combustion OneNightCar.Car from the carsInStation list
     * @param combustionCar a Combustion OneNightCar.Car
     * @return returns the Combustion OneNightCar.Car Index(id)
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
     * removes a Combustion OneNightCar.Car from the carsInStation and available Cars list
     * @param combustionCar a Combustion OneNightCar.Car
     */
    public void removeCarFromStation(CombustionCar combustionCar) {

        try {
            //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
            carsInStation.remove(combustionCar);
            availableCars.remove(combustionCar);
        }
        catch(Exception e){
            System.out.print("Removing Car from Station has not worked!");
        }
    }

    /**
     * sets a Combustion OneNightCar.Car in the state notAvailableCars and removes it from availableCars
     * @param combustionCar a Combustion OneNightCar.Car
     */
    public void carIsBeingUsed(CombustionCar combustionCar) {
        //int currentCarIndex = getIndexInStationCarIDList(combustionCar);
        availableCars.remove(combustionCar);
        notAvailableCars.add(combustionCar);
    }

    /**
     * sets a Combustion OneNightCar.Car in the state availableCars and removes t from notAvailableCars
     * @param combustionCar a Combustion OneNightCar.Car
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
     * @param combustionCar a Combustion OneNightCar.Car
     * */
    public int getCombustionCarID(CombustionCar combustionCar) {
        return carsInStation.indexOf(combustionCar);
    }

    /* /////////////////////Overrides/////////////////////////// */

}

