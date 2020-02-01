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

    private double chargePercentBefore;
    private double chargePercentAfter;
    /* /////////////////////Methods/////////////////////////// */

    /**
     * Creates a Rental entry for a rental of an electric Car
     * @param ElectricCar the car itself, object of the class ElectricCar
     * @param CarManagementSystem the management system, so we can get information about the car
     * @param customer the customer
     * @param date the date of the rental
     * @param yearDeparture  the time at which the customer started the rental
     * @param monthDeparture  the time at which the customer started the rental
     * @param dayDeparture  the time at which the customer started the rental
     * @param yearArrival the time at which he has returned
     * @param monthArrival the time at which he has returned
     * @param dayArrival the time at which he has returned
     * @param RentalManager the management system needed to add the entry to the global list
     * @param Personmanager a system to manage the customer's information
     */
    public ElectricRental(ElectricCar ElectricCar, CarManagementSystem CarManagementSystem, PersonManager Personmanager, Customer customer, LocalDate date, int yearDeparture,int monthDeparture,int dayDeparture,
                          int yearArrival ,int monthArrival, int dayArrival, RentalManager RentalManager){
        this.rentalID = RentalManager.getSizeOfElectricRentals();
        RentalManager.addRentalIntoElectricRentals(this);
        this.carID = CarManagementSystem.getCarIDFromElectric(ElectricCar);
        this.customerID = Personmanager.getCustomerIndexInCustomerList(customer);
        this.rentalPrice = calculateRentalPriceForElectric(ElectricCar);
        this.date = date;
        this.departureTime = new GregorianCalendar(yearDeparture, monthDeparture, dayDeparture);
        this.arrivalTime = new GregorianCalendar(yearArrival, monthArrival, dayArrival);
        this.odometerBefore = ElectricCar.getOdometer();
        this.chargePercentBefore = ElectricCar.getChargePercent();
    }

    /**
     * A constructor that uses default values
     * @param RentalManager the management system needed to add the entry to the global list
     * @param carManagementSystem the management system, so we can get information about the car
     * @param customer the customer
     * @param electricCar the car itself, object of the class ElectricCar
     * @param personManager a system to manage the customer's information
     */
    ElectricRental(RentalManager RentalManager, CarManagementSystem carManagementSystem, Customer customer, ElectricCar electricCar, PersonManager personManager){
        this.rentalID = RentalManager.getSizeOfElectricRentals();
        RentalManager.addRentalIntoElectricRentals(this);
        this.carID = carManagementSystem.getCarIDFromElectric(electricCar);
        this.customerID = personManager.getCustomerIndexInCustomerList(customer);
        this.rentalPrice = electricCar.getPrice();
        this.date = LocalDate.now();
        this.departureTime = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        this.arrivalTime = new GregorianCalendar(2020, Calendar.DECEMBER, 31);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
    }

    /** Sets the charge of the electric car after the rental
     *
     * @param ElectricCar the rented electric car
     * @return the current charge before recharge
     */
    public void setChargePercentAfter (ElectricCar ElectricCar) {
        this.chargePercentAfter = (ElectricCar.getRange() - (this.odometerAfter - this.odometerBefore)) / ElectricCar.getRange();
    }

    private double getChargePercentAfter() { return this.chargePercentAfter; }

    private float calculateRentalPriceForElectric(ElectricCar ElectricCar) {
        return calculateElapsedDays() * ElectricCar.getPrice();
    }

}
