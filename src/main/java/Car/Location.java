package Car;
/**
 *  <h2> Location class </h2>
 *  it has the GPS information
 *  @author OneNightCar Team
 *  @version 1.0
 *  @since 2019-12-11
 */

public class Location {
    private double GPSLatitude;
    private double GPSLongitude;


    public  void setGPS(double GPSLatitude, double GPSLongitude){
        this.GPSLongitude=GPSLongitude;
        this.GPSLatitude= GPSLatitude;
    }

/**
 * this method is used to return the longitude and latitude GPS infos of the Object
 * @return  double[] This return is the Location */
    public double[] getGPSLocation(){
        return new double[]{this.GPSLatitude , this.GPSLongitude};
    }

}
