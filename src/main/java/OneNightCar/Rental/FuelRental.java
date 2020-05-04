package OneNightCar.Rental;

import OneNightCar.Car.CombustionCar;
import OneNightCar.Car.CarManagementSystem;
import OneNightCar.Person.PersonManager;


import java.time.LocalDate;

/** Represents a FuelRental
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class FuelRental extends Rental {
    /* /////////////////////Attributes///////////////////////// */

    private double fuelLevelBefore;
    private double fuelLevelAfter;
    private CombustionCar combustionCar;

    /* /////////////////////Methods/////////////////////////// */
    /** Creates a rental entry with parameters for a combustion car
     * * @param rentalID An integer value used to identify certain rental entries
     * * @param carID An integer value used to identify certain cars inside a rental entry
     * * @param customerID An integer value used to identify certain customers inside a rental entry
     * * @param rentalPrice The total price of a rental
     * * @param odometerBefore The value on the odometer of a car before the rental
     * * @param odometerAfter  The value on the odometer of a car after the rental
     * @param date The date a rental has been created
     * @param yearDeparture  the time at which the customer started the rental
     * @param monthDeparture  the time at which the customer started the rental
     * @param dayDeparture  the time at which the customer started the rental
     * @param yearArrival the time at which he has returned
     * @param monthArrival the time at which he has returned
     * @param dayArrival the time at which he has returned
     * @param combustionCar a Combustion OneNightCar.Car
     * @param carManagementSystem where all cars are saved
     * @param customerID which customer is making the OneNightCar.Rental
     * @param rentalManager where all rental are saved
     */
    public FuelRental(RentalManager rentalManager, CombustionCar combustionCar, CarManagementSystem carManagementSystem, int customerID, LocalDate date,
                      int yearDeparture,int monthDeparture,int dayDeparture, int yearArrival ,int monthArrival, int dayArrival){
        super(customerID, date, yearDeparture, monthDeparture, dayDeparture, yearArrival , monthArrival, dayArrival);
        rentalID = rentalManager.getSizeOfFuelRentals();                          //Creates a running counter of Rentals in list
        rentalManager.addRentalIntoFuelRentals(this);                          //Adds the new rental to the global list
        this.carID = carManagementSystem.getCarIDFromCombustion(combustionCar);
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = combustionCar.getFuelLevel();
        this.combustionCar = combustionCar;
    }

    /**
     * A constructor that uses default values
     * @param rentalManager the management system needed to add the entry to the global list
     * @param carManagementSystem the management system, so we can get information about the car
     * @param customerID an Int representing the customers ID
     * @param combustionCar the car itself, object of the class ElectricCar
     * @param date at what time was the rental made
     * @param personManager where all persons are saved
     */
    public FuelRental(RentalManager rentalManager, CarManagementSystem carManagementSystem, int customerID, LocalDate date,
                      CombustionCar combustionCar, PersonManager personManager){
        super();
        this.rentalID = rentalManager.getSizeOfFuelRentals();
        rentalManager.addRentalIntoFuelRentals(this);
        this.carID = carManagementSystem.getCarIDFromCombustion(combustionCar);
        this.customerID = customerID;
        this.rentalPrice = calculateRentalPriceForCombustion(combustionCar);
        this.odometerBefore = combustionCar.getOdometer();
        this.fuelLevelBefore = combustionCar.getFuelLevel();
        this.fuelLevelAfter = getFuelLevelAfter();
        this.combustionCar = combustionCar;
    }

    public double getFuelLevelAfter(){
        return this.fuelLevelAfter;
    }

    /** Sets the fuelLevel after the rental of the car
     * @param CombustionCar The car that has been rented
     */
    public void setFuelLevelAfter (CombustionCar CombustionCar) {
        if (CombustionCar.getConsumption() * (this.odometerAfter - this.odometerBefore) > CombustionCar.getTankSize()){
            this.fuelLevelAfter = -1;
        }
        else {
            this.fuelLevelAfter = CombustionCar.getFuelLevel() - (CombustionCar.getConsumption() * (this.odometerAfter - this.odometerBefore)) / CombustionCar.getFuelLevel();
        }
    }

    /**
     * Takes the price of a car and multiplies it with the elapsed hours
     * @param CombustionCar is the car rented by the customer
     * @return the total price of the rental
     */
    public float calculateRentalPriceForCombustion (CombustionCar CombustionCar) {
        float rentalPrice = calculateElapsedDays() * CombustionCar.getPrice();
        return rentalPrice;
    }

    public CombustionCar getCombustionCar() { return this.combustionCar; }
}
