package de.onenightcar.controller.formValidators;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.RentalTimeSlot;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class ERentalAfterCheckForm {

    private long electricCar;

    private long customer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    private Long[] rentalTimeSlots;

    public long getElectricCar() {
        return electricCar;
    }

    public void setElectricCar(long electricCar) {
        this.electricCar = electricCar;
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
