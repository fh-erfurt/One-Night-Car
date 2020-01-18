package Car;

import Rental.Rental;
/**
 *  <h2> CombustionCar class </h2>
 *  it has the Information about the Traditional cars
 *
 *  @author OneNightCar Team
 *  @version 1.1.0
 *  @since 2020-01-15
 */

public class CombustionCar extends Car {
    private double tankSize;    // in liter
    private double fuelLevel;   // in percent
    private double consumption; // the Consumption in 100 Km
    private Transmission transmission;
    public enum  Transmission{
        MANUAL,
        AUTOMATIC;
    }
    private FuelType fuelType;
    public enum FuelType{
        PETROL,
        DIESEL;
    }

    public CombustionCar(Type type, String brand, String model, State state,
                         double GPSLatitude, double GPSLongitude, long odometer,
                         String permission, float price, double tankSize,
                         double fuelLevel, double consumption, Transmission transmission,
                         FuelType fuelType){
        super(type, brand, model, state, GPSLatitude, GPSLongitude, odometer,
                permission, price);
        this.tankSize= tankSize;
        this.fuelLevel= fuelLevel;
        this.consumption=consumption;
        this.transmission = transmission;
        this.fuelType= fuelType;
    }

    /** Create a Combustion Car with a default Value
     * it is Used to Increment speed of unitTests
     * */
    public CombustionCar(){
        super(Type.MIDDLE, "Mercedes", "glc_250", State.OK, 50.984790, 11.041410, 197212,
                "NEWUSER", 39.99f);
        this.tankSize = 66;
        this.fuelLevel = 100;
        this.consumption = 8.1;
        this.transmission = Transmission.AUTOMATIC;
        this.fuelType = FuelType.PETROL;
    }



   public double getFuelLevel(){
       return this.fuelLevel;
   }

   public double calculateConsumedFuel(){
       double consumedFuel;
       // auf die 2 Methoden warten
       // consumedFuel = Rental.getFuelLevelBefore - Rental.getFuelLevelAfter;
       // return consumedFuel;
       return  0;   // um error zu vermeiden
   }
   public double getTankSize(){
       return this.tankSize;
   }
   public double getConsumption(){
       return this.consumption;
   }

    public void setFuelLevel(double fuelLevel){
        this.fuelLevel=fuelLevel;
    }

    public void getTanked(){
        // TODO etwas machen
        if (calculateConsumedFuel() > 50)
        {

        }
    }
}

