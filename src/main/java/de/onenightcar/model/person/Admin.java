package de.onenightcar.model.person;

import de.onenightcar.model.rental.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.*;

/** Represents an Admin
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class Admin extends Employee {

    /* /////////////////////Attributes///////////////////////// */

    private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );

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
    public Admin(String firstName, String surname, LocalDateTime dateOfBirth, PersonAddress personAddress,
                 float salary, TypeOfActivity typeOfActivity) {
        super(firstName, surname, dateOfBirth, personAddress, salary, typeOfActivity);
    }

    /* /////////////////////Methods/////////////////////////// */

    private static void setupLogger() {
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logr.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("myLogger.log", true);
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        } catch (java.io.IOException e) {
            // don't stop my program but log out to console.
            logr.log(Level.SEVERE, "File logger not working.", e);
        }
         /*
         Different Levels in order
          OFF
          SEVERE
          WARNING
          INFO
          CONFIG
          FINE
          FINER
          FINEST
          ALL
        */
    }

    //Logging try
    public static void main(String[] args) throws java.io.IOException {
        setupLogger();
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
     */
    public void deleteEmployee (Employee employee){
        try {
            employee = null;
            //Call the Garbage Collector
            System.gc();
        }
        catch(Exception e){
            System.out.print("Employee could not be removed or does not exist!");
            logr.log(Level.SEVERE, "An error accured!", e);
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
    }

    /* /////////////////////Overrides/////////////////////////// */

}
