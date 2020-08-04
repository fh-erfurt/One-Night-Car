package de.onenightcar.model.car;

import de.onenightcar.model.parkingArea.ParkingArea;
import de.onenightcar.model.person.Customer;

import javax.persistence.*;

/** Represents a Combustion OneNightCar.Car
 * extent OneNightCar.Car
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class CombustionCar extends Car {

    /* /////////////////////Attributes/////////////////////////// */

    // A car does not change it Transmission, its enough when we save just a String whit the Car Transmission
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    // A car does not change it FuelType, its enough when we save just a String whit the Car FuelType
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private double tankSize;    // in liter
    private double fuelLevel;   // in percent
    private double consumption; // the Consumption in 100 Km

    @ManyToOne(fetch = FetchType.LAZY)
    private ParkingArea parkingArea;

    /* /////////////////////Constructors/////////////////////////// */

    // Needed to be able to create the entity
    protected CombustionCar(){}


    /** Creates an ElectricCar with specified ElectricCar Parameters.
     * @param type A enum representing the Type of the OneNightCar.Car
     * @param brand A String representing a OneNightCar.Car Brand
     * @param model A String representing a OneNightCar.Car Model
     * @param state A enum representing the State of the OneNightCar.Car (Perfect, Ok, Damaged)
     * @param odometer A Long representing the odometer Number of the OneNightCar.Car
     * @param GPSLatitude  A double representing the OneNightCar.Car position
     * @param GPSLongitude A double representing the OneNightCar.Car position
     * @param customerLevel An enum from Customer representing the User Permission
     * @param price A float representing the costs of the OneNightCar.Car per Hour
     * @param tankSize A double representing the max. Tank Size of the OneNightCar.Car
     * @param fuelLevel A double representing the current Fuel Level
     * @param consumption A double representing the consumption of the OneNightCar.Car in 100 km
     * @param transmission An enum representing the Transmission of the OneNightCar.Car (Manuel, Automatic)
     * @param fuelType an enum representing the Fuel Type of the OneNightCar.Car (Petrol, Diesel)
     * @param parkingArea an ParkingArea object
     */
    public CombustionCar(Type type, String brand, String model, State state,
                         double GPSLatitude, double GPSLongitude, long odometer,
                         Customer.CustomerLevel customerLevel, float price, double tankSize,
                         double fuelLevel, double consumption, Transmission transmission,
                         FuelType fuelType,  ParkingArea parkingArea){
        super(type, brand, model, state, GPSLatitude, GPSLongitude, odometer,
                customerLevel, price);

        this.tankSize= tankSize;
        this.fuelLevel= fuelLevel;
        this.consumption=consumption;
        this.transmission = transmission;
        this.fuelType= fuelType;
        if(parkingArea.numberOfCarsAssignedToStation() < parkingArea.getMaxCapacity()) {
            parkingArea.assignCarToStation(this);
        }
        else{
            System.out.println("there is no more place in this park!");
        }
    }

    /** Creates a Combustion OneNightCar.Car  with default Values.
     * It is used to increment speed of UnitTests.
     * @param parkingArea A CarManagementSystem with the management from the Packet OneNightCar.Car
     */
    public CombustionCar(ParkingArea parkingArea){
        super(Type.MIDDLE, "Mercedes", "glc_250", State.OK, 50.984790, 11.041410, 197212,
                Customer.CustomerLevel.REGULARUSER, 39.99f);
        this.tankSize = 66;
        this.fuelLevel = 100;
        this.consumption = 8.1;
        this.transmission = Transmission.AUTOMATIC;
        this.fuelType = FuelType.PETROL;
        if(parkingArea.numberOfCarsAssignedToStation() < parkingArea.getMaxCapacity()) {
            parkingArea.assignCarToStation(this);
        }
        else{
            System.out.println("there is no more place in this park!");
        }
    }

    public ParkingArea getParkingArea() {
        return parkingArea;
    }

    public void setParkingArea(ParkingArea parkingArea) {
        this.parkingArea = parkingArea;
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    /** Gets the Fuel Level
     * @return The Combustion OneNightCar.Car current Fuel level
     */
   public double getFuelLevel(){
       return this.fuelLevel;
   }

    /** Change the Combustion OneNightCar.Car fuel level .
     * @param fuelLevel a double with the new fuellevel
     */
    public void setFuelLevel(double fuelLevel){
        try {
            this.fuelLevel = fuelLevel;
        }
        catch(Exception e){
            System.out.print("FuelLevel inadmissible!");
        }
    }

    /** Gets the max. Tank Size
     * @return The Combustion OneNightCar.Car Tank Size
     */
   public double getTankSize(){
       return this.tankSize;
   }


    /** Gets the Average of Consumption
     * @return The Combustion OneNightCar.Car Consumption
     */
   public double getConsumption(){
       return this.consumption;
   }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /* /////////////////////Methods/////////////////////////// */

    /** set the fuel level on 100 %
     * */
    public void getTanked(){
        setFuelLevel(100);
    }

    /* /////////////////////Enums/////////////////////////// */

    public enum  Transmission{
        MANUAL,
        AUTOMATIC
    }

    public enum FuelType{
        PETROL,
        DIESEL
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "CombustionCar{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CombustionCar that = (CombustionCar) o;

        if (Double.compare(that.tankSize, tankSize) != 0) return false;
        if (Double.compare(that.fuelLevel, fuelLevel) != 0) return false;
        if (Double.compare(that.consumption, consumption) != 0) return false;
        if (transmission != that.transmission) return false;
        if (fuelType != that.fuelType) return false;
        return parkingArea.equals(that.parkingArea);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = transmission.hashCode();
        result = 31 * result + fuelType.hashCode();
        temp = Double.doubleToLongBits(tankSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(consumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + parkingArea.hashCode();
        return result;
    }
}

