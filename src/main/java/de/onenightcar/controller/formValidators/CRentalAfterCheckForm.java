package de.onenightcar.controller.formValidators;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.RentalTimeSlot;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class CRentalAfterCheckForm {
    @NotNull (message = "Not valid value")
    private long combustionCar;

    @NotNull (message = "Not valid value")
    private long customer;

    @NotNull (message = "Not valid value")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @NotNull (message = "Not valid value")
    private Long[] rentalTimeSlots;

    public long getCombustionCar() {
        return combustionCar;
    }

    public void setCombustionCar(long combustionCar) {
        this.combustionCar = combustionCar;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Long[] getRentalTimeSlots() {
        return rentalTimeSlots;
    }

    public void setRentalTimeSlots(Long[] rentalTimeSlots) {
        this.rentalTimeSlots = rentalTimeSlots;
    }
}
