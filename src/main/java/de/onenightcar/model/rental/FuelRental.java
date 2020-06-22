package de.onenightcar.model.rental;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.person.Customer;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/** Represents a FuelRental
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
@Entity
public class FuelRental extends Rental {

    /* /////////////////////Attributes///////////////////////// */

    private double fuelLevelBefore;
    private double fuelLevelAfter;

    @OneToOne
    private CombustionCar combustionCar;

    /* /////////////////////Constructors/////////////////////////// */

    protected FuelRental() {}

    /** Creates a rental entry with parameters for a combustion car
     * @param date The date a rental has been created
     * @param departure  the date and time at which the customer started the rental
     * @param arrival the date and time at which the customer ended the rental
     * @param combustionCar a Combustion OneNightCar.Car
     */
    public FuelRental(CombustionCar combustionCar, LocalDateTime date,
                      LocalDateTime departure, LocalDateTime arrival, Customer customer){
        super(date, departure, arrival, customer);
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = combustionCar.getFuelLevel();
        this.combustionCar = combustionCar;
    }

    /**
     * A constructor that uses default values
     * @param combustionCar the car itself, object of the class ElectricCar
     * @param date at what time was the rental made
     */
    public FuelRental(LocalDateTime date, CombustionCar combustionCar, Customer customer){
        super(customer);
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = getFuelLevelAfter();
        this.combustionCar = combustionCar;
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    public double getFuelLevelAfter(){
        return this.fuelLevelAfter;
    }

    /** Sets the fuelLevel after the rental of the car
     * @param CombustionCar The car that has been rented
     */
    public void setFuelLevelAfter (CombustionCar CombustionCar) {
        if (CombustionCar.getConsumption() * (this.odometerAfter - this.odometerBefore) > CombustionCar.getTankSize()){
            this.fuelLevelAfter = -1;
        }
        else {
            this.fuelLevelAfter = CombustionCar.getFuelLevel() - (CombustionCar.getConsumption() * (this.odometerAfter - this.odometerBefore)) / CombustionCar.getFuelLevel();
        }
    }

    public CombustionCar getCombustionCar() {
        try {
            return this.combustionCar;
        }
        catch(Exception e){
            System.out.print("CombustionCar doesn't exist!");
            return combustionCar;
        }
    }

    public void setCombustionCar(CombustionCar combustionCar) {
        this.combustionCar = combustionCar;
    }

    public double getFuelLevelBefore() {
        return fuelLevelBefore;
    }

    public void setFuelLevelBefore(double fuelLevelBefore) {
        this.fuelLevelBefore = fuelLevelBefore;
    }

    public void setFuelLevelAfter(double fuelLevelAfter) {
        this.fuelLevelAfter = fuelLevelAfter;
    }

    /* /////////////////////Methods/////////////////////////// */

    /**
     * Takes the price of a car and multiplies it with the elapsed hours
     * @param CombustionCar is the car rented by the customer
     * @return the total price of the rental
     */
    public float calculateRentalPriceForCombustion (CombustionCar CombustionCar) {
        return calculateElapsedDays() * CombustionCar.getPrice();
    }

    /* /////////////////////Overrides/////////////////////////// */

}
