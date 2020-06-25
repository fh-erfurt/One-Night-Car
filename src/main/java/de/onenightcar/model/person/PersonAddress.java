package de.onenightcar.model.person;

import de.onenightcar.util.AbstractDatabaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;


/** Represents a PersonAddress
 * @author OneNightCar
 * @version 2.0
 * @since 1.0
 */


@Entity
public class PersonAddress extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    static Logger log = LoggerFactory.getLogger(PersonAddress.class);

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
        try {
            this.ZIP = ZIP;
            log.info("ZIP set to ", ZIP);

        }
        catch(Exception e){
            System.out.print("Could not set ZIP!");
            log.error("Could not set ZIP to ", ZIP);
        }
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
        log.info("Set City to");
        log.info(String.valueOf(city));
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
//        try {
//                street.matches("[a-zA-z]");
//                Integer.parseInt(street);
                this.street = street;
                log.info("Set street to ", street);
                log.info(String.valueOf(street));

//        }
//        catch(Exception e) {
//            System.out.println("Ja");
//        }
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
        log.info("Set streetNumber to ", streetNumber);
    }

    @Override
    public String toString() {
        return "PersonAddress [ZIP= " + this.ZIP +
                ", City= "            + this.city +
                ", Street "           + this.street +
                ", Street Number "    + this.streetNumber;
    }
}
