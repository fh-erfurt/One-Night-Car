package de.onenightcar.model.rental;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.person.Customer;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    protected List<RentalTimeSlot> timeSlotsList = new ArrayList<>();

    @OneToOne
    private CombustionCar combustionCar;

    /* /////////////////////Constructors/////////////////////////// */

    protected FuelRental() {}

    /** Creates a rental entry with parameters for a combustion car
     * @param date The date a rental has been created
     * @param combustionCar a Combustion OneNightCar.Car
     * @param customer Who is making the rental
     * @param timeSlotsList which timeslots are being used
     */
    public FuelRental(CombustionCar combustionCar, LocalDate date, Customer customer, List<RentalTimeSlot> timeSlotsList){
        super(date, customer);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = combustionCar.getFuelLevel();
        this.combustionCar = combustionCar;
        this.timeSlotsList = timeSlotsList;
        //add this Rental to the given timeslots
        this.timeSlotsList = timeSlotsList;
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
    }

    /**
     * A constructor that uses default values
     * @param combustionCar the car itself, object of the class ElectricCar
     * @param date at what time was the rental made
     */
    public FuelRental(LocalDate date, CombustionCar combustionCar, Customer customer){
        super(date, customer);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = getFuelLevelAfter();
        this.combustionCar = combustionCar;
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
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

    private int calculateElapsedHours() {
        return this.timeSlotsList.size();
    }

    /**
     * Takes the price of a car and multiplies it with the elapsed hours
     * @param CombustionCar is the car rented by the customer
     * @return the total price of the rental
     */
    public float calculateRentalPriceForCombustion (CombustionCar CombustionCar) {
        return calculateElapsedHours() * CombustionCar.getPrice();
    }

    /** Sets the odometer to the value after the rental
     * Based on a simulated drive
     */
    public void setOdometerAfter(){
        try {
            //Calculates the driven amount of kilometres by using the average speed of a car in Munich (as it can't be inspected)
            this.odometerAfter = odometerBefore + ((calculateElapsedHours() * 32));
        }
        catch(Exception e){
            System.out.print("Set Odometer has failed!");
        }
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "FuelRental{" +
                "rentalPrice=" + rentalPrice +
                ", odometerBefore=" + odometerBefore +
                ", odometerAfter=" + odometerAfter +
                ", rentalDate=" + rentalDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuelRental that = (FuelRental) o;

        if (Double.compare(that.fuelLevelBefore, fuelLevelBefore) != 0) return false;
        if (Double.compare(that.fuelLevelAfter, fuelLevelAfter) != 0) return false;
        if (timeSlotsList != null ? !timeSlotsList.equals(that.timeSlotsList) : that.timeSlotsList != null)
            return false;
        return combustionCar != null ? combustionCar.equals(that.combustionCar) : that.combustionCar == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(fuelLevelBefore);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelLevelAfter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (timeSlotsList != null ? timeSlotsList.hashCode() : 0);
        result = 31 * result + (combustionCar != null ? combustionCar.hashCode() : 0);
        return result;
    }
}
