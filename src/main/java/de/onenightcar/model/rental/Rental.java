package de.onenightcar.model.rental;

import de.onenightcar.model.person.Customer;
import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;


/** Represents a rental entry
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
  */

@MappedSuperclass
public abstract class Rental extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    protected float rentalPrice;
    protected long odometerBefore;
    protected long odometerAfter = 0;
    protected LocalDateTime date;
    protected LocalDateTime departure;
    protected LocalDateTime arrival;

    @ManyToOne
    protected Customer customer;

    /* /////////////////////Constructors/////////////////////////// */

    // Needed to be able to create the entity
    protected Rental() {}

    /** Creates a OneNightCar.Rental entry for a rental
     * @param date the date and time of the booking
     * @param departure the date and time at which the customer started the rental
     * @param arrival  the date and time at which the customer ended the rental
     */
    protected Rental(LocalDateTime date, LocalDateTime departure,
                          LocalDateTime arrival, Customer customer){
        this.customer = customer;
        this.date = date;
        this.departure = departure;
        this.arrival = arrival;
    }

    /** Default Constructor for OneNightCar.Rental
     */
    protected Rental(Customer customer){
        this.customer = customer;
        this.date = LocalDateTime.now();
        this.departure = LocalDateTime.now();
        this.arrival = departure.plusWeeks(1);
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public long getOdometerBefore() {
        return odometerBefore;
    }

    public void setOdometerBefore(long odometerBefore) {
        this.odometerBefore = odometerBefore;
    }

    public long getOdometerAfter() {
        return odometerAfter;
    }

    public void setOdometerAfter(long odometerAfter) {
        this.odometerAfter = odometerAfter;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /* /////////////////////Methods/////////////////////////// */

    /** Calculates the duration of a rental
     * @return the total amount of hours the rental has lasted
     */
    public long calculateElapsedDays(){
        return departure.until(arrival, DAYS);
    }

    /** Sets the odometer to the value after the rental
     * Based on a simulated drive
     */
    public void setOdometerAfter(){
        try {
            this.odometerAfter = odometerBefore + ((calculateElapsedDays() * 24) * 32); //Calculates the driven amount of kilometres by using the average speed of a car in Munich (as it can't be inspected)
        }
        catch(Exception e){
            System.out.print(e + "Set Odometer has failed!");
        }
    }

    /* /////////////////////Overrides/////////////////////////// */

}