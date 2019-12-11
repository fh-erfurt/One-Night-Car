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


    public  void setGPSLatitude(double latitude){
        GPSLatitude= latitude;
    }

    public void setGPSLongitude(double longitude){
        GPSLongitude= longitude;
    }

/**
 * this method is used to return the longitude and latitude GPS infos of the Object
 * @return  double[] This return is the Location */
    public double[] getGPSLocation(){
        return new double[]{this.GPSLatitude , this.GPSLongitude};
    }

}
