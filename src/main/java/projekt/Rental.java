package projekt;

import java.sql.Time;
import java.util.Date;
import java.lang.Math;

public class Rental {
    /* /////////////////////Attributes///////////////////////// */

    private int rentalID;
    private int carID;
    private int customerID;
    private float rentalPrice;
    private long odometerBefore;
    private long odometerAfter = 0;
    private Date date;
    private Time departureTime;
    private Time arrivalTime;

    /* /////////////////////Methods/////////////////////////// */

    public Rental(Car car, int customerID, Date date, Time departureTime, Time arrivalTime, List list){
        rentalID = list.getSizeOfRentalsID();            //Creates a running counter of Rentals in list
        list.rentalsID.add(rentalID);                   //Adds the new rental to the global list
        this.carID = car.getCarID();
        this.customerID = customerID;
        this.rentalPrice = calculateElapsedHours() * car.getPrice();
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.odometerBefore = car.getOdometer();
    }


    public int calculateElapsedHours(){
        double elapsedHoursDouble = Math.ceil(((this.arrivalTime.getTime() - this.departureTime.getTime()) / 3600000));
        int elapsedHoursFloat = (int) elapsedHoursDouble;
        return elapsedHoursFloat;
    }

    public void setOdometerAfter(){
        this.odometerAfter = odometerBefore + (calculateElapsedHours() * 45); //Just an easy way to increment our Odometer, may be changed
    }


    public long getOdometerAfter(){
        return this.odometerAfter;
    }
}
