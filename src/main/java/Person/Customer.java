package Person;

import Car.*;
import Rental.*;

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
    public enum CustomerLevel {
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
     */
    public void customerNeedHelp(Employee employee){
        if(employee.employeeHelpsCustomer()){
            // Issue was easily solved
        }
        else{
            // The admin has to intervene and help
            Admin.resolveProblem();
        }
    }

    /** Function: retrieve the current index from an electric car in the Electric Rental list (Needed to Delete or Modify Rentals)
     * @param electricCar an ElectricCar representing the Car
     * @return An int representing the index on the List
     */
    // TODO: complete and test when the Rental list are implemented
//    public int getElectricCarIndexInElectricRentalList(ElectricCar electricCar){
//        for (int indexInList = 0; indexInList < electricRentals.size(); indexInList ++)
//            if(electricRentals.get(indexInList) == electricCar){
//                return indexInList;
//            }
//    }


    /** Function: retrieve the current index from a combustion car in the Fuel Rental list (Needed to Delete or Modify Rentals)
     * @param combustionCar a CombustionCar representing the Car
     * @return An int representing the index on the List
     */
    // TODO: complete and test when the Rental list are implemented
//    public int getCombustionCarIndexInFuelRentalList(CombustionCar combustionCar){
//        for (int indexInList = 0; indexInList < fuelRentals.size(); indexInList ++)
//            if(fuelRentals.get(indexInList) = combustionCar.getCarID){
//                return indexInList;
//            }
//    }


    /** Creates a new Electric Rental of a Vehicle and this Customer
     * @param carID an int representing the id from an electric car the Customer wants to book
     * @param date a GregorianCalender representing the date of the Booking
     * @param departureTime a Time representing the beginning of the Rental
     * @param arrivalTime a Time representing the end of the Rental
     */
    public void rentAnElectricCar(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime){
        //TODO: implement the Class ElectricRental
        //this.electricRentals.add()
    }

    /** Ask permission to Admin to Modify an existing Electrical Rental made by this Customer
     * @param carID An int representing the new electric carID
     * @param date a GregorianCalender representing the new date of the Booking
     * @param departureTime a Time representing the new beginning of the Rental
     * @param arrivalTime a Time representing the new end of the Rental
     * @param electricRental an ElectricRental representing which Rental is being modified
     */
//    public void modifyAnElectricRental(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime, ElectricRental electricRental){
//        if (electricRental.getCustomerID == this.customerID){
//            if (Admin.approveRentalModification == true){
//                //TODO Create NewElectricRental
//                //Change the current Electric Rental with the NewElectricRental
//            }
//        }
//    }

    /** Ask the Admin to Cancel an existing Electrical Rental made by this Customer
     * @param electricRental an ElectricRental representing which Rental is being cancelled
     */
//    public void cancelElectricRental(ElectricRental electricRental){
//        if (electricRental.getCustomerID == this.customerID){
//            if (Admin.approveRentalModification == true){
//                //TODO: implement delete Electric Rental in Admin
//                //this.electricRentals.remove(getElectricCarIndexInElectricRentalList(electricRental.getCarID)
//            }
//        }
//    }

     /** Creates a new Rental of a Vehicle and this Customer
     * @param carID an int representing the id from a car the Customer wants to book
     * @param date a GregorianCalender representing the date of the Booking
     * @param departureTime a Time representing the beginning of the Rental
     * @param arrivalTime a Time representing the end of the Rental
     */
    public void rentAFuelCar(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime){
        //TODO: implement the Class FuelRental
        //this.fuelRentals.add()
    }

    /** Ask permission to Admin to Modify an existing Fuel Rental made by this Customer
     * @param carID An int representing the new carID
     * @param date a GregorianCalender representing the new date of the Booking
     * @param departureTime a Time representing the new beginning of the Rental
     * @param arrivalTime a Time representing the new end of the Rental
     * @param fuelRental an FuelRental representing which Rental is being modified
     */
//    public void modifyAFuelRental(int carID, GregorianCalendar date, Time departureTime, Time arrivalTime, FuelRental fuelRental){
//        if (fuelRental.getCustomerID == this.customerID){
//            if (Admin.approveRentalModification(fuelRental) == true){
//                //TODO Create NewFuelRental
//                //Change the current Fuel Rental with the NewFuelRental
//            }
//        }
//    }


    /** Ask the Admin to Cancel an existing Fuel Rental made by this Customer
     * @param fuelRental an ElectricRental representing which Rental is being cancelled
     */
//    public void cancelFuelRental(FuelRental fuelRental){
//        if (fuelRental.getCustomerID == this.customerID){
//            if (Admin.approveRentalModification == true){
//                //TODO: implement delete Fuel Rental in Admin
//                //this.fuelRentals.remove(getCombustionCarIndexInFuelRentalList(fuelRental.getCarID)
//            }
//        }
//    }

    /** Simulates the Situation in which a customer damages an Electric Car
     * @param electricCar the Car that was Damaged
     */
    public void customerDamagesAnElectricCar(ElectricCar electricCar){
        electricCar.changeCarState(Car.State.DAMAGED);
    }

    /** Simulates the Situation in which a customer damages an Electric Car
     * @param combustionCar the Car that was Damaged
     */
    public void customerDamagesAFuelCar(CombustionCar combustionCar){
        combustionCar.changeCarState(Car.State.DAMAGED);
    }
}
