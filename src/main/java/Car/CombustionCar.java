package Car;

import Rental.Rental;
/**
 *  <h2> CombustionCar class </h2>
 *  it has the common Information about the combustion cars
 *  it's the superclass of @HybridCar class and @TraditionalCar class and @UtilitarianCar class
 *
 *  @author OneNightCar Team
 *  @version 1.0
 *  @since 2019-12-12
 */

public abstract class CombustionCar extends Car {
    private double tankSize;    // in liter
    private double fuelLevel;   // in percent
    private double consumption; // the Consumption in 100 Km

   public double getFuelLevel(){
       return this.fuelLevel;
   }

   public double calculateRemainingFuel(){
       double remainingFuel;
       // auf die 2 Methoden warten
       // remainingFuel = Rental.getFuelLevelBefore - Rental.getFuelLevelAfter;
       // return remainingFuel;
       return  0;   // um error zu vermeiden
   }
   public double getTankSize(){
       return this.tankSize;
   }
   public double getConsumption(){
       return this.consumption;
   }
}
