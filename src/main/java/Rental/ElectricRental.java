package Rental;

import Car.CarManagementSystem;
import Car.ElectricCar;
import Person.Customer;
import Person.PersonManager;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;


/** A class for cars that run on electricity
 *
 */
public class ElectricRental extends Rental {
    /* /////////////////////Attributes///////////////////////// */

    private float chargePercentBefore;
    private float chargePercentAfter;
    private ElectricCar electricCar;

    /* /////////////////////Methods/////////////////////////// */

    /**
     * Creates a Rental entry for a rental of an electric Car
     * @param electricCar the car itself, object of the class ElectricCar
     * @param carManagementSystem the management system, so we can get information about the car
     * @param date the date of the rental
     * @param yearDeparture  the time at which the customer started the rental
     * @param monthDeparture  the time at which the customer started the rental
     * @param dayDeparture  the time at which the customer started the rental
     * @param yearArrival the time at which he has returned
     * @param monthArrival the time at which he has returned
     * @param dayArrival the time at which he has returned
     * @param rentalManager the management system needed to add the entry to the global list
     * @param customerID the Customer ID
     */
    public ElectricRental(ElectricCar electricCar, CarManagementSystem carManagementSystem, int customerID, LocalDate date, int yearDeparture,int monthDeparture,int dayDeparture,
                          int yearArrival ,int monthArrival, int dayArrival, RentalManager rentalManager){
        super(customerID, date, yearDeparture, monthDeparture, dayDeparture, yearArrival, monthArrival, dayArrival);
        this.rentalID = rentalManager.getAndIncrementCounter();
        rentalManager.addRentalIntoElectricRentals(this);
        this.carID = carManagementSystem.getCarIDFromElectric(electricCar);
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
        this.electricCar = electricCar;
    }

    /**
     * A constructor that uses default values
     * @param rentalManager the management system needed to add the entry to the global list
     * @param carManagementSystem the management system, so we can get information about the car
     * @param customerID an Int representing the customers ID
     * @param electricCar the car itself, object of the class ElectricCar
     */
    public ElectricRental(RentalManager rentalManager, CarManagementSystem carManagementSystem, int customerID, ElectricCar electricCar){
        super();
        this.rentalID = rentalManager.getAndIncrementCounter();
        rentalManager.addRentalIntoElectricRentals(this);
        this.carID = carManagementSystem.getCarIDFromElectric(electricCar);
        this.customerID = customerID;
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
        this.electricCar = electricCar;
    }

    /** Sets the charge of the electric car after the rental
     * @param ElectricCar the rented electric car
     */
    public void setChargePercentAfter (ElectricCar ElectricCar) {
        if ((this.odometerAfter - this.odometerBefore) > ElectricCar.getRange()) {
            this.chargePercentAfter = -1;
        }
        else {
            this.chargePercentAfter = (ElectricCar.getRange() - (this.odometerAfter - this.odometerBefore)) / ElectricCar.getRange();
        }
    }

    public float getChargePercentAfter() { return this.chargePercentAfter; }

    private float calculateRentalPriceForElectric(ElectricCar ElectricCar) {
        return calculateElapsedDays() * ElectricCar.getPrice();
    }

    public ElectricCar getElectricCar() { return this.electricCar; }

}
