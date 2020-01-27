package ParkingArea;

/** Represents a ParkingAreaAddress
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class ParkingAreaAddress {


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


    public ParkingAreaAddress(){
        this.ZIP = "99085";
        this.city = "Erfurt";
        this.street = "Altonaer Str.";
        this.streetNumber = "25";
    }

    public String getZIP() {return this.ZIP;}



    public String getCity() {return this.city;}



    public String getStreet() {return this.street;}



    public String getStreetNumber() {return this.streetNumber;}


}
