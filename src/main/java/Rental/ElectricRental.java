package Rental;

import Car.CarManagementSystem;
import Car.ElectricCar;
import Person.Customer;
import Person.PersonManager;


import java.time.LocalDate;
import java.time.LocalDateTime;




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
     * @param departureTime the time at which the customer started the rental
     * @param arrivalTime the time at which he has returned
     * @param RentalManager the management system needed to add the entry to the global list
     * @param Personmanager a system to manage the customer's information
     */
    public ElectricRental(ElectricCar ElectricCar, CarManagementSystem CarManagementSystem, PersonManager Personmanager, Customer customer, LocalDate date, LocalDateTime departureTime, LocalDateTime arrivalTime, RentalManager RentalManager){
        this.rentalID = RentalManager.getSizeOfElectricRentals();
        RentalManager.addRentalIntoElectricRentals(this);
        this.carID = CarManagementSystem.getCarIDFromElectric(ElectricCar);
        this.customerID = Personmanager.getCustomerIndexInCustomerList(customer);
        this.rentalPrice = calculateRentalPriceForElectric(ElectricCar);
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.odometerBefore = ElectricCar.getOdometer();
        this.chargePercentBefore = ElectricCar.getChargePercent();
    }

    /**
     * A constructor that uses default values
     * @param RentalManager the management system needed to add the entry to the global list
     * @param CarManagementSystem the management system, so we can get information about the car
     * @param customer the customer
     * @param ElectricCar the car itself, object of the class ElectricCar
     * @param PersonManager a system to manage the customer's information
     */
    ElectricRental(RentalManager RentalManager, CarManagementSystem CarManagementSystem, Customer customer, ElectricCar ElectricCar, PersonManager PersonManager){
        this.rentalID = RentalManager.getSizeOfElectricRentals();
        RentalManager.addRentalIntoElectricRentals(this);
        this.carID = CarManagementSystem.getCarIDFromElectric(ElectricCar);
        this.customerID = PersonManager.getCustomerIndexInCustomerList(customer);
        this.rentalPrice = calculateRentalPriceForElectric(ElectricCar);
        this.date = LocalDate.now();
        this.departureTime = LocalDateTime.now();
        this.arrivalTime = LocalDateTime.now().plusWeeks(1);
        this.odometerBefore = ElectricCar.getOdometer();
        this.chargePercentBefore = ElectricCar.getChargePercent();
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
