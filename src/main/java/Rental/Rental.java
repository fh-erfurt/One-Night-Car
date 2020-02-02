package Rental;

import Car.CarManagementSystem;
import Car.ElectricCar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/** Represents a rental entry
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
  */

public abstract class Rental {
    /* /////////////////////Attributes///////////////////////// */

    protected int rentalID;
    protected int carID;
    protected int customerID;
    protected float rentalPrice;
    protected long odometerBefore;
    protected long odometerAfter = 0;
    LocalDate date;
    GregorianCalendar departureTime;
    GregorianCalendar arrivalTime;

    /* /////////////////////Methods/////////////////////////// */

    /** Creates a Rental entry for a rental
     * @param date the date of the rental
     * @param yearDeparture  the time at which the customer started the rental
     * @param monthDeparture  the time at which the customer started the rental
     * @param dayDeparture  the time at which the customer started the rental
     * @param yearArrival the time at which he has returned
     * @param monthArrival the time at which he has returned
     * @param dayArrival the time at which he has returned
     * @param customerID the Customer ID
     */
    public Rental(int customerID, LocalDate date, int yearDeparture, int monthDeparture, int dayDeparture,
                          int yearArrival , int monthArrival, int dayArrival){
        this.customerID = customerID;
        this.date = date;
        this.departureTime = new GregorianCalendar(yearDeparture, monthDeparture, dayDeparture);
        this.arrivalTime = new GregorianCalendar(yearArrival, monthArrival, dayArrival);
    }

    /** Default Constructor for Rental
     */
    public Rental(){
        this.date = LocalDate.now();
        this.departureTime = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        this.arrivalTime = new GregorianCalendar(2020, Calendar.DECEMBER, 31);
    }

    /** Calculates the duration of a rental
     * @return the total amount of hours the rental has lasted
     */
    int calculateElapsedDays(){
          return Math.abs(arrivalTime.get(Calendar.DAY_OF_YEAR) - departureTime.get(Calendar.DAY_OF_YEAR));
    }

    /** Sets the odometer to the value after the rental
     */
    public void setOdometerAfter(){
        this.odometerAfter = odometerBefore + ((calculateElapsedDays() * 24) * 32); //Calculates the driven amount of kilometres by using the average speed of a car in Munich (as it can't be inspected)
    }

    /** Gets the odometer after the rental
     * @return the odometer after the rental
     */
    public long getOdometerAfter(){
        return this.odometerAfter;
    }

    /** Gets the carID
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

    public GregorianCalendar getDepartureTime () {return this.departureTime;}

    public GregorianCalendar getArrivalTime () {return this.arrivalTime;}

}