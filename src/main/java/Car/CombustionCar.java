package Car;

import Rental.Rental;

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
