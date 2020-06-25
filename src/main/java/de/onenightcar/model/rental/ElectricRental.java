package de.onenightcar.model.rental;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    static Logger log = LoggerFactory.getLogger(ElectricRental.class);

    private float chargePercentBefore;
    private float chargePercentAfter;

    @OneToOne
    private ElectricCar electricCar;

    /* /////////////////////Methods/////////////////////////// */

    protected ElectricRental() {}

    /**
     * Creates a OneNightCar.Rental entry for a rental of an electric OneNightCar.Car
     * @param electricCar the car itself, object of the class ElectricCar
     * @param date the date of the rental
     * @param departure the date and time at which the customer started the rental
     * @param arrival the date and time at which the customer ended the rental
     */
    public ElectricRental(ElectricCar electricCar, LocalDateTime date, LocalDateTime departure,
                          LocalDateTime arrival){
        super(date, departure, arrival);
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
        this.electricCar = electricCar;
    }

    /**
     * A constructor that uses default values
     * @param electricCar the car itself, object of the class ElectricCar
     */
    public ElectricRental(ElectricCar electricCar){
        super();
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
        this.electricCar = electricCar;
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
