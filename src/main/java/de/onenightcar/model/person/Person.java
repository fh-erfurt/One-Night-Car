package de.onenightcar.model.person;

import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;


/** Represents a Person
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */

@MappedSuperclass
public abstract class Person extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    protected String firstName;
    protected String surname;
    protected LocalDateTime dateOfBirth;
    protected String mail;
    protected String userPassword;

    @OneToOne
    protected PersonAddress personAddress;

    /* /////////////////////Getter/Setters/////////////////////////// */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /** Gets the Persons DOB.
     * @return A LocalDateTime representing the Date of Birth of a person
     */
    public LocalDateTime getDateOfBirth(){
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
        try {
            this.personAddress.setZIP(personAddress.getZIP());
            this.personAddress.setCity(personAddress.getCity());
            this.personAddress.setStreet(personAddress.getStreet());
            this.personAddress.setStreetNumber(personAddress.getStreetNumber());
        }
        catch(Exception e){
            System.out.print("PersonAddress could not be set!");
        }
    }

    /* /////////////////////Methods/////////////////////////// */

    /** Gets the Persons name.
     * @return A string representing the whole name (first name and surname) of a person
     */
    public String getName(){
        return (this.firstName + " " + this.surname);
    }

    /** Sets the Persons first Name and Surname.
     * @param firstName A String containing the Persons first name
     * @param surname A String containing the Persons surname
     */
    public void setNewName(String firstName, String surname){
        this.firstName = firstName;
        this.surname = surname;
    }

    /* /////////////////////Overrides/////////////////////////// */

}

