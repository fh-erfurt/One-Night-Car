package de.onenightcar.model.person;

import de.onenightcar.model.car.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/** Represents an Employee
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@Entity
public class Employee extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private float salary;

    @Enumerated(EnumType.STRING)
    private TypeOfActivity typeOfActivity;

    /* /////////////////////Constructors/////////////////////////// */

    /** Creates an Employee with specified Employee Parameters.
     * @param firstName A String representing Employee first Name
     * @param surname A String representing Employee Surname
     * @param dateOfBirth A LocalDateTime representing Employee DOB
     * @param personAddress A PersonAddress representing Employee Address
     * @param salary A Float representing the Employee salary
     * @param typeOfActivity a TypeOfActivity representing what the Employee does
     */
    public Employee(String firstName, String surname, LocalDate dateOfBirth, String mail, String userPassword, PersonAddress personAddress, float salary, TypeOfActivity typeOfActivity){
        this.firstName = firstName;
        this.surname = surname;
        this.mail= mail;
        this.userPassword = userPassword;
        this.dateOfBirth = dateOfBirth;
        this.personAddress = personAddress;
        this.salary = salary;
        this.typeOfActivity = typeOfActivity;
    }

    /** Creates a Customer with default Values.
     * It is used to increment speed of UnitTests.
     */
    public Employee(){
        this.firstName = "Peter";
        this.surname = "Bossmann";
        this.mail= "peter@gmail.com";
        this.userPassword = "12345678";
        this.dateOfBirth = LocalDate.of(1964,4,4);
        this.personAddress = new PersonAddress();
        this.salary = 10000;
        this.typeOfActivity = TypeOfActivity.BOSS;
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

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
        try {
            this.salary = salary;
        }
        catch(Exception e){
            System.out.print("Salary couldn't be set, check Salary!");
        }
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
                    electricCar.setCarState(Car.State.OK);
                }
                else{
                    // Nothing to do here :(
                    electricCar.setCarState(Car.State.DAMAGED);
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
                    combustionCar.setCarState(Car.State.OK);
                }
                else{
                    // Nothing to do here :(
                    combustionCar.setCarState(Car.State.DAMAGED);
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

    /* /////////////////////Enums/////////////////////////// */

    public enum TypeOfActivity{
        CUSTOMERSUPPORT,
        MAINTAINER,
        BOSS
    }

    /* /////////////////////Overrides/////////////////////////// */

}




