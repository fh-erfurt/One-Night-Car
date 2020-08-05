package de.onenightcar.model.person;


import de.onenightcar.model.rental.*;
import de.onenightcar.model.car.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/** Represents a PaymentMethod
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

@Entity
public class Customer extends Person {

    /* /////////////////////Attributes///////////////////////// */

    @OneToMany
    public List<FuelRental> fuelRentals = new ArrayList<>();

    @OneToMany
    public List<ElectricRental> electricRentals = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private CustomerLevel customerLevel;

    @OneToOne
    private PaymentMethod paymentMethod;

    /* /////////////////////Constructors/////////////////////////// */

    /** Creates a Customer with specified Customer Parameters.
     * @param firstName A String representing Customers first Name
     * @param surname A String representing Customers Surname
     * @param dateOfBirth A LocalDateTime representing Customers DOB
     * @param mail A user E-Mail
     * @param userPassword Password to use it in Login
     * @param personAddress A PersonAddress representing Customers Address
     * @param customerLevel A CustomerLevel representing Customers Level
     * @param paymentMethod A PaymentMethod representing Customers Payment Method
     */
    public Customer(String firstName, String surname, LocalDate dateOfBirth, String mail, String userPassword, PersonAddress personAddress, CustomerLevel customerLevel, PaymentMethod paymentMethod){
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mail = mail;
        this.userPassword = userPassword;
        this.personAddress = personAddress;
        this.customerLevel = customerLevel;
        this.paymentMethod = paymentMethod;
    }

    public Customer(List<ElectricRental> electricRentals) {
        this.electricRentals = electricRentals;
    }

    /** Creates a Customer with default Values.
     * It is used to increment speed of UnitTests.
     */
    public Customer(){
        this.firstName = "Max";
        this.surname = "Mustermann";
        this.dateOfBirth = LocalDate.of(1990,12,31);
        this.mail = "max@gmail.com";
        this.userPassword = "12345678";
        this.personAddress = new PersonAddress();
        this.customerLevel = CustomerLevel.REGULARUSER;
        this.paymentMethod = new PaymentMethod();
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

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
    public List getElectricRentals(){
        return this.electricRentals;
    }


    /** Gets the Fuel Rentals.
     * @return An ArrayList representing Fuel Rentals
     */
    public List getFuelRentals(){
        return this.fuelRentals;
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

    public void setPaymentMethod(String cardNumber, PaymentMethod.CardType cardType, LocalDate validThrough, String CCV){
        this.paymentMethod.setCardNumber(cardNumber);
        this.paymentMethod.setCardType(cardType);
        this.paymentMethod.setValidThrough(validThrough);
        this.paymentMethod.setCCV(CCV);
    }

    /* /////////////////////Methods/////////////////////////// */


    /** Gets the Electric OneNightCar.Rental with index.
     * @param index an int index
     * @return An ElectricRental with given index
     */
    public ElectricRental getElectricRentalWithIndex(int index){
        return this.electricRentals.get(index);
    }

    /** Gets the Fuel OneNightCar.Rental with index.
     * @param index an int index
     * @return A FuelRental with given index
     */
    public FuelRental getFuelRentalWithIndex(int index){
        return this.fuelRentals.get(index);
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
        if( this.electricRentals.size() > 0 ) {
            for (int indexInList = 0; indexInList < this.electricRentals.size(); indexInList++) {
                if (electricRentals.get(indexInList).getElectricCar() == electricCar) {
                    return indexInList;
                }
            }
        }
        return -1;
    }

    /** Function: retrieve the current index from a combustion car in the Fuel OneNightCar.Rental list (Needed to Delete or Modify Rentals)
     * @param combustionCar a CombustionCar representing the OneNightCar.Car
     * @return An int representing the index on the List
     */
    public int getCombustionCarIndexInFuelRentalList(CombustionCar combustionCar){
        for (int indexInList = 0; indexInList <= fuelRentals.size(); indexInList++)
            if(fuelRentals.get(indexInList).getCombustionCar() == combustionCar){
                return indexInList;
            }
        return -1;
    }

    /**
     * Creates a new Electric OneNightCar.Rental of a Vehicle and this Customer
     * @param electricCar   an ElectricCar representing an electric car the Customer wants to book
     * @param date          a LocalDate representing the date of the Booking
     */
    public void rentAnElectricCar(ElectricCar electricCar, LocalDate date,
                                  List<RentalTimeSlot> timeSlotsList) {
        ElectricRental electricRental = new ElectricRental(electricCar, date, this, timeSlotsList);
        try {
            this.electricRentals.add(electricRental);
        }
        catch(Exception e){
            System.out.print("Rental couldn't be executed!" + e);
            System.out.printf("%n");
        }
    }

    /** Ask permission to Admin to Modify an existing Electrical OneNightCar.Rental made by this Customer
     * @param electricRental the OneNightCar.Rental that wants to be modified
     * @param date          a LocalDate representing the date of the Booking
     * @param electricCar which electric car rental is being modified
     * @param timeSlotsList a List of Time Slots
     */
    public void modifyAnElectricRental(ElectricRental electricRental, ElectricCar electricCar,
                                    LocalDate date, List<RentalTimeSlot> timeSlotsList) {
        try {
            if (electricRental.getCustomer().getId() == this.getId()) {
                if (Admin.approveRentalModification(electricRental)) {
                    ElectricRental newElectricRental = new ElectricRental(electricCar, date,
                                                             this, timeSlotsList);
                    // Remove the old OneNightCar.Rental
                    this.electricRentals.remove(electricRental);
                    // Add the new OneNightCar.Rental
                    this.electricRentals.add(newElectricRental);
                }
            }
        }
        catch(Exception e){
            System.out.print("Electric Car couldn't be modified!" + e);
        }
    }

    /** Ask the Admin to Cancel an existing Electrical OneNightCar.Rental made by this Customer
     * @param electricRental an ElectricRental representing which OneNightCar.Rental is being cancelled
     */
    public void cancelElectricRental(ElectricRental electricRental){
         if (electricRental.getCustomer().getId() == this.getId()) {
            if (Admin.approveRentalModification(electricRental)){
                this.electricRentals.remove(electricRental);
                Admin.deleteElectricRental(electricRental);
            }
         }
    }

    /**
     * Creates a new OneNightCar.Rental of a Vehicle and this Customer
     * @param combustionCar   an CombustionCar representing the car the Customer wants to book
     * @param date          a LocalDate representing the date of the Booking
     * @param timeSlotsList a List of Time Slots
     */
     public void rentAFuelCar(CombustionCar combustionCar,
                              LocalDate date, List<RentalTimeSlot> timeSlotsList) {
         FuelRental fuelRental = new FuelRental(combustionCar, date, this, timeSlotsList);
         try {
             this.fuelRentals.add(fuelRental);
         }
         catch(Exception e){
             System.out.print("Rental could not be executed!" + e);
         }
     }

    /** Ask permission to Admin to Modify an existing Electrical OneNightCar.Rental made by this Customer
     * @param fuelRental the OneNightCar.Rental that wants to be modified
     * @param date          a LocalDate representing the date of the Booking
     * @param combustionCar which cars OneNightCar.Rental need to be modified
     * @param timeSlotsList a List of Time Slots
     */
    public void modifyARegularRental(FuelRental fuelRental, CombustionCar combustionCar,
                                     LocalDate date, List<RentalTimeSlot> timeSlotsList) {
        if (fuelRental.getCustomer().getId() == this.getId()) {
            if (Admin.approveRentalModification(fuelRental)){
                FuelRental newFuelRental = new FuelRental( combustionCar, date, this, timeSlotsList);
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
        if (fuelRental.getCustomer().getId() == this.getId()) {
            if (Admin.approveRentalModification(fuelRental)){
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
        electricCar.setCarState(Car.State.DAMAGED);
    }

    /** Simulates the Situation in which a customer damages an Electric OneNightCar.Car
     * @param combustionCar the OneNightCar.Car that was Damaged
     */
    public void customerDamagesAFuelCar(CombustionCar combustionCar){
        combustionCar.setCarState(Car.State.DAMAGED);
    }

    /* /////////////////////Enums/////////////////////////// */

    public enum CustomerLevel {
        NEWUSER,
        REGULARUSER,
        SUPERUSER
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mail='" + mail + '\'' +
                '}';
    }
}
