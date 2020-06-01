package de.onenightcar.domain.model.person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** Represents a PersonAddress
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */


@Entity
public class PersonAddress implements Serializable {

    /* /////////////////////Attributes///////////////////////// */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    private String ZIP;
    private String city;
    private String street;
    private String streetNumber;

    /* /////////////////////Methods/////////////////////////// */

    /** Creates a PersonAddress with specified Address.
     * @param ZIP Address’s ZIP
     * @param city Address’s city
     * @param street Address’s street name
     * @param streetNumber Address’s street number (With the possibility for Letters)
     */
    public PersonAddress(String ZIP, String city, String street, String streetNumber){
        this.ZIP = ZIP;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    /** Creates a PersonAddress with default Values.
     * It is used to increment speed of UnitTests.
     */
    public PersonAddress(){
        this.ZIP = "99085";
        this.city = "Erfurt";
        this.street = "Altonaer Str.";
        this.streetNumber = "25";
    }

    /** Gets the Address ZIP.
     * @return A string representing the Address ZIP
     */
    public String getZIP(){
        return this.ZIP;
    }

    /** Sets the Address ZIP.
     * @param ZIP A String containing the Address ZIP
     */
    public void setZIP(String ZIP){
        this.ZIP = ZIP;
    }

    /** Gets the Address city.
     * @return A string representing the Address city
     */
    public String getCity(){
        return this.city;
    }

    /** Sets the Address City.
     * @param city A String containing the Address ZIP
     */
    public void setCity(String city){
        this.city = city;
    }

    /** Gets the Address Street.
     * @return A string representing the Address Street
     */
    public String getStreet(){
        return this.street;
    }

    /** Sets the Address Street.
     * @param street A String containing the Address Street
     */
    public void setStreet(String street){
        this.street = street;
    }

    /** Gets the Address Street.
     * @return A string representing the Address StreetNumber
     */
    public String getStreetNumber(){
        return this.streetNumber;
    }

    /** Sets the Address StreetNumber.
     * @param streetNumber A String containing the Address StreetNumber
     */
    public void setStreetNumber(String streetNumber){
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "PersonAddress [ZIP= " + this.ZIP +
                ", City= "            + this.city +
                ", Street "           + this.street +
                ", Street Number "    + this.streetNumber;
    }


    /* /////////////////////Lifecycle Hooks/////////////////////////// */

    public void setCreated (Date date) {
        this.created = date;
    }

    @PrePersist
    void onCreate(){
        this.setCreated( new Date() );
    }

    public void setModified (Date date) {
        this.modified = date;
    }

    @PreUpdate
    void onUpdate(){
        this.setModified( new Date());
    }

}
