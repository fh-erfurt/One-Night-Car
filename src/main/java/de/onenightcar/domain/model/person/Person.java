package de.onenightcar.domain.model.person;

import java.util.GregorianCalendar;

/** Represents a PaymentMethod
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public abstract class Person {

    /* /////////////////////Attributes///////////////////////// */

    protected String firstName;
    protected String surname;
    protected GregorianCalendar dateOfBirth;
    protected PersonAddress personAddress;

    /* /////////////////////Methods/////////////////////////// */

    /** Gets the Persons name.
     * @return A string representing the whole name (first name and surname) of a person
     */
    public String getName(){
        return (this.firstName + " " + this.surname);
    }

    /** Gets the Persons DOB.
     * @return A GregorianCalendar representing the Date of Birth of a person
     */
    public GregorianCalendar getDateOfBirth(){
        return this.dateOfBirth;
    }

    /** Gets the Persons Address.
     * @return A PersonAddress representing the Address of a person
     */
    public PersonAddress getPersonAddress(){
        return this.personAddress;
    }

    /** Sets the Persons Address
     * @param personAddress a PersonAddress containing the Persons new Address
     */
    public void setPersonAddress(PersonAddress personAddress){
        this.personAddress.setZIP(personAddress.getZIP());
        this.personAddress.setCity(personAddress.getCity());
        this.personAddress.setStreet(personAddress.getStreet());
        this.personAddress.setStreetNumber(personAddress.getStreetNumber());
    }

    /** Sets the Persons first Name and Surname.
     * @param firstName A String containing the Persons first name
     * @param surname A String containing the Persons surname
     */
    public void setNewName(String firstName, String surname){
        this.firstName = firstName;
        this.surname = surname;
    }
}

