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





}