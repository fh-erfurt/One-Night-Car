package Rental;

import Car.CombustionCar;
import Car.CarManagementSystem;
import Person.Customer;
import Person.PersonManager;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.lang.Math;

/**
 * A class for cars that run on gasoline
 */
public class FuelRental extends Rental {
    /* /////////////////////Attributes///////////////////////// */

    private double fuelLevelBefore;
    private double fuelLevelAfter;
    /* /////////////////////Methods/////////////////////////// */
    /** Creates a rental entry with parameters for a combustion car
     * * @param rentalID An integer value used to identify certain rental entries
     * * @param carID An integer value used to identify certain cars inside a rental entry
     * * @param customerID An integer value used to identify certain customers inside a rental entry
     * * @param rentalPrice The total price of a rental
     * * @param odometerBefore The value on the odometer of a car before the rental
     * * @param odometerAfter  The value on the odometer of a car after the rental
     * @param date The date a rental has been created
     * @param yearDeparture  the time at which the customer started the rental
     * @param monthDeparture  the time at which the customer started the rental
     * @param dayDeparture  the time at which the customer started the rental
     * @param yearArrival the time at which he has returned
     * @param monthArrival the time at which he has returned
     * @param dayArrival the time at which he has returned
     */
    public FuelRental(RentalManager RentalManager, CombustionCar CombustionCar, CarManagementSystem CarManagementSystem, Customer customer, LocalDate date,
                      int yearDeparture,int monthDeparture,int dayDeparture, int yearArrival ,int monthArrival, int dayArrival){
        rentalID = RentalManager.getSizeOfFuelRentals();            //Creates a running counter of Rentals in list
        RentalManager.addRentalIntoFuelRentals(this);                          //Adds the new rental to the global list
        this.carID = CarManagementSystem.getCarIDFromCombustion(CombustionCar);
        this.customerID = customer.getCustomerID();
        this.rentalPrice = calculateRentalPriceForCombustion(CombustionCar);
        this.date = date;
        this.departureTime = new GregorianCalendar(yearDeparture, monthDeparture, dayDeparture);
        this.arrivalTime = new GregorianCalendar(yearArrival, monthArrival, dayArrival);
        this.odometerBefore = CombustionCar.getOdometer();
        this.fuelLevelBefore = CombustionCar.getFuelLevel();
        this.fuelLevelAfter = CombustionCar.getFuelLevel();
    }

    public FuelRental(RentalManager RentalManager, CarManagementSystem CarManagementSystem, Customer customer, LocalDate date, CombustionCar CombustionCar, PersonManager PersonManager){
        this.rentalID = RentalManager.getSizeOfFuelRentals();
        RentalManager.addRentalIntoFuelRentals(this);
        this.carID = CarManagementSystem.getCarIDFromCombustion(CombustionCar);
        this.customerID = PersonManager.getCustomerIndexInCustomerList(customer);
        this.rentalPrice = calculateRentalPriceForCombustion(CombustionCar);
        this.date = date;
        this.departureTime = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        this.arrivalTime = new GregorianCalendar(2020, Calendar.JANUARY, 4);
        this.odometerBefore = CombustionCar.getOdometer();
        this.fuelLevelBefore = CombustionCar.getFuelLevel();
        this.fuelLevelAfter = getFuelLevelAfter();
    }
    /** Sets the fuelLevel after the rental of the car
     *
     * @param CombustionCar The car that has been rented
     * @return The fuel level of the car after the rental
     */
    public double setFuelLevelAfter (CombustionCar CombustionCar) {
        double fuelLevel = CombustionCar.getFuelLevel() - (CombustionCar.getConsumption() * (this.odometerAfter - this.odometerBefore));
        return fuelLevel;
    }

    public double getFuelLevelAfter(){
        return this.fuelLevelAfter;
    }

    /**
     * Takes the price of a car and multiplies it with the elapsed hours
     * @param CombustionCar is the car rented by the customer
     * @return the total price of the rental
     */
    public float calculateRentalPriceForCombustion (CombustionCar CombustionCar) {
        float rentalPrice = calculateElapsedDays() * CombustionCar.getPrice();
        return rentalPrice;
    }

}
