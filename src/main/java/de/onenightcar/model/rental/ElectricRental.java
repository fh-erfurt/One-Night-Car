package de.onenightcar.model.rental;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.onenightcar.model.person.Customer;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    private List<RentalTimeSlot> timeSlotsList;

    /* /////////////////////Constructors/////////////////////////// */

    // Needed to be able to create the entity
    protected ElectricRental() {}

    /**
     * Creates a OneNightCar.Rental entry for a rental of an electric OneNightCar.Car
     * @param electricCar the car itself, object of the class ElectricCar
     * @param rentalDate the date of the rental
     * @param customer Who is making the rental
     * @param timeSlotsList which timeslots are being used
     */
    public ElectricRental(ElectricCar electricCar, LocalDate rentalDate, Customer customer, List<RentalTimeSlot> timeSlotsList){
        super(rentalDate, customer);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
        this.electricCar = electricCar;
        this.timeSlotsList = timeSlotsList;
        //add this Rental to the given timeslots
        this.timeSlotsList = timeSlotsList;
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
    }

    /**
     * A constructor that uses default values
     * @param electricCar the car itself, object of the class ElectricCar
     * @param customer A Customer Object
     */
    public ElectricRental(ElectricCar electricCar, Customer customer){
        super(customer);
        this.odometerBefore = electricCar.getOdometer();
        this.chargePercentBefore = electricCar.getChargePercent();
        this.electricCar = electricCar;
        this.timeSlotsList = new ArrayList<>();
        LocalTime lt1 = LocalTime.of(8,0);
        LocalTime lt2 = LocalTime.of(9,0);
        this.timeSlotsList.add(new RentalTimeSlot(lt1, lt2));
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    public float getChargePercentAfter() { return this.chargePercentAfter; }

    /** Sets the charge of the electric car after the rental
     * @param electricCar the rented electric car
     */
    public void setChargePercentAfter (ElectricCar electricCar) {
        if ((this.odometerAfter - this.odometerBefore) > electricCar.getElectricalRange()) {
            this.chargePercentAfter = 0;
        }
        else {
            this.chargePercentAfter = (electricCar.getElectricalRange() - (this.odometerAfter - this.odometerBefore)) / electricCar.getElectricalRange();
        }
    }


    public void setElectricCar(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    public List<RentalTimeSlot> getTimeSlotsList() {
        return timeSlotsList;
    }

    /* /////////////////////Methods/////////////////////////// */

    public int calculateElapsedHours() {
        return this.timeSlotsList.size();
    }

    private float calculateRentalPriceForElectric(ElectricCar ElectricCar) {
        return calculateElapsedHours() * ElectricCar.getPrice();
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

    public ElectricCar getElectricCar() {
        try {
            return this.electricCar;
        }
        catch(Exception e){
            System.out.print("Electric Car doesn't exist!");
            return electricCar;                               //edit return
        }
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "ElectricRental{" +
                "rentalPrice=" + rentalPrice +
                ", odometerBefore=" + odometerBefore +
                ", odometerAfter=" + odometerAfter +
                ", date=" + rentalDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElectricRental that = (ElectricRental) o;

        if (Float.compare(that.chargePercentBefore, chargePercentBefore) != 0) return false;
        if (Float.compare(that.chargePercentAfter, chargePercentAfter) != 0) return false;
        if (electricCar != null ? !electricCar.equals(that.electricCar) : that.electricCar != null) return false;
        return timeSlotsList != null ? timeSlotsList.equals(that.timeSlotsList) : that.timeSlotsList == null;
    }

    @Override
    public int hashCode() {
        int result = (chargePercentBefore != +0.0f ? Float.floatToIntBits(chargePercentBefore) : 0);
        result = 31 * result + (chargePercentAfter != +0.0f ? Float.floatToIntBits(chargePercentAfter) : 0);
        result = 31 * result + (electricCar != null ? electricCar.hashCode() : 0);
        result = 31 * result + (timeSlotsList != null ? timeSlotsList.hashCode() : 0);
        return result;
    }
}
