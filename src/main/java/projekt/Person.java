package projekt;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person {

    /* /////////////////////Attributes///////////////////////// */
    protected String surname;
    protected String firstName;
    protected String ZIP;
    protected String street;
    protected String houseNumber;
    protected Date dateOfBirth;

    /* /////////////////////Methods/////////////////////////// */


    public void modifyAddress( String ZIP, String street, String houseNumber) {
        this.ZIP = ZIP;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public void setNewName(String firstName, String surname){
        this.firstName = firstName;
        this.surname = surname;
    }

    public void setNewAddress(String ZIP, String street, String houseNumber){
        this.ZIP = ZIP;
        this.street = street;
        this.houseNumber = houseNumber;
    }

}

