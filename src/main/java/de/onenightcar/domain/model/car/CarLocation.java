package de.onenightcar.domain.model.car;

import de.onenightcar.domain.storage.core.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/** Represents a Location
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */


@Entity
public class CarLocation extends AbstractDatabaseEntity {

    /* /////////////////////Attributes/////////////////////////// */

    private double GPSLatitude;
    private double GPSLongitude;

    /* /////////////////////Constructors/////////////////////////// */

    public CarLocation(){}

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
        }
        catch(Exception e){
            System.out.print("Latitude inadmissible!");
        }
    }

    public double getGPSLongitude(){return this.GPSLongitude;}

    /** Change the Longitude Location
     * @param longitude a double with the new Longitude
     */
    public void setGPSLongitude(double longitude){
        GPSLongitude= longitude;
    }

}
