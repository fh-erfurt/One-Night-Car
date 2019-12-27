package Car;
/**
 *  <h2> TraditionalCar class </h2>
 *  it has the Information about the Traditional cars
 *  it's the subclass of CombustionCar class
 *
 *  @author OneNightCar Team
 *  @version 1.0
 *  @since 2019-12-27
 */
public class TraditionalCar extends CombustionCar {

    /* /////////////////////Attributes///////////////////////// */

        private Transmission transmission;
        private enum  Transmission{
            MANUAL,
            AUTOMATIC;
        }
    private FuelType fuelType;
    private enum FuelType{
        PETROL,
        DIESEL;
    }

    /* /////////////////////Methods///////////////////////// */

    /** Constructor with Parameter
     * @param transmission
     * @param fuelType
     * plus the parameters of the father Class CombustionCar
     */
    public TraditionalCar (Type type, String brand, String model, State state,
                           double GPSLatitude,double GPSLongitude, long odometer,
                           String permission, float price, double tankSize,
                           double fuelLevel, double consumption, Transmission transmission,
                           FuelType fuelType){
        super(type, brand, model, state, GPSLatitude, GPSLongitude, odometer,
                permission, price, tankSize, fuelLevel, consumption);
        this.transmission = transmission;
        this.fuelType = fuelType;
    }

/** Creates a Traditional Car with default Values.
 * It is used to increment speed of UnitTests.
 * */
    public TraditionalCar(){
        super(Type.COMPACT, "VolksWagen", "Golf_8", State.OK,
                50.984790, 11.041410, 197212, "NEWUSER", 39.99f,
                75, 69, 9);
        this.transmission = Transmission.MANUAL;
        this.fuelType = FuelType.DIESEL;
    }

    public void setFuelLevel(double fuelLevel){
         boolean isReturned = false;
         if(isReturned){
             super.setFuelLevel(fuelLevel);
         }

    }
}
