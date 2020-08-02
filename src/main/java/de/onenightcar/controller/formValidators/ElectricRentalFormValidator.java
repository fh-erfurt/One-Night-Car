package de.onenightcar.controller.formValidators;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Customer;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;

public class ElectricRentalFormValidator {

    @NotNull
    private Long electricCarId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    private Long customerId;

    @NotNull
    private Long[] timeSlotsListId;

    public Long getElectricCarId() {
        return electricCarId;
    }

    public void setElectricCarId(Long electricCarId) {
        this.electricCarId = electricCarId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long[] getTimeSlotsListId() {
        return timeSlotsListId;
    }

    public void setTimeSlotsListId(Long[] timeSlotsList) {
        this.timeSlotsListId = timeSlotsList;
    }

    @Override
    public String toString() {
        return "ElectricRentalFormValidator{" +
                "electricCarId=" + electricCarId +
                ", date=" + date +
                ", customerId=" + customerId +
                ", timeSlotsListId=" + Arrays.toString(timeSlotsListId) +
                '}';
    }
}
