package projekt;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Employee extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private int employeeID;
    private float salary;
    private TypeOfActivity typeOfActivity;
    private enum TypeOfActivity{
        CUSTOMERSUPPORT,
        MAINTAINER,
        BOSS;
    }

    /* /////////////////////Methods/////////////////////////// */

    // constructor for Employee
    public Employee(String surname, String firstName, String ZIP, String street, String houseNumber,
                    GregorianCalendar dateOfBirth, float salary, TypeOfActivity typeOfActivity, List list) {
        employeeID = list.getSizeOfEmployees();            //Creates a running counter of Employees in list
        list.employees.add(this);                          //Adds the new employee to the global list
        super.surname = surname;
        super.firstName = firstName;
        super.ZIP = ZIP;
        super.street = street;
        super.houseNumber = houseNumber;
        super.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.typeOfActivity = typeOfActivity;
    }

    public static void employeeHelpsCustomer(int customerId){
        /* *********** we don't know how to help our Customer (yet) **********
        * the idea is to do something with an interface like start a chat or something like that*/
    }

    // Used to generate Random Booleans for employeeRepairsCar
    public boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public void employeeRepairsCar(Car car){
        if(car.getCarState() == car.getCarState().DAMAGED){
            boolean carSuccessfullyRepaired;
            /* *********** Repairs with the magical powers of Employee ********** */
            carSuccessfullyRepaired = getRandomBoolean();
            if (carSuccessfullyRepaired == true){
                System.out.println("We were able to fix the car");
                car.changeCarState(Car.State.OK);
            }
            else{
                System.out.println("Sorry the car is not repairable");
                car.changeCarState(Car.State.DAMAGED);
            }
        }
    }

    public void employeeRefuelsCar(Rental rental, Car car){
       if(rental.getFuelAfter() <= 15){
           if(car.getFuelType() == car.getFuelType().ELECTRIC){
               // if the Car is a electric car then to the E-Car charging Area
           }
            else{
               System.out.println("Car fuel Type: "+car.getFuelType());
               System.out.println("Max Capacity: "+car.getTankSize());
               System.out.println("Current Fuel : "+rental.getFuelAfter());
           }
       }

    }




}