package de.onenightcar.controller.formValidators;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CarSearchForm {
    private String city;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    //Fuel Type: 0->Any // 1-> Combustion // 2->Electric
    private int fuel = 0;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
