package de.onenightcar.domain.model.person;


import de.onenightcar.domain.model.rental.*;
import de.onenightcar.domain.model.car.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/** Represents a PaymentMethod
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class Customer extends Person {

    /* /////////////////////Attributes///////////////////////// */

    public ArrayList<FuelRental> fuelRentals;
    public ArrayList<ElectricRental> electricRentals;
    private int customerID;
    private CustomerLevel customerLevel;
    private PaymentMethod paymentMethod;
    /** Creates a Customer with specified Customer Parameters.
     * @param firstName A String representing Customers first Name
     * @param surname A String representing Customers Surname
     * @param dateOfBirth A GregorianCalendar representing Customers DOB
     * @param personAddress A PersonAddress representing Customers Address
     * @param personManager A PersonManager with the management from the Packet OneNightCar.Person
     * @param customerLevel A CustomerLevel representing Customers Level
     * @param paymentMethod A PaymentMethod representing Customers Payment Method
     */
    public Customer(String firstName, String surname, GregorianCalendar dateOfBirth, PersonAddress personAddress,
                    PersonManager personManager, CustomerLevel customerLevel, PaymentMethod paymentMethod){
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.personAddress = personAddress;
        this.customerID = personManager.getAndIncrementCustomerCounter();
        personManager.customers.add(this);                               //Adds this Customer to the Customer List
        this.customerLevel = customerLevel;
        this.paymentMethod = paymentMethod;
        this.fuelRentals = new ArrayList<FuelRental>();
        this.electricRentals = new ArrayList<ElectricRental>();
    }


    /* /////////////////////Methods/////////////////////////// */

    /** Creates a Customer with default Values.
     * It is used to increment speed of UnitTests.
     * @param personManager A PersonManager with the management from the Packet OneNightCar.Person
     */
    public Customer(PersonManager personManager){
        this.firstName = "Max";
        this.surname = "Mustermann";
        this.dateOfBirth = new GregorianCalendar(1990,GregorianCalendar.DECEMBER,31);
        this.personAddress = new PersonAddress();
        this.customerID = personManager.getAndIncrementCustomerCounter();
        personManager.customers.add(this);                               //Adds this Customer to the Customer List
        this.customerLevel = CustomerLevel.REGULARUSER;
        this.paymentMethod = new PaymentMethod();
        this.fuelRentals = new ArrayList<FuelRental>();
        this.electricRentals = new ArrayList<ElectricRental>();
    }

    /** Gets the Customers ID.
     * @return A int representing ID of a Customer
     */
    public int getCustomerID(){
        return this.customerID;
    }

    /** Gets the Customer Level.
     * @return A CustomerLevel representing Level of a Customer
     */
    public CustomerLevel getCustomerLevel(){
        return this.customerLevel;
    }

    /** Sets the Customer Level.
     * @param customerLevel a CustomerLevel representing the Customer Level
     */
    public void setCustomerLevel(CustomerLevel customerLevel){
        this.customerLevel = customerLevel;
    }

    /** Gets the Electric Rentals.
     * @return An ArrayList representing Electric Rentals
     */
    public ArrayList getElectricRentals(){
        return this.electricRentals;
    }

    /** Gets the Electric OneNightCar.Rental with index.
     * @param index an int index
     * @return An ElectricRental with given index
     */
    public ElectricRental getElectricRentalWithIndex(int index){
        return this.electricRentals.get(index);
    }

    /** Gets the Fuel Rentals.
     * @return An ArrayList representing Fuel Rentals
     */
    public ArrayList getFuelRentals(){
        return this.fuelRentals;
    }

    /** Gets the Fuel OneNightCar.Rental with index.
     * @param index an int index
     * @return A FuelRental with given index
     */
    public FuelRental getFuelRentalWithIndex(int index){
        return this.fuelRentals.get(index);
    }

    /** Gets the Customer Payment Method.
     * @return A PaymentMethod representing Payment Method of a Customer
     */
    public PaymentMethod getPaymentMethod(){
        return this.paymentMethod;
    }

    /** Sets the Customers Payment Method.
     * @param paymentMethod a PaymentMethod representing the Customers Payment Method
     */
    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    /** Represents the situation in which the customer needs Support from an Employee
     * @param employee which employee is going to help this customer
     * @return a boolean
     */
    public boolean customerNeedHelp(Employee employee){
        if(employee.employeeHelpsCustomer()){
            // Issue was easily solved
            return true;
        }
        else{
            // The admin has to intervene and help
            Admin.resolveProblem();
            return true;
        }
    }

    /** Function: retrieve the current index from an electric car in the Electric OneNightCar.Rental list (Needed to Delete or Modify Rentals)
     * @param electricCar an ElectricCar representing the OneNightCar.Car
     * @return An int representing the index on the List, if not found, returns -1
     */
    public int getElectricCarIndexInElectricRentalList(ElectricCar electricCar){
        for (int indexInList = 0; indexInList < electricRentals.size(); indexInList ++)
            if(electricRentals.get(indexInList).getElectricCar() == electricCar){
                return indexInList;
            }
        return -1;
    }

    /** Function: retrieve the current index from a combustion car in the Fuel OneNightCar.Rental list (Needed to Delete or Modify Rentals)
     * @param combustionCar a CombustionCar representing the OneNightCar.Car
     * @return An int representing the index on the List
     */
    public int getCombustionCarIndexInFuelRentalList(CombustionCar combustionCar){
        for (int indexInList = 0; indexInList < fuelRentals.size(); indexInList ++)
            if(fuelRentals.get(indexInList).getCombustionCar() == combustionCar){
                return indexInList;
            }
        return -1;
    }

    /**
     * Creates a new Electric OneNightCar.Rental of a Vehicle and this Customer
     * @param electricCar   an ElectricCar representing an electric car the Customer wants to book
     * @param date          a LocalDate representing the date of the Booking
     * @param carManagementSystem in order to know the carID of the car
     * @param yearDeparture Int representing the departure year
     * @param monthDeparture int representing the departure month
     * @param dayDeparture int representing the departure day
     * @param yearArrival Int representing the arrival year
     * @param monthArrival int representing the arrival month
     * @param dayArrival int representing the arrival day
     * @param rentalManager to add this rental to all the rentals
     */
    public void rentAnElectricCar(ElectricCar electricCar, CarManagementSystem carManagementSystem, LocalDate date,
                                  int yearDeparture, int monthDeparture, int dayDeparture, int yearArrival ,
                                  int monthArrival, int dayArrival, RentalManager rentalManager) {
        ElectricRental electricRental = new ElectricRental(electricCar, carManagementSystem, this.customerID, date,
                                                            yearDeparture, monthDeparture, dayDeparture, yearArrival ,
                                                            monthArrival, dayArrival, rentalManager);
        this.electricRentals.add(electricRental);
    }

    /** Ask permission to Admin to Modify an existing Electrical OneNightCar.Rental made by this Customer
     * @param electricRental the OneNightCar.Rental that wants to be modified
     * @param date          a LocalDate representing the date of the Booking
     * @param yearDeparture Int representing the new departure year
     * @param monthDeparture int representing the new departure month
     * @param dayDeparture int representing the new departure day
     * @param yearArrival Int representing the new arrival year
     * @param monthArrival int representing the new arrival month
     * @param dayArrival int representing the new arrival day
     * @param rentalManager to add this rental to all the rentals
     * @param carManagementSystem the system where all cars are saved
     * @param electricCar which electric car rental is being modified
     */
    public void modifyAnElectricRental(ElectricRental electricRental, ElectricCar electricCar, CarManagementSystem carManagementSystem,
                                    LocalDate date, int yearDeparture,int monthDeparture,int dayDeparture, int yearArrival ,
                                    int monthArrival, int dayArrival, RentalManager rentalManager) {
        if (electricRental.getCustomerID() == this.customerID){
            if (Admin.approveRentalModification(electricRental) == true){
                ElectricRental newElectricRental = new ElectricRental(electricCar, carManagementSystem, this.customerID, date,
                                                                    yearDeparture, monthDeparture, dayDeparture, yearArrival,
                                                                    monthArrival, dayArrival, rentalManager);
                // Remove the old OneNightCar.Rental
                this.electricRentals.remove(electricRental);
                // Add the new OneNightCar.Rental
                this.electricRentals.add(newElectricRental);
            }
        }
    }

    /** Ask the Admin to Cancel an existing Electrical OneNightCar.Rental made by this Customer
     * @param electricRental an ElectricRental representing which OneNightCar.Rental is being cancelled
     */
    public void cancelElectricRental(ElectricRental electricRental){
        if (electricRental.getCustomerID() == this.customerID){
            if (Admin.approveRentalModification(electricRental) == true){
                this.electricRentals.remove(electricRental);
                Admin.deleteElectricRental(electricRental);
            }
        }
    }

    /**
     * Creates a new OneNightCar.Rental of a Vehicle and this Customer
     * @param combustionCar   an CombustionCar representing the car the Customer wants to book
     * @param date          a LocalDate representing the date of the Booking
     * @param carManagementSystem in order to know the carID of the car
     * @param yearDeparture Int representing the departure year
     * @param monthDeparture int representing the departure month
     * @param dayDeparture int representing the departure day
     * @param yearArrival Int representing the arrival year
     * @param monthArrival int representing the arrival month
     * @param dayArrival int representing the arrival day
     * @param rentalManager to add this rental to all the rentals
     */
     public void rentAFuelCar(RentalManager rentalManager, CombustionCar combustionCar, CarManagementSystem carManagementSystem,
                              LocalDate date, int yearDeparture,int monthDeparture,int dayDeparture, int yearArrival,
                              int monthArrival, int dayArrival) {
         FuelRental fuelRental = new FuelRental(rentalManager, combustionCar, carManagementSystem,
                                                this.getCustomerID(), date, yearDeparture, monthDeparture, dayDeparture,
                                                yearArrival, monthArrival, dayArrival);
         this.fuelRentals.add(fuelRental);
     }

    /** Ask permission to Admin to Modify an existing Electrical OneNightCar.Rental made by this Customer
     * @param fuelRental the OneNightCar.Rental that wants to be modified
     * @param date          a LocalDate representing the date of the Booking
     * @param yearDeparture Int representing the new departure year
     * @param monthDeparture int representing the new departure month
     * @param dayDeparture int representing the new departure day
     * @param yearArrival Int representing the new arrival year
     * @param monthArrival int representing the new arrival month
     * @param dayArrival int representing the new arrival day
     * @param rentalManager to add this rental to all the rentals
     * @param carManagementSystem the system where all cars are saved
     * @param combustionCar which cars OneNightCar.Rental need to be modified
     */
    public void modifyARegularRental(FuelRental fuelRental, RentalManager rentalManager, CombustionCar combustionCar, CarManagementSystem carManagementSystem,
                                     LocalDate date, int yearDeparture,int monthDeparture,int dayDeparture, int yearArrival,
                                     int monthArrival, int dayArrival) {
        if (fuelRental.getCustomerID() == this.customerID){
            if (Admin.approveRentalModification(fuelRental) == true){
                FuelRental newFuelRental = new FuelRental(rentalManager, combustionCar, carManagementSystem,
                                                this.customerID, date, yearDeparture, monthDeparture, dayDeparture,
                                                            yearArrival, monthArrival, dayArrival);
                // Remove the old OneNightCar.Rental
                this.fuelRentals.remove(fuelRental);
                // Add the new OneNightCar.Rental
                this.fuelRentals.add(newFuelRental);
            }
        }
    }

    /** Ask the Admin to Cancel an existing Fuel OneNightCar.Rental made by this Customer
     * @param fuelRental an ElectricRental representing which OneNightCar.Rental is being cancelled
     */
    public void cancelFuelRental(FuelRental fuelRental){
        if (fuelRental.getCustomerID() == this.customerID){
            if (Admin.approveRentalModification(fuelRental) == true){
                this.fuelRentals.remove(fuelRental);
                Admin.deleteFuelRental(fuelRental);
            }
//            this.fuelRentals.remove(fuelRental);
        }
    }

    /** Simulates the Situation in which a customer damages an Electric OneNightCar.Car
     * @param electricCar the OneNightCar.Car that was Damaged
     */
    public void customerDamagesAnElectricCar(ElectricCar electricCar){
        electricCar.changeCarState(Car.State.DAMAGED);
    }

    /** Simulates the Situation in which a customer damages an Electric OneNightCar.Car
     * @param combustionCar the OneNightCar.Car that was Damaged
     */
    public void customerDamagesAFuelCar(CombustionCar combustionCar){
        combustionCar.changeCarState(Car.State.DAMAGED);
    }

    public enum CustomerLevel {
        NEWUSER,
        REGULARUSER,
        SUPERUSER
    }
}
