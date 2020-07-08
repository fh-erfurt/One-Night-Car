package de.onenightcar.model.parkingArea;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    static Logger log = LoggerFactory.getLogger(ElectricParkingArea.class);

    @OneToMany
    public List<ElectricCar> electricCarsInStation;

    @OneToMany
    public List<ElectricCar> availableElectricCars;

    @OneToMany
    public List<ElectricCar> notAvailableElectricCars;

    private int maxElectricCarCapacity;

    /* /////////////////////Constructors/////////////////////////// */

    /**
     * Creates an ElectricParkingArea Constructor with specified ElectricParkingArea Parameters.
     * @param parkingAreaAddress A ParkingAreaAddress representing the address of the parking Area
     * @param maxCapacity An integer representing the max. Capacity of Cars in OneNightCar.ParkingArea
     * @param maxElectricCarCapacity An integer representing the max. Capacity of Cars in ElectricParkingArea
     */
    public ElectricParkingArea(ParkingAreaAddress parkingAreaAddress, int maxCapacity,
                               int maxElectricCarCapacity) {
        super(parkingAreaAddress,maxCapacity);

        this.parkingAreaAddress = parkingAreaAddress;
        this.maxCapacity = maxCapacity;
        this.maxElectricCarCapacity = maxElectricCarCapacity;
        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
    }

    /** Creates an ElectricParkingArea with default values.
     * It is used to increment speed of UnitTests.
     */
    public ElectricParkingArea(){
        super(new ParkingAreaAddress(), 100);

        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
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
//        this.maxElectricCarCapacity = maxElectricCarCapacity;

        if (maxElectricCarCapacity > 100) {
            log.error("Value set to high!");
            log.info(String.valueOf(maxElectricCarCapacity));
            }
            else if (maxElectricCarCapacity < 0){
            log.error("Value set to low!");
            log.info(String.valueOf(maxElectricCarCapacity));
            }

            else {
            this.maxElectricCarCapacity = maxElectricCarCapacity;
            log.info("Set Electric Car Capacity to ");
            log.info(String.valueOf(maxElectricCarCapacity));
            }
    }

    public List<ElectricCar> getElectricCarsInStation() {
        return electricCarsInStation;
    }

    public void setElectricCarsInStation(List<ElectricCar> electricCarsInStation) {
        this.electricCarsInStation = electricCarsInStation;
    }

    public List<ElectricCar> getAvailableElectricCars() {
        return availableElectricCars;
    }

    public void setAvailableElectricCars(List<ElectricCar> availableElectricCars) {
        this.availableElectricCars = availableElectricCars;
    }

    public List<ElectricCar> getNotAvailableElectricCars() {
        return notAvailableElectricCars;
    }

    public void setNotAvailableElectricCars(List<ElectricCar> notAvailableElectricCars) {
        this.notAvailableElectricCars = notAvailableElectricCars;
    }

    /* /////////////////////Methods/////////////////////////// */

    /**adds an electric car to the station
     * @param electricCar an Electric OneNightCar.Car
     */
    public void assignElectricCarToStation(ElectricCar electricCar) {

        try {
            electricCarsInStation.add(electricCar);
            availableElectricCars.add(electricCar);
        }
        catch(Exception e){
            System.out.print(e + "Assigning Electric Car to station has failed!");
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

    /* /////////////////////Overrides/////////////////////////// */

}
