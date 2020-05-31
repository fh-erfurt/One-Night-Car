package de.onenightcar.domain.model.car;

import de.onenightcar.domain.model.person.Customer;

/** Represents a Combustion OneNightCar.Car
 * extent OneNightCar.Car
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class CombustionCar extends Car {
    private double tankSize;    // in liter
    private double fuelLevel;   // in percent
    private double consumption; // the Consumption in 100 Km
    private Transmission transmission;
    private FuelType fuelType;
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
     * @param carManagementSystem The system where all the car are saved
     */
    public CombustionCar(Type type, String brand, String model, State state,
                         double GPSLatitude, double GPSLongitude, long odometer,
                         Customer.CustomerLevel customerLevel, float price, double tankSize,
                         double fuelLevel, double consumption, Transmission transmission,
                         FuelType fuelType, CarManagementSystem carManagementSystem){
        super(type, brand, model, state, GPSLatitude, GPSLongitude, odometer,
                customerLevel, price);
        this.tankSize= tankSize;
        this.fuelLevel= fuelLevel;
        this.consumption=consumption;
        this.transmission = transmission;
        this.fuelType= fuelType;
        carManagementSystem.combustionCarsList.add(this);
    }
    /** Creates a Combustion OneNightCar.Car  with default Values.
     * It is used to increment speed of UnitTests.
     * @param carManagementSystem A CarManagementSystem with the management from the Packet OneNightCar.Car
     */
    public CombustionCar(CarManagementSystem carManagementSystem){
        super(Type.MIDDLE, "Mercedes", "glc_250", State.OK, 50.984790, 11.041410, 197212,
                Customer.CustomerLevel.REGULARUSER, 39.99f);
        this.tankSize = 66;
        this.fuelLevel = 100;
        this.consumption = 8.1;
        this.transmission = Transmission.AUTOMATIC;
        this.fuelType = FuelType.PETROL;
        carManagementSystem.combustionCarsList.add(this);
    }

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
        this.fuelLevel=fuelLevel;
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

    /** set the fuel level on 100 %
     * */
    public void getTanked(){
       setFuelLevel(100);
    }


    public enum  Transmission{
        MANUAL,
        AUTOMATIC;
    }


    public enum FuelType{
        PETROL,
        DIESEL;
    }
}

