package de.onenightcar.domain.model.person;

import de.onenightcar.domain.model.rental.*;

import javax.persistence.Entity;
import java.util.GregorianCalendar;
import java.util.Random;

/** Represents an Admin
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class Admin extends Employee {
    /* /////////////////////Attributes///////////////////////// */

    /* /////////////////////Methods/////////////////////////// */

    /** Creates an Admin with specified Admin Parameters.
     * @param firstName A String representing Admin first Name
     * @param surname A String representing Admin Surname
     * @param dateOfBirth A GregorianCalendar representing Admin DOB
     * @param personAddress A PersonAddress representing Admin Address
     * @param personManager A PersonManager with the management from the Packet OneNightCar.Person
     * @param salary A Float representing the Admin salary
     * @param typeOfActivity a TypeOfActivity representing the activity of the OneNightCar.Person
     */
    public Admin(String firstName, String surname, GregorianCalendar dateOfBirth, PersonAddress personAddress,
                 PersonManager personManager, float salary, TypeOfActivity typeOfActivity) {
        super(firstName, surname, dateOfBirth, personAddress, personManager, salary, typeOfActivity);
    }

    // Needed to be able to create the entity
    public Admin() {
    }

    /** Random boolean generator.
     * @return a random Boolean
     */
    private static boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    /** Function to check if an admin permits a modification
     * @param electricRental representing the OneNightCar.Rental to modify
     * @return a Boolean representing the Permission
     * true: it can be changed
     * false: it has to stay that way
     */
    public static boolean approveRentalModification(ElectricRental electricRental){
        return true;
    }

    /** Function to check if an admin permits a modification
     * @param fuelRental representing the desired OneNightCar.Rental to modify
     * @return a Boolean representing the Permission
     * true: it can be changed
     * false: it has to stay that way
     */
    public static boolean approveRentalModification(FuelRental fuelRental){
        return true;
    }

    /** Function to erase a FuelRental
     * @param fuelRental which rental needs to be deleted
     */
    public static void deleteFuelRental(FuelRental fuelRental){
        fuelRental = null;
        //Call the Garbage Collector
        System.gc();
    }

    /** Function to erase a FuelRental
     * @param electricRental which rental needs to be deleted
     */
    public static void deleteElectricRental(ElectricRental electricRental){
        electricRental = null;
        //Call the Garbage Collector
        System.gc();
    }

    /** Resolves a Problem where nobody else can make the Customer happy
     * @return a boolean
    */
    public static boolean resolveProblem(){
        return true;
    }

    /** Function to erase an Employee
     * @param employee a Employee which is going to be erased
     * @param personManager a PersonManager (List from which it should be removed)
     */
    public void deleteEmployee (Employee employee, PersonManager personManager){
        employee = null;
        personManager.removeEmployeeFromEmployees(employee);
        //Call the Garbage Collector
        System.gc();
    }

    /** Function to erase a Customer
     * @param customer a Customer which is going to be erased
     * @param personManager a PersonManager (List from which it should be removed)
     */
    public void deleteCustomer (Customer customer, PersonManager personManager){
        customer = null;
        personManager.removeCustomerFromCustomers(customer);
        //Call the Garbage Collector
        System.gc();
    }
}
