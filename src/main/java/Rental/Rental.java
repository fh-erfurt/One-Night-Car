package Rental;

import java.time.LocalDate;
import java.time.LocalDateTime;


/** Represents a rental entry
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
  */
public abstract class Rental {
    /* /////////////////////Attributes///////////////////////// */
    int rentalID;
    int carID;
    int customerID;
    float rentalPrice;
    long odometerBefore;
    long odometerAfter = 0;
    LocalDate date;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;



    /* /////////////////////Methods/////////////////////////// */

    /** Calculates the duration of a rental
     * @return the total amount of hours the rental has lasted
     */
    int calculateElapsedDays(){
        return this.arrivalTime.getDayOfYear() - this.departureTime.getDayOfYear();
    }

    /** Sets the odometer to the value after the rental
     *
     */
    public void setOdometerAfter(){
        this.odometerAfter = odometerBefore + ((calculateElapsedDays() / 24) * 32); //Calculates the driven amount of kilometres by using the average speed of a car in Munich (as it can't be inspected)
    }

    /** Gets the odometer after the rental
     *
     * @return the odometer after the rental
     */
    public long getOdometerAfter(){
        return this.odometerAfter;
    }

    /** Gets the carID
     *
     * @return the carID
     */
    public int getCarID() {
        return this.carID;
    }

    public int getRentalID () {
        return this.rentalID;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public LocalDate getDate () {
        return this.date;
    }

}