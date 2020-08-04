package de.onenightcar.controller.formValidators;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;

public class FuelRentalFormValidator {

    @NotNull (message = "Not valid value")
    private Long fuelCarId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent (message = "Not valid date")
    private LocalDate date;

    @NotNull (message = "Not valid value")
    private Long customerId;

    @NotEmpty (message = "Not valid value")
    private Long[] timeSlotsListId;

    public Long getFuelCarId() {
        return fuelCarId;
    }

    public void setFuelCarId(Long fuelCarId) {
        this.fuelCarId = fuelCarId;
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
        return "FuelRentalFormValidator{" +
                "fuelCarId=" + fuelCarId +
                ", date=" + date +
                ", customerId=" + customerId +
                ", timeSlotsListId=" + Arrays.toString(timeSlotsListId) +
                '}';
    }
}
