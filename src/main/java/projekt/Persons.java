package projekt;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class  Persons {

    /* /////////////////////Attributes///////////////////////// */
    private int personID;
    private static AtomicInteger atomicInteger = new AtomicInteger(0); // personId auto increment
    private String surname;
    private String firstName;
    private String ZIP;
    private String street;
    private String housNumber;
    private Date dateOfBirth;

    /* /////////////////////Methods/////////////////////////// */


    public void Persons(String surname, String firstName, String ZIP, String street, String housNumber, Date dateOfBirth){
        this.personID = atomicInteger.incrementAndGet();
        this.surname= surname;
        this.firstName= firstName;
        this.ZIP = ZIP;
        this.street = street;
        this.housNumber= housNumber;
        this.dateOfBirth= dateOfBirth;
    }
    public void modifyPersonalData(String surname, String firstName, String ZIP, String street, String housNumber, Date dateOfBirth)
    {
        this.firstName= firstName;
        this.ZIP = ZIP;
        this.street = street;
        this.housNumber= housNumber;
        this.dateOfBirth= dateOfBirth;
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
    public String setHousNumber(String housNumber){
        this.housNumber= housNumber;
        return this.housNumber;
    }
    public Date setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth= dateOfBirth;
        return this.dateOfBirth;
    }
}

