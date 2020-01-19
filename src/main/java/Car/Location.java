package Car;

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

    /** Change the Latitude Location
     * @param latitude
     */
    public  void setGPSLatitude(double latitude){
        GPSLatitude= latitude;
    }


    /** Change the Longitude Location
     * @param longitude
     */
    public void setGPSLongitude(double longitude){
        GPSLongitude= longitude;
    }


}
