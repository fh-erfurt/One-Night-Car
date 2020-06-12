package de.onenightcar.domain.model.rental;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.ElectricCar;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/** Represents an ElectricRental
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
@Entity
public class ElectricRental extends Rental {
    /* /////////////////////Attributes///////////////////////// */

    private float chargePercentBefore;
    private float chargePercentAfter;

    @OneToOne
    private ElectricCar electricCar;

    /* /////////////////////Methods/////////////////////////// */

    /**
     * Creates a OneNightCar.Rental entry for a rental of an electric OneNightCar.Car
     * @param electricCar the car itself, object of the class ElectricCar
     * @param carManagementSystem the management system, so we can get information about the car
     * @param date the date of the rental
     * @param departure the date and time at which the customer started the rental
     * @param arrival the date and time at which the customer ended the rental
     * @param rentalManager the management system needed to add the entry to the global list
     * @param customerID the Customer ID
     */
    public ElectricRental(ElectricCar electricCar, CarManagementSystem carManagementSystem, int customerID, LocalDateTime date, LocalDateTime departure,
                          LocalDateTime arrival, RentalManager rentalManager){
        super(customerID, date, departure, arrival);
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

    public ElectricRental() {

    }

    public float getChargePercentAfter() { return this.chargePercentAfter; }

    /** Sets the charge of the electric car after the rental
     * @param electricCar the rented electric car
     */
    public void setChargePercentAfter (ElectricCar electricCar) {
        if ((this.odometerAfter - this.odometerBefore) > electricCar.getElectricalRange()) {
            this.chargePercentAfter = -1;
        }
        else {
            this.chargePercentAfter = (electricCar.getElectricalRange() - (this.odometerAfter - this.odometerBefore)) / electricCar.getElectricalRange();
        }
    }

    private float calculateRentalPriceForElectric(ElectricCar ElectricCar) {
        return calculateElapsedDays() * ElectricCar.getPrice();
    }

    public ElectricCar getElectricCar() {
        try {
            return this.electricCar;
        }
        catch(Exception e){
            System.out.print("Electric Car doesn't exist!");
            return electricCar;                               //edit return
        }
    }

}
