package projekt;

import java.util.Date;

public class Employee extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private float salary;
    private TypeOfActivity typeOfActivity;
    private enum TypeOfActivity{
        CUSTOMERSUPPORT,
        MAINTAINER,
        BOSS;
    }

    /* /////////////////////Methods/////////////////////////// */

    // constructor for Employee
    public Employee(String surname, String firstName, String ZIP, String street, String houseNumber, Date dateOfBirth,float salary, TypeOfActivity typeOfActivity) {
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
        /* *********** we don't know how to help our Customer (yet) ********** */
    }

    public void employeeRepairsCar(Car car){
        if(car.getCarState() == car.getCarState().DAMAGED){
            /* *********** what does an Employee in this Situation ??? ********** */
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
               System.out.println("current Fuel : "+rental.getFuelAfter());
           }
       }

    }




}