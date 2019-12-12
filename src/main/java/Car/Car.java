package Car;

import ZuLöschen.List;
import Rental.Rental;

/**
 *  <h2> Car class </h2>
 *  it has the common Information about the cars
 *  it's the superclass of CombustionCar class and ElectricCar class
 *
 *  @author OneNightCar Team
 *  @version 1.0
 *  @since 2019-12-11
 */
public abstract class Car {
    private int carID;
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
    protected String permission; // which Customer can book this car (which customer Level)
    protected float price;       //Price pro hour

    /* /////////////////////Methods/////////////////////////// */
    public Car(Type type, String brand, String model, State state,
               double GPSLatitude, double GPSLongitude, long odometer,
               String permission, float price){
        this.type= type;
        this.brand=brand;
        this.model=model;
        this.state=state;
        Location location = new Location(GPSLatitude,GPSLongitude);
        this.odometer=odometer;
        this.permission= permission;
        this.price=price;

    }

    public Car(){

    }


    public void changeCarState (State newCarState) {
        this.state = newCarState;
    }

    public State getCarState(){
        return this.state;
    }

   public void setNewLocation(double GPSLatitude, double GPSLongitude){
        Location location= new Location(GPSLatitude,GPSLongitude);
   }




    public float getPrice(){
        return this.price;
    }

    public int getCarID (){
        return this.carID;
    }

    public long getOdometer (){
        return this.odometer;
    }

    public void setOdometer (Rental rental) {
        //**************************************** bleibt das so ??
        this.odometer = rental.getOdometerAfter();
    }

    /**
     * this method is to change the car State
     * @param state State */
    public void setCarState(State state){
        this.state = state;
    }


}

