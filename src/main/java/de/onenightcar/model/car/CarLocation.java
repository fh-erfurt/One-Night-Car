package de.onenightcar.model.car;

import de.onenightcar.model.person.Admin;
import de.onenightcar.util.AbstractDatabaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;

/** Represents a Location
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */


@Entity
public class CarLocation extends AbstractDatabaseEntity {

    /* /////////////////////Attributes/////////////////////////// */

    static Logger log = LoggerFactory.getLogger(CarLocation.class);

    private double GPSLatitude;
    private double GPSLongitude;

    /* /////////////////////Constructors/////////////////////////// */

    protected CarLocation(){}

    /***
     * @param GPSLatitude  A double representing the position
     * @param GPSLongitude A double representing the position
     */
    public CarLocation(double GPSLatitude, double GPSLongitude){
        this.GPSLatitude = GPSLatitude;
        this.GPSLongitude = GPSLongitude;
    }

    /* /////////////////////Methods/////////////////////////// */

    public double getGPSLatitude(){return this.GPSLatitude;}

    /** Change the Latitude Location
     * @param latitude a double with the new Latitude
     */
    public  void setGPSLatitude(double latitude){
        try {
            GPSLatitude = latitude;
            log.info("GPS latitude set to ", latitude);
        }
        catch(Exception e){
            System.out.print("Latitude inadmissible!");
            log.error("Latitude inadmissible ", latitude, e);
        }
    }

    public double getGPSLongitude(){return this.GPSLongitude;}

    /** Change the Longitude Location
     * @param longitude a double with the new Longitude
     */
    public void setGPSLongitude(double longitude){
        GPSLongitude= longitude;
        log.info("GPS longitude set to ", longitude);
    }

}
