package de.onenightcar.controller.formValidators;

import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.RentalTimeSlot;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class ElectricRentalFormValidator {

    @NotNull
    private ElectricCar electricCar;

    @NotNull
    private LocalDate date;

    @NotNull
    private Customer customer;

    @NotNull
    private List<RentalTimeSlot> timeSlotsList;

    public ElectricRentalFormValidator(ElectricCar electricCar, LocalDate date, Customer customer, List<RentalTimeSlot> timeSlotsList) {
        this.electricCar = electricCar;
        this.date = date;
        this.customer = customer;
        this.timeSlotsList = timeSlotsList;
    }

    public ElectricCar getElectricCar() {
        return electricCar;
    }

    public void setElectricCar(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<RentalTimeSlot> getTimeSlotsList() {
        return timeSlotsList;
    }

    public void setTimeSlotsList(List<RentalTimeSlot> timeSlotsList) {
        this.timeSlotsList = timeSlotsList;
    }

    @Override
    public String toString() {
        return "ElectricRentalFormValidator{" +
                "electricCar=" + electricCar +
                ", date=" + date +
                ", customer=" + customer +
                ", timeSlotsList=" + timeSlotsList +
                '}';
    }
}
