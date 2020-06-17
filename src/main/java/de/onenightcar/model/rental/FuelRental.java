package de.onenightcar.model.rental;

import de.onenightcar.model.car.CombustionCar;


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

    /* /////////////////////Methods/////////////////////////// */

    protected FuelRental() {}

    /** Creates a rental entry with parameters for a combustion car
     * * @param rentalID An integer value used to identify certain rental entries
     * * @param carID An integer value used to identify certain cars inside a rental entry
     * * @param customerID An integer value used to identify certain customers inside a rental entry
     * * @param rentalPrice The total price of a rental
     * * @param odometerBefore The value on the odometer of a car before the rental
     * * @param odometerAfter  The value on the odometer of a car after the rental
     * @param date The date a rental has been created
     * @param departure  the date and time at which the customer started the rental
     * @param arrival the date and time at which the customer ended the rental
     * @param combustionCar a Combustion OneNightCar.Car
     * @param customerID which customer is making the OneNightCar.Rental
     */
    public FuelRental( CombustionCar combustionCar,  int customerID, LocalDateTime date,
                      LocalDateTime departure, LocalDateTime arrival){
        super(customerID, date, departure, arrival);
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = combustionCar.getFuelLevel();
        this.combustionCar = combustionCar;
    }

    /**
     * A constructor that uses default values
     * @param customerID an Int representing the customers ID
     * @param combustionCar the car itself, object of the class ElectricCar
     * @param date at what time was the rental made
     */
    public FuelRental( int customerID, LocalDateTime date,
                      CombustionCar combustionCar){
        super();
        this.customerID = customerID;
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = getFuelLevelAfter();
        this.combustionCar = combustionCar;
    }


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

    /**
     * Takes the price of a car and multiplies it with the elapsed hours
     * @param CombustionCar is the car rented by the customer
     * @return the total price of the rental
     */
    public float calculateRentalPriceForCombustion (CombustionCar CombustionCar) {
        float rentalPrice = calculateElapsedDays() * CombustionCar.getPrice();
        return rentalPrice;
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
}
