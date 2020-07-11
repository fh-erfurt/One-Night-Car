package de.onenightcar.model.rental;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Customer;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private float chargePercentBefore;
    private float chargePercentAfter;

    @OneToOne
    private ElectricCar electricCar;

    @OneToMany(mappedBy = "electricRental")
    private List<RentalTimeSlot> timeSlotsList = new ArrayList<>();

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
        for(int i = 0; i < timeSlotsList.size(); i++) {
            this.timeSlotsList.get(i).setElectricRental(this);
        }
        this.rentalPrice = calculateRentalPriceForElectric(electricCar);
    }

    /**
     * A constructor that uses default values
     * @param electricCar the car itself, object of the class ElectricCar
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

    public float getChargePercentBefore() {
        return chargePercentBefore;
    }

    public void setChargePercentBefore(float chargePercentBefore) {
        this.chargePercentBefore = chargePercentBefore;
    }

    public void setChargePercentAfter(float chargePercentAfter) {
        this.chargePercentAfter = chargePercentAfter;
    }

    public void setElectricCar(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    public List<RentalTimeSlot> getTimeSlotsList() {
        return timeSlotsList;
    }

    public void setTimeSlotsList(List<RentalTimeSlot> timeSlotsList) {
        this.timeSlotsList = timeSlotsList;
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
}
