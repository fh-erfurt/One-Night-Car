package de.onenightcar.model.person;

import de.onenightcar.model.rental.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


/** Represents an Admin
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
@RestController
public class Admin extends Employee {

    /* /////////////////////Attributes///////////////////////// */
 static Logger log = LoggerFactory.getLogger(Admin.class);

    /* /////////////////////Constructors/////////////////////////// */

    // Needed to be able to create the entity
    protected Admin() {}

    /** Creates an Admin with specified Admin Parameters.
     * @param firstName A String representing Admin first Name
     * @param surname A String representing Admin Surname
     * @param dateOfBirth A GregorianCalendar representing Admin DOB
     * @param personAddress A PersonAddress representing Admin Address
     * @param salary A Float representing the Admin salary
     * @param typeOfActivity a TypeOfActivity representing the activity of the OneNightCar.Person
     */
    public Admin(String firstName, String surname, LocalDate dateOfBirth, String mail, String userPassword, PersonAddress personAddress,
                 float salary, TypeOfActivity typeOfActivity) {
        super(firstName, surname, dateOfBirth, mail, userPassword, personAddress, salary, typeOfActivity);
    }

    /* /////////////////////Methods/////////////////////////// */


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
        log.warn("Fuel rental was removed");
        log.info(String.valueOf(fuelRental));
    }

    /** Function to erase a FuelRental
     * @param electricRental which rental needs to be deleted
     */
    public static void deleteElectricRental(ElectricRental electricRental){
        electricRental = null;
        //Call the Garbage Collector
        System.gc();
        log.warn("Electric rental was removed");
        log.info(String.valueOf(electricRental));
    }

    /** Resolves a Problem where nobody else can make the Customer happy
     * @return a boolean
    */
    public static boolean resolveProblem(){
        return true;
    }

    /** Function to erase an Employee
     * @param employee a Employee which is going to be erased
     */
    public void deleteEmployee (Employee employee){
        try {
            employee = null;
            //Call the Garbage Collector
            System.gc();
            log.info("Delete Employee successful");
        }
        catch(Exception e){
            System.out.print(e +"Employee could not be removed or does not exist!");
            log.error("Employee Employee could not be removed or does not exist!");
            //
        }
    }

    /** Function to erase a Customer
     * @param customer a Customer which is going to be erased
     */
    public void deleteCustomer (Customer customer){
        customer = null;
        //Call the Garbage Collector
        System.gc();
        log.info("Customer deleted!");
    }

    /* /////////////////////Overrides/////////////////////////// */

}
