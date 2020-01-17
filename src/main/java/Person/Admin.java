package Person;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import Rental.*;

public class Admin extends Employee {
    /* /////////////////////Attributes///////////////////////// */

    /* /////////////////////Methods/////////////////////////// */

    /** Creates an Admin with specified Admin Parameters.
     * @param firstName A String representing Admin first Name
     * @param surname A String representing Admin Surname
     * @param dateOfBirth A GregorianCalendar representing Admin DOB
     * @param personAddress A PersonAddress representing Admin Address
     * @param personManager A PersonManager with the management from the Packet Person
     * @param salary A Float representing the Admin salary
     */
    public Admin(String firstName, String surname, GregorianCalendar dateOfBirth, PersonAddress personAddress,
                 PersonManager personManager, float salary, TypeOfActivity typeOfActivity) {
        super(firstName, surname, dateOfBirth, personAddress, personManager, salary, typeOfActivity);
    }

    /** Random boolean generator.
     * @return a random Boolean
     */
    private static boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    /** Function to check if an admin permits a modification
     * @param electricRental representing the Rental to modify
     * @return a Boolean representing the Permission
     * true -> it can be changed
     * false -> it has to stay that way
     */
//    public boolean approveRentalModification(ElectricRental electricRental){
//        GregorianCalendar currentDate = new GregorianCalendar();
//        // It is only True if there are at least 1 day between current time and Rental date
//        if((currentDate.get(Calendar.DAY_OF_MONTH) - electricRental.getDate.get(Calendar.DAY_OF_MONTH)) > 0){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    /** Function to check if an admin permits a modification
     * @param fuelRental representing the desired Rental to modify
     * @return a Boolean representing the Permission
     * true -> it can be changed
     * false -> it has to stay that way
     */
//    public boolean approveRentalModification(FuelRental fuelRental){
//        GregorianCalendar currentDate = new GregorianCalendar();
//        // It is only True if there are at least 1 day between current time and Rental date
//        if((currentDate.get(Calendar.DAY_OF_MONTH) - fuelRental.getDate.get(Calendar.DAY_OF_MONTH)) > 0){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    /** Function to erase a FuelRental
     * @param fuelRental
     */
//    public void deleteFuelRental(FuelRental fuelRental){
//        fuelRental = null
//        //Call the Garbage Collector
//        System.gc();
//    }

    /** Function to erase a FuelRental
     * @param electricRental
     */
//    public void deleteFuelRental(ElectricRental electricRental){
//        electricRental = null;
//        //Call the Garbage Collector
//        System.gc();
//    }

    /** Resolves a Problem where nobody else can make the Customer happy
    */
    public static boolean resolveProblem(){
        return true;
    }
}
