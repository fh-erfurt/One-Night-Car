package de.onenightcar.model.parkingArea;

import de.onenightcar.model.car.ElectricCar;

import javax.persistence.Entity;
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

    @OneToMany(mappedBy = "electricParkingArea")
    public List<ElectricCar> electricCarsInStation;

    private int maxElectricCarCapacity;

    /* /////////////////////Constructors/////////////////////////// */

    /**
     * Creates an ElectricParkingArea Constructor with specified ElectricParkingArea Parameters.
     * @param parkingAreaAddress A ParkingAreaAddress representing the address of the parking Area
     * @param maxCapacity An integer representing the max. Capacity of Cars in OneNightCar.ParkingArea
     * @param maxElectricCarCapacity An integer representing the max. Capacity of Cars in ElectricParkingArea
     */
    public ElectricParkingArea(ParkingAreaAddress parkingAreaAddress, int maxCapacity,
                               int maxElectricCarCapacity, String name) {
        super(parkingAreaAddress,maxCapacity, name);

        this.parkingAreaAddress = parkingAreaAddress;
        this.maxCapacity = maxCapacity;
        this.maxElectricCarCapacity = maxElectricCarCapacity;
        this.electricCarsInStation = new ArrayList<ElectricCar>();
    }

    /** Creates an ElectricParkingArea with default values.
     * It is used to increment speed of UnitTests.
     */
    public ElectricParkingArea(){
        super(new ParkingAreaAddress(), 100, "TestDataElectric");

        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.maxElectricCarCapacity = 100;
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

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

    public List<ElectricCar> getElectricCarsInStation() {
        return electricCarsInStation;
    }

    public void setElectricCarsInStation(List<ElectricCar> electricCarsInStation) {
        this.electricCarsInStation = electricCarsInStation;
    }

    /* /////////////////////Methods/////////////////////////// */

    /**adds an electric car to the station
     * @param electricCar an Electric OneNightCar.Car
     */
    public void assignElectricCarToStation(ElectricCar electricCar) {

        try {
            electricCarsInStation.add(electricCar);
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
    }

    /** gets the Index(id) of an electric car in the station
     * @param electricCar an Electric OneNightCar.Car
     * @return Index(id)
     */
    public int getElectricCarID(ElectricCar electricCar) {
        return electricCarsInStation.indexOf(electricCar);
    }

    /* /////////////////////Overrides/////////////////////////// */

}
