package Rental;

import Car.CombustionCar;
import Car.CarManagementSystem;
import Car.Car;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Math;
import java.util.List;

public class RentalForCombustion{
    /* /////////////////////Attributes///////////////////////// */
    private int rentalID;
    private int carID;
    private int customerID;
    private float rentalPrice;
    private long odometerBefore;
    private long odometerAfter = 0;
    public Date date;
    public Time departureTime;
    private Time arrivalTime;
    private double fuelAfter;


    /* /////////////////////Methods/////////////////////////// */

    public RentalForCombustion(CombustionCar CombustionCar, CarManagementSystem CarManagementSystem, int customerID, Date date, Time departureTime, Time arrivalTime, List list){
        rentalID = list.size();            //Creates a running counter of Rentals in list
        list.add(this);                          //Adds the new rental to the global list
        this.carID = CarManagementSystem.getCarIDFromCombustion(CombustionCar);
        this.customerID = customerID;
        this.rentalPrice = calculateElapsedHours() * CombustionCar.getPrice();
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.odometerBefore = CombustionCar.getOdometer();
        this.fuelAfter = CombustionCar.getFuelLevel() - (CombustionCar.getConsumption() * (this.odometerAfter - this.odometerBefore));
    }

    public int getRentalID ()
    {
        return this.rentalID;
    }


    public int calculateElapsedHours(){
        double elapsedHoursDouble = Math.ceil(((this.arrivalTime.getTime() - this.departureTime.getTime()) / 3600000));
        int elapsedHoursFloat = (int) elapsedHoursDouble;
        return elapsedHoursFloat;
    }

    public void setOdometerAfter(){
        this.odometerAfter = odometerBefore + (calculateElapsedHours() * 32); //Calculates the driven amount of kilometres by using the average speed of a car in Munich (as it can't be inspected)
    }


    public long getOdometerAfter(){
        return this.odometerAfter;
    }

    public double getFuelAfter(){
        return this.fuelAfter;
    }

    public int getCarID() {
        return this.carID;
    }
}
