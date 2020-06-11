package de.onenightcar.domain.model.parkingArea;

import de.onenightcar.domain.model.car.ElectricCar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/** Represents a Electric Parking Area
* extend OneNightCar.ParkingArea
* @author OneNightCar
* @version 2.0
* @since 1.0
*/

@Entity
public class ElectricParkingArea extends ParkingArea {

    /* /////////////////////Attributes///////////////////////// */

    @OneToMany
    protected List<ElectricCar> electricCarsInStation;

    @OneToMany
    protected List<ElectricCar> availableElectricCars;

    @OneToMany
    protected List<ElectricCar> notAvailableElectricCars;

    private int maxElectricCarCapacity;

    /* /////////////////////Methods/////////////////////////// */

    public ElectricParkingArea() {}

    /**
     * Creates an ElectricParkingArea Constructor with specified ElectricParkingArea Parameters.
     * @param parkingAreaAddress A ParkingAreaAddress representing the address of the parking Area
     * @param maxCapacity An integer representing the max. Capacity of Cars in OneNightCar.ParkingArea
     * @param maxElectricCarCapacity An integer representing the max. Capacity of Cars in ElectricParkingArea
     * @param parkingAreaManager A parking Area Manager with the Management of the Parking Areas
     */


    public ElectricParkingArea(ParkingAreaAddress parkingAreaAddress, int maxCapacity,
                               int maxElectricCarCapacity, ParkingAreaManager parkingAreaManager) {
        this.parkingAreaAddress = parkingAreaAddress;
        this.maxCapacity = maxCapacity;
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
        super(new ParkingAreaAddress(), 100, parkingAreaManager);

        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
        this.maxElectricCarCapacity = 100;
        parkingAreaManager.ElectricParkingAreas.add(this);
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

        try {
            electricCarsInStation.add(electricCar);
            availableElectricCars.add(electricCar);
        }
        catch(Exception e){
            System.out.print("Assigning Electric Car to station has failed!");
        }
    }

    /**
     * Shows the number of cars in the Station
     * @return the size of carsInStation
     */

    public int numberOfElectricCarsAssignedToStation() {
        return electricCarsInStation.size();
    }

    /**removes an electric car from the station
     * @param electricCar an Electric OneNightCar.Car
     */

    public void removeElectricCarFromStation(ElectricCar electricCar){
        electricCarsInStation.remove(electricCar);
        availableElectricCars.remove(electricCar);
    }

    /** gets the Index(id) of an electric car in the station
     * @param electricCar an Electric OneNightCar.Car
     * @return Index(id)
     */

    public int getElectricCarID(ElectricCar electricCar) {
        return electricCarsInStation.indexOf(electricCar);
    }
}
