package projekt;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person {

    /* /////////////////////Attributes///////////////////////// */
    protected int personID;
    protected static AtomicInteger atomicInteger = new AtomicInteger(0); // personId auto increment
    protected String surname;
    protected String firstName;
    protected String ZIP;
    protected String street;
    protected String houseNumber;
    protected Date dateOfBirth;

    /* /////////////////////Methods/////////////////////////// */


    public void Persons(String surname, String firstName, String ZIP, String street, String houseNumber, Date dateOfBirth){
        this.personID = atomicInteger.incrementAndGet();
        this.surname= surname;
        this.firstName= firstName;
        this.ZIP = ZIP;
        this.street = street;
        this.houseNumber = this.houseNumber;
        this.dateOfBirth= dateOfBirth;
    }
    public void modifyAddress( String ZIP, String street, String houseNumber, Date dateOfBirth)
    {
        this.ZIP = ZIP;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public int getPersonID()
    {
        return this.personID;
    }

    public String setSurname(String surname){
        this.surname = surname;
        return this.surname;
    }
    public String setFirstName(String firstName){
        this.firstName= firstName;
        return this.firstName;
    }
    public String setZIP(String ZIP){
        this.ZIP = ZIP;
        return this.ZIP;
    }
    public String setStreet(String street){
        this.street = street;
        return this.street;
    }
    public String setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
        return this.houseNumber;
    }
    public Date setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth= dateOfBirth;
        return this.dateOfBirth;
    }
}

