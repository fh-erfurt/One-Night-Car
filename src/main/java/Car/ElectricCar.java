package Car;

import javax.swing.text.Position;

/**
 *  <h2> ElectricCar class </h2>
 *  it has the Information about the electric cars
 *  it's the subclass of Car class
 *
 *  @author OneNightCar Team
 *  @version 1.0
 *  @since 2019-12-12
 */
public class ElectricCar extends Car {
    private float range;   // in Km
    private float chargePercent;


/**
 * Constructor with Parameter for class ElectricCar*/
    public ElectricCar(Type type, String brand, String model, State state,
                       long odometer, double GPSLatitude, double GPSLongitude, String permission,
                       float price, float range, float chargePercent){
        super(type, brand, model,state,GPSLatitude,GPSLongitude, odometer,permission,price);
        this.range=range;
        this.chargePercent=chargePercent;


    }
/**
 * default Constructor for test */
    public ElectricCar(){
        super(Type.MINI,"BMW","i3", state.PERFECT, 50.9787, 11.03283,
                10999, "REGULARUSER", 69.00f);
        this.range= 200.00f;
        this.chargePercent= 100.00f;

    }

    private float getChargePercent(){
        return this.chargePercent;
    }
}
