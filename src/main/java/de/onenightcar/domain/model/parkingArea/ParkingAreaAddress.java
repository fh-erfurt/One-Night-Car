package de.onenightcar.domain.model.parkingArea;

import de.onenightcar.domain.storage.core.AbstractDatabaseEntity;

import javax.persistence.Entity;

/** Represents a ParkingAreaAddress
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

@Entity
public class ParkingAreaAddress extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    private String ZIP;
    private String city;
    private String street;
    private String streetNumber;

    /* /////////////////////Methods/////////////////////////// */

    /** Creates a ParkingAreaAddress with specified Address.
     * @param ZIP Address’s ZIP
     * @param city Address’s city
     * @param street Address’s street name
     * @param streetNumber Address’s street number (With the possibility for Letters)
     */

    public ParkingAreaAddress(String ZIP, String city, String street, String streetNumber) {

        this.ZIP            = ZIP;
        this.city           = city;
        this.street         = street;
        this.streetNumber   = streetNumber;
    }

    /**
     * Creater a Parking Aria with standard values
     */
    public ParkingAreaAddress(){
        this.ZIP = "99085";
        this.city = "Erfurt";
        this.street = "Altonaer Str.";
        this.streetNumber = "25";
    }

    /**gets the ZIP
     * @return ZIP
     */

    public String getZIP() {
        try {
            return this.ZIP;
        }
        catch(Exception e){
            System.out.print("This ParkingAreaAddress doesn't exist!");
            return "00000";
        }
    }
    /**gets the City
     * @return City
     */

    public String getCity() {return this.city;}

    /**gets the Street
     * @return Street
     */

    public String getStreet() {return this.street;}

    /**gets the street number
     * @return street number
     */

    public String getStreetNumber() {return this.streetNumber;}


    @Override
    public String toString() {
        return "ParkingAreaAddress [ZIP= " + this.ZIP +
                ", City= "            + this.city +
                ", Street "           + this.street +
                ", Street Number "    + this.streetNumber;
    }
}

