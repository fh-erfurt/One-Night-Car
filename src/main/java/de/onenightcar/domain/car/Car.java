package de.onenightcar.domain.car;

import de.onenightcar.domain.person.Customer;
import de.onenightcar.domain.rental.Rental;

/** Represents a OneNightCar.Car
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
public abstract class Car {

    protected Type type;
    protected String brand;
    protected String model;
    protected State state;
    protected long odometer;
    protected Enum permission;    // which Customer can book this car (which customer Level)
    protected float price;       //Price pro day
    Location location;
    /** Creates an OneNightCar.Car Constructor with Parameters to use it in the Child Class.
     * @param type A enum representing the Type of the OneNightCar.Car
     * @param brand A String representing a OneNightCar.Car Brand
     * @param model A String representing a OneNightCar.Car Model
     * @param state A enum representing the State of the OneNightCar.Car (Perfect, Ok, Damaged)
     * @param odometer A Long representing the odometer Number of the OneNightCar.Car
     * @param GPSLatitude  A double representing the OneNightCar.Car position
     * @param GPSLongitude A double representing the OneNightCar.Car position
     * @param customerLevel An enum from Customer representing the User Permission
     * @param price A float representing the costs of the OneNightCar.Car per Day
     */
    public Car(Type type, String brand, String model, State state,
               double GPSLatitude, double GPSLongitude, long odometer,
               Customer.CustomerLevel customerLevel, float price){
        this.type= type;
        this.brand=brand;
        this.model=model;
        this.state=state;
        this.location = new Location(GPSLatitude,GPSLongitude);
        this.odometer=odometer;
        this.permission= customerLevel;
        this.price=price;

    }

    /** Change the OneNightCar.Car state .
     * @param newCarState an enum containing the OneNightCar.Car new State
     */
    public void changeCarState (State newCarState) {
        this.state = newCarState;
    }

    /* /////////////////////Methods/////////////////////////// */

    /** Gets the OneNightCar.Car State.
     * @return the OneNightCar.Car State
     */
    public State getCarState(){
        return this.state;
    }

    /** Set a new Location of the OneNightCar.Car .
     * @param GPSLatitude the latitude of the GPS
     * @param GPSLongitude the longitude of the GPS
     */
   public void setNewLocation(double GPSLatitude, double GPSLongitude){
        this.location= new Location(GPSLatitude,GPSLongitude);
   }

    /** Gets the OneNightCar.Car Location
     * @return the Location of the OneNightCar.Car
     */
   public Location getLocation(){
        return this.location;
   }

   public double getGPSLatitude(){
       return this.location.getGPSLatitude();
   }

    public double getGPSLongitude(){
        return this.location.getGPSLongitude();
    }

    /** Gets the OneNightCar.Car Price
     * @return the Price of the OneNightCar.Car in one Hour
     */
    public float getPrice(){
        return this.price;
    }

    /** Gets the OneNightCar.Car odometer
     * @return the Odometer of the OneNightCar.Car
     */
    public long getOdometer (){
        return this.odometer;
    }

    /** Change the OneNightCar.Car odometer .
     * @param rental gets the Odometer information after the return of the OneNightCar.Car from the OneNightCar.Rental Class
     */
    public void setOdometer (Rental rental) {
        this.odometer = rental.getOdometerAfter();
    }


    public enum Type{
        MINI,
        LITTLE,
        UTILITARIAN,
        COMPACT,
        MINIVAN,
        MIDDLE,
        VAN,
        SUV;
    }

    public enum State{
        PERFECT,        //Only when a car is New and never has been repaired
        OK,             //The car works but it has been repaired
        DAMAGED;        //the car doesn't works
    }



}

