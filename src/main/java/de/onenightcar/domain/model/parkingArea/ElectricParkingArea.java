package de.onenightcar.domain.model.parkingArea;

import de.onenightcar.domain.model.car.ElectricCar;

import java.util.ArrayList;

/** Represents a Electric Parking Area
        * extend OneNightCar.ParkingArea
        * @author OneNightCar
        * @version 1.0
        * @since 1.0
        */

public class ElectricParkingArea extends ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    protected ArrayList<ElectricCar> electricCarsInStation;
    protected ArrayList<ElectricCar> availableElectricCars;
    protected ArrayList<ElectricCar> notAvailableElectricCars;
    private int maxElectricCarCapacity;

    /* /////////////////////Methods/////////////////////////// */

    /**
     * Creates an ElectricParkingArea Constructor with specified ElectricParkingArea Parameters.
     * @param parkID An integer to represent the parID
     * @param ParkingAreaAddress A ParkingAreaAddress representing the address of the parking Area
     * @param maxCapacity An integer representing the max. Capacity of Cars in OneNightCar.ParkingArea
     * @param maxElectricCarCapacity An integer representing the max. Capacity of Cars in ElectricParkingArea
     * @param parkingAreaManager A parking Area Manager with the Management of the Parking Areas
     */


    public ElectricParkingArea(int parkID, ParkingAreaAddress ParkingAreaAddress, int maxCapacity,
                               int maxElectricCarCapacity, ParkingAreaManager parkingAreaManager) {
        super(parkID, ParkingAreaAddress, maxCapacity, parkingAreaManager);

        this.maxElectricCarCapacity = maxElectricCarCapacity;
        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
        parkingAreaManager.ElectricParkingAreas.add(this);

    }

    /** Creates an ElectricParkingArea with default values.
     * It is used to increment speed of UnitTests.
     * @param parkingAreaManager A ParkingAreaManager with the management from the packet ElectricParkingArea
     */

    public ElectricParkingArea(ParkingAreaManager parkingAreaManager){
        super(2,new ParkingAreaAddress(), 100, parkingAreaManager);

        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
        this.maxElectricCarCapacity = 100;
    }

    /**gets the max. capacity of electric cars.
     * @return max Capacity
     */

    public int getMaxElectricCarCapacity() {
        return this.maxElectricCarCapacity;
    }

    /** sets the max. capacity of electric cars in the station
     * @param maxElectricCarCapacity max Capacity
     */

    public void setMaxElectricCarCapacity(int maxElectricCarCapacity) {
        this.maxElectricCarCapacity = maxElectricCarCapacity;
    }

    /**adds an electric car to the station
     * @param electricCar an Electric OneNightCar.Car
     */

    public void assignElectricCarToStation(ElectricCar electricCar) {
        electricCarsInStation.add(electricCar);
    }

    /**removes an electric car from the station
     * @param electricCar an Electric OneNightCar.Car
     */

    public void removeElectricCarFromStation(ElectricCar electricCar){
        electricCarsInStation.remove(electricCar);
    }

    /** gets the Index(id) of an electric car in the station
     * @param electricCar an Electric OneNightCar.Car
     * @return Index(id)
     */

    public int getElectricCarID(ElectricCar electricCar) {
        return electricCarsInStation.indexOf(electricCar);
    }
}
