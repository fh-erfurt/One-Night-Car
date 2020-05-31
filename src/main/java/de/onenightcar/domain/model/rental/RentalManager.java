package de.onenightcar.domain.model.rental;

import java.util.ArrayList;

public class RentalManager {
    /* /////////////////////Attributes///////////////////////// */
    private ArrayList<ElectricRental> ElectricRentals;
    private ArrayList<FuelRental> FuelRentals;
    private int  RentalCounter;
    /* /////////////////////Methods/////////////////////////// */

    /**
     * Creates a RentalManager with empty lists and the initial counter of 1
     */
    public RentalManager(){
        this.ElectricRentals = new ArrayList<ElectricRental>();
        this.FuelRentals = new ArrayList<FuelRental>();
        this.RentalCounter = 1;
    }
    /**
     * Gets the current counter of Rentals and increments it after returning the value
     * @return The current counter of Rentals
     */
    public int getAndIncrementCounter (){
        return this.RentalCounter++;
    }

    /**
     * Adds a OneNightCar.Rental object to the global list
     */
    public void addRentalIntoElectricRentals (ElectricRental ElectricRental) { ElectricRentals.add(ElectricRental); }

    /**
     * Adds a OneNightCar.Rental object to the global list
     */
    public void addRentalIntoFuelRentals (FuelRental FuelRental) { FuelRentals.add(FuelRental); }

    /**
     * Removes a OneNightCar.Rental object from the global List
     */
    public void removeRentalFromElectricsRentals (ElectricRental ElectricRental){
        ElectricRentals.remove(ElectricRental);
        this.RentalCounter--;
    }

    /**
     * Removes a OneNightCar.Rental object from the global list
     */
    public void removeRentalFromFuelRentals (FuelRental FuelRental) {
        FuelRentals.remove(FuelRental);
        this.RentalCounter--;
    }

    /**
     * Returns the current amount of Rentals in the global list of Electric Rentals
     * @return the size of the global list
     */
    public int getSizeOfElectricRentals (){
        return this.ElectricRentals.size();
    }

    /**
     * Returns the current amount of Rentals in the global List of Fuel Rentals
     * @return the size of the global list
     */
    public int getSizeOfFuelRentals(){
        return this.FuelRentals.size();
    }

    /**
     * Returns the RentalID of the Electric OneNightCar.Rental
     * @return the RentalID of the OneNightCar.Rental
     */
    public int getRentalIDFromElectricRentals (ElectricRental ElectricRental){
        return ElectricRental.rentalID;
    }

    /**
     * Returns the RentalID of the Fuel OneNightCar.Rental
     * @return the RentalID of the OneNightCar.Rental
     */
    public int getRentalIDFromFuelRentals (FuelRental FuelRental){
        return FuelRental.rentalID;
    }

    /**
     * Returns the Index of a OneNightCar.Rental in the global list
     * @return the index of an electric OneNightCar.Rental in the global list
     */
    public int returnElectricRentalWithIndex (ElectricRental ElectricRental){
        return this.ElectricRentals.indexOf(ElectricRental);
    }

    /**
     * Returns the Index of a OneNightCar.Rental in the global list
     * @return the index of a fuel rental in the global list
     */
    public int returnFuelRentalWithIndex (FuelRental FuelRental){
        return this.FuelRentals.indexOf(FuelRental);
    }
}

