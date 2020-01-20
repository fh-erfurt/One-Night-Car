package Car;

import Person.Customer;
import Rental.Rental;

/** Represents a Car
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
public abstract class Car {

    protected Type type;
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
    protected String brand;
    protected String model;
    protected State state;
    public enum State{
        PERFECT,        //Only when a car is New and never has been repaired
        OK,             //The car works but it has been repaired
        DAMAGED;        //the car doesn't works
    }

    protected long odometer;
    protected Enum permission; // which Customer can book this car (which customer Level)
    protected float price;       //Price pro hour
    Location location;

    /* /////////////////////Methods/////////////////////////// */
    /** Creates an Car Constructor with Parameters to use it in the Child Class.
     * @param type A enum representing the Type of the Car
     * @param brand A String representing a Car Brand
     * @param model A String representing a Car Model
     * @param state A enum representing the State of the Car (Perfect, Ok, Damaged)
     * @param odometer A Long representing the odometer Number of the Car
     * @param GPSLatitude  A double representing the Car position
     * @param GPSLongitude A double representing the Car position
     * @param customerLevel An enum from Customer representing the User Permission
     * @param price A float representing the costs of the Car per Hour
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


    /** Change the Car state .
     * @param newCarState an enum containing the Car new State
     */
    public void changeCarState (State newCarState) {
        this.state = newCarState;
    }


    /** Gets the Car State.
     * @return the Car State
     */
    public State getCarState(){
        return this.state;
    }


    /** Set a new Location of the Car .
     * @param GPSLatitude
     * @param GPSLongitude
     * @see {@link Location}
     */
   public void setNewLocation(double GPSLatitude, double GPSLongitude){
        this.location= new Location(GPSLatitude,GPSLongitude);
   }


    /** Gets the Car Location
     * @return the Location of the Car
     * @see {@link Location}
     */
   public Location getLocation(){
        return this.location;
   }


    /** Gets the Car Price
     * @return the Price of the Car in one Hour
     */
    public float getPrice(){
        return this.price;
    }


    /** Gets the Car odometer
     * @return the Odometer of the Car
     */
    public long getOdometer (){
        return this.odometer;
    }

    /** Change the Car odometer .
     * @param rental gets the Odometer information after the return of the Car from the Rental Class
     * @see {@link Rental}
     */
//    public void setOdometer (Rental rental) {
//        this.odometer = rental.getOdometerAfter();
//    }



}

