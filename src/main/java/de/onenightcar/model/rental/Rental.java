package de.onenightcar.model.rental;

import de.onenightcar.model.person.Customer;
import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    //In which date the Rental is going to take place
    protected LocalDate rentalDate;

    @ManyToOne
    protected Customer customer;

    /* /////////////////////Constructors/////////////////////////// */

    // Needed to be able to create the entity
    protected Rental() {}

    /** Creates a OneNightCar.Rental entry for a rental
     * @param date the date and time of the booking
     * @param customer a Customer who made the rental
     */

    protected Rental(LocalDate date, Customer customer){
        this.customer = customer;
        this.rentalDate = date;
    }

    /** Default Constructor for OneNightCar.Rental
     * @param customer a Customer Object
     */
    protected Rental(Customer customer){
        this.customer = customer;
        this.rentalDate = LocalDate.now();
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }


    public long getOdometerAfter() {
        return odometerAfter;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}