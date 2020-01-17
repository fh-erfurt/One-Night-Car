package Person;

import Car.*;
import Rental.Rental;

import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/** Represents a PaymentMethod
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class Customer extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private int customerID;
    private CustomerLevel customerLevel;
    protected enum CustomerLevel {
        NEWUSER,
        REGULARUSER,
        SUPERUSER
    }
    private PaymentMethod paymentMethod;
    // public ArrayList<FuelRental> fuelRentals;         TODO implement FuelRental
    // public ArrayList<ElectricRental> electricRentals; TODO implement ElectricRental


    /* /////////////////////Methods/////////////////////////// */

    /** Creates a Customer with specified Customer Parameters.
     * @param firstName A String representing Customers first Name
     * @param surname A String representing Customers Surname
     * @param dateOfBirth A GregorianCalendar representing Customers DOB
     * @param personAddress A PersonAddress representing Customers Address
     * @param personManager A PersonManager with the management from the Packet Person
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
        // this.fuelRentals = new ArrayList<FuelRental>();                  TODO
        // this.electricRentals = new ArrayList<ElectricRental>();          TODO
    }

    /** Creates a Customer with default Values.
     * It is used to increment speed of UnitTests.
     * @param personManager A PersonManager with the management from the Packet Person
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
        // this.fuelRentals = new ArrayList<FuelRental>();                  TODO
        // this.electricRentals = new ArrayList<ElectricRental>();          TODO
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

    /** Gets the Customer Payment Method.
     * @return A PaymentMethod representing Payment Method of a Customer
     */
    public PaymentMethod getPaymentMethod(){
        return this.paymentMethod;
    }

    /** Sets the Customer Level.
     * @param customerLevel a CustomerLevel representing the Customer Level
     */
    public void setCustomerLevel(CustomerLevel customerLevel){
        this.customerLevel = customerLevel;
    }

    /** Sets the Customers Payment Method.
     * @param paymentMethod a PaymentMethod representing the Customers Payment Method
     */
    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    /** Represents the situation in which the customer needs Support from an Employee
     * @return A Boolean representing if the Issue was solved
     * true -> the Customer still needs Support
     * false -> the Issue was solved
     */
    public boolean customerNeedHelp(){
        Employee.employeeHelpsCustomer(this.customerID);
        return true;
    }

    /** Function to retrieve the current index from a car from the Electric car list
     * @param carID an int representing the CarID
     * @return An int representing the index on the List
     */
    /*public int getElectricCarIndexInList(int carID){
        int indexInList = 0;
        for (indexInList; indexInList < electricRentals.size(); indexInList ++)
            if(electricRentals.get(indexInList).carID == carID){
                return indexInList;
            }
    }*/


    /*TODO javadocs*/
    /*public int getRegularCarIndexInList(int carID){
        int indexInList = 0;
        for (indexInList; indexInList < fuelRentals.size(); indexInList ++)
            if(fuelRentals.get(indexInList).carID == carID){
                return indexInList;
            }
    }
    */

    /** Creates a new Electric Rental of a Vehicle and this Customer
     * @param carID an int representing the id from an electric car the Customer wants to book
     * @param date a GregorianCalender representing the date of the Booking
     * @param departureTime a Time representing the beginning of the Rental
     * @param arrivalTime a Time representing the end of the Rental
     */
    public void rentAnElectricCar(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime){
        //TODO: implement the Class ElectricRental
        //TODO: implement method TrasmitCarDataToRental
        //this.electricRentals.add(CarManagement.getCarIDFromElectrics(carID))
    }

    /** Ask permission to Admin to Modify an existing Electrical Rental made by this Customer
     * @param carID An int representing the new electric carID
     * @param date a GregorianCalender representing the new date of the Booking
     * @param departureTime a Time representing the new beginning of the Rental
     * @param arrivalTime a Time representing the new end of the Rental
     * @param electricRental an ElectricRental representing which Rental is being modified
     */
    /*public void modifyAnElectricRental(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime, ElectricRental electricRental){
        if (electricRental.getCustomerID == this.customerID){
            if (admin.approveRentalModification == true){
                // Create New Electrical Rental with the New data
                //TODO: implement method getCustomerID
                //this.electricRentals.set(getElectricCarIndexInList(carID), newRental);
            }
        }
    }
    */

    /** Ask the Admin to Cancel an existing Electrical Rental made by this Customer
     * @param electricRental an ElectricRental representing which Rental is being cancelled
     */
    /*public void cancelElectricRental(ElectricRental electricRental){
        if (electricRental.getCustomerID == this.customerID){
            if (admin.approveRentalCancelation == true){
                //TODO: implement delete Rental in Admin
                //TODO: implement Method in ElectricRental
                //TODO: implement method getCustomerID
                //this.electricRentals.remove(getElectricCarIndexInList(electricRental.getCarID)
            }
        }
    }
    */


     /** Creates a new Rental of a Vehicle and this Customer
     * @param carID an int representing the id from a car the Customer wants to book
     * @param date a GregorianCalender representing the date of the Booking
     * @param departureTime a Time representing the beginning of the Rental
     * @param arrivalTime a Time representing the end of the Rental
     */
    public void rentAFuelCar(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime){
        //TODO: implement the Class Rental
        //TODO: implement method TrasmitCarDataToRental
        //this.fuelRentals.add(CarManagement.getCarIDFromCombustion(carID))
    }

    /** Ask permission to Admin to Modify an existing Fuel Rental made by this Customer
     * @param carID An int representing the new carID
     * @param date a GregorianCalender representing the new date of the Booking
     * @param departureTime a Time representing the new beginning of the Rental
     * @param arrivalTime a Time representing the new end of the Rental
     * @param fuelRental an FuelRental representing which Rental is being modified
     */
    /*public void modifyAFuelRental(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime, FuelRental fuelRental){
        if (fuelRental.getCustomerID == this.customerID){
            if (admin.approveRentalModification == true){
                // Create New Fuel Rental with the New data
                //TODO: implement method getCustomerID
                //this.fuelRentals.set(getRegularCarIndexInList(carID), newRental);
            }
        }
    }
    */

    /** Ask the Admin to Cancel an existing Fuel Rental made by this Customer
     * @param fuelRental an ElectricRental representing which Rental is being cancelled
     */
    /*public void cancelFuelRental(FuelRental fuelRental){
        if (fuelRental.getCustomerID == this.customerID){
            if (admin.approveRentalCancellation == true){
                //TODO: implement delete Rental in Admin
                //TODO: implement Method in FuelRental
                //TODO: implement method getCustomerID
                //this.fuelRentals.remove(getRegularCarIndexInList(fuelRental.getCarID)
            }
        }
    }
    */

    /** Simulates the Situation in which a customer damages an Electric Car
     * @param electricCar the Car that was Damaged
     */
    /*
    public void customerDamagesAnElectricCar(ElectricCar electricCar){
        electricCar.changeCarState(Car.State.DAMAGED);
    }

    private void requestCarRepair(ElectricCar car, Employee employee) {
        employee.employeeRepairsElectricCar(car);
    }

    private void requestCarRepair(CombustionCar car, Employee employee) {
        employee.employeeRepairsElectricCar(car);
    }
    */
}
