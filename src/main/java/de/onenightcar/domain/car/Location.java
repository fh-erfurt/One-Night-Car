package de.onenightcar.domain.car;

/** Represents a Location
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class Location {
    private double GPSLatitude;
    private double GPSLongitude;


    /***
     * @param GPSLatitude  A double representing the position
     * @param GPSLongitude A double representing the position
     */
    public Location(double GPSLatitude, double GPSLongitude){
        this.GPSLatitude = GPSLatitude;
        this.GPSLongitude = GPSLongitude;
    }

    public double getGPSLatitude(){return this.GPSLatitude;}

    /** Change the Latitude Location
     * @param latitude a double with the new Latitude
     */
    public  void setGPSLatitude(double latitude){
        GPSLatitude= latitude;
    }

    public double getGPSLongitude(){return this.GPSLongitude;}

    /** Change the Longitude Location
     * @param longitude a double with the new Longitude
     */
    public void setGPSLongitude(double longitude){
        GPSLongitude= longitude;
    }

}
