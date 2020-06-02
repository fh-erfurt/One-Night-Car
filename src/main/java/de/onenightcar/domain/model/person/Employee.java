package de.onenightcar.domain.model.person;

import de.onenightcar.domain.model.car.*;

import javax.persistence.Entity;
import java.util.GregorianCalendar;
import java.util.Random;

/** Represents an Employee
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class Employee extends Person {

    /* /////////////////////Attributes///////////////////////// */

    //TODO: remove the employeeID (already has a an ID from the AbstractDatabaseEntity) and see where it may be a problem
    private int employeeID;
    private float salary;
    private TypeOfActivity typeOfActivity;
    /** Creates an Employee with specified Employee Parameters.
     * @param firstName A String representing Employee first Name
     * @param surname A String representing Employee Surname
     * @param dateOfBirth A GregorianCalendar representing Employee DOB
     * @param personAddress A PersonAddress representing Employee Address
     * @param personManager A PersonManager with the management from the Packet OneNightCar.Person
     * @param salary A Float representing the Employee salary
     * @param typeOfActivity a TypeOfActivity representing what the Employee does
     */
    public Employee(String firstName, String surname, GregorianCalendar dateOfBirth, PersonAddress personAddress,
                    PersonManager personManager, float salary, TypeOfActivity typeOfActivity){
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.personAddress = personAddress;
        this.salary = salary;
        this.typeOfActivity = typeOfActivity;
        this.employeeID = personManager.getAndIncrementEmployeeCounter();
        personManager.employees.add(this);                               //Adds this Employee to the Employee List
    }

    /** Creates a Customer with default Values.
     * It is used to increment speed of UnitTests.
     * @param personManager A PersonManager with the management from the Packet OneNightCar.Person
     */
    public Employee(PersonManager personManager){
        this.firstName = "Peter";
        this.surname = "Bossmann";
        this.dateOfBirth = new GregorianCalendar(1964,GregorianCalendar.APRIL,4);
        this.personAddress = new PersonAddress();
        this.salary = 10000;
        this.typeOfActivity = TypeOfActivity.BOSS;
        this.employeeID = personManager.getAndIncrementEmployeeCounter();
        personManager.employees.add(this);                               //Adds this Employee to the Employee List
    }

    // Needed to be able to create the entity
    public Employee(){
    }

    /* /////////////////////Methods/////////////////////////// */

    /** Random boolean generator.
     * @return a random Boolean
     */
    private static boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    /** Represents the situation in which the Employee tries to helps a Customer
     * @return A Boolean representing if the Issue was solved
     * false: the Issue was solved
     * true: the Issue was not solved
     */
    public boolean employeeHelpsCustomer(){
        if(this.typeOfActivity == TypeOfActivity.CUSTOMERSUPPORT)
        {
            /* *********** Tries to make the Customer happy with the magical powers of Employee ********** */
            return getRandomBoolean();
        }
        else {
            return false;
        }
    }

    /** Gets the Employee ID.
     * @return A int representing ID of an Employee
     */
    public int getEmployeeID(){
        return this.employeeID;
    }

    /** Gets the Employee TypeOfActivity.
     * @return A TypeOfActivity representing the activity of an Employee
     */
    public TypeOfActivity getTypeOfActivity(){
        return this.typeOfActivity;
    }

    /** Sets the Employee new Type Of Activity.
     * @param typeOfActivity A TypeOfActivity representing the new Type Of Activity of an Employee
     */
    public void setTypeOfActivity(TypeOfActivity typeOfActivity){
        this.typeOfActivity = typeOfActivity;
    }

    /** Gets the Employee salary.
     * @return A float representing the salary of an Employee
     */
    public float getSalary(){
        return this.salary;
    }

    /** Sets the Employee new salary.
     * @param salary A float representing the new salary of an Employee
     */
    public void setSalary(float salary){
        this.salary = salary;
    }

    /** Employee tries to repair a car.
     * @param electricCar A ElectricCar needing to be repaired
     */
    public void employeeRepairsElectricCar(ElectricCar electricCar){
        if(electricCar.getCarState() == Car.State.DAMAGED){
            if(this.typeOfActivity == TypeOfActivity.MAINTAINER){
                boolean carSuccessfullyRepaired;

                /* *********** Tries to repair with the magical powers of MAINTAINER ********** */
                carSuccessfullyRepaired = getRandomBoolean();
                if (carSuccessfullyRepaired){
                    // The car could be Repaired
                    electricCar.changeCarState(Car.State.OK);
                }
                else{
                    // Nothing to do here :(
                    electricCar.changeCarState(Car.State.DAMAGED);
                }
            }
        }
    }

    /** Employee tries to repair a car.
     * @param combustionCar A CombustionCar needing to be repaired
     */
    public void employeeRepairsCombustionCar(CombustionCar combustionCar){
        if(combustionCar.getCarState() == Car.State.DAMAGED){
            if(this.typeOfActivity == TypeOfActivity.MAINTAINER){
                boolean carSuccessfullyRepaired;

                /* *********** Tries to repair with the magical powers of MAINTAINER ********** */
                carSuccessfullyRepaired = getRandomBoolean();
                if (carSuccessfullyRepaired){
                    // The car could be Repaired
                    combustionCar.changeCarState(Car.State.OK);
                }
                else{
                    // Nothing to do here :(
                    combustionCar.changeCarState(Car.State.DAMAGED);
                }
            }
        }
    }

    /** Employee refuels a car.
     * @param combustionCar A CombustionCar needing to be repaired
     */
    public void employeeRefuelsCar(CombustionCar combustionCar){
        if(combustionCar.getFuelLevel() < 50){
            if(this.typeOfActivity == TypeOfActivity.MAINTAINER) {
                /* *********** Goes to the Tanking Station and refuels the car ********** */
                combustionCar.setFuelLevel(100);
            }
        }
    }

    public enum TypeOfActivity{
        CUSTOMERSUPPORT,
        MAINTAINER,
        BOSS
    }

}




