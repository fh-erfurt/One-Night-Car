package de.onenightcar.model.rental;

import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.time.LocalTime;
import java.util.List;

/** Represents a Time Slots
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */


@Entity
public class RentalTimeSlot extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @ManyToMany(mappedBy = "timeSlotsList")
    private List<FuelRental> fuelRental;

    @ManyToMany(mappedBy = "timeSlotsList")
    private List<ElectricRental> electricRental;

    /* /////////////////////Constructors/////////////////////////// */

    public RentalTimeSlot() {
    }
    /**
     * Creates a OneNightCar.Rental entry for a rental of an electric OneNightCar.Car
     * @param departureTime the Departure Time of the wanted rental
     * @param arrivalTime the Arrival Time of the planned Rental
     */
    public RentalTimeSlot(LocalTime departureTime, LocalTime arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<FuelRental> getFuelRental() {
        return fuelRental;
    }

    public void setFuelRental(List<FuelRental> fuelRental) {
        this.fuelRental = fuelRental;
    }

    public List<ElectricRental> getElectricRental() {
        return electricRental;
    }

    public void setElectricRental(List<ElectricRental> electricRental) {
        this.electricRental = electricRental;
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "RentalTimeSlot{" +
                "departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", fuelRental=" + fuelRental +
                ", electricRental=" + electricRental +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalTimeSlot that = (RentalTimeSlot) o;

        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        if (fuelRental != null ? !fuelRental.equals(that.fuelRental) : that.fuelRental != null) return false;
        return electricRental != null ? electricRental.equals(that.electricRental) : that.electricRental == null;
    }

    @Override
    public int hashCode() {
        int result = departureTime != null ? departureTime.hashCode() : 0;
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (fuelRental != null ? fuelRental.hashCode() : 0);
        result = 31 * result + (electricRental != null ? electricRental.hashCode() : 0);
        return result;
    }
}
