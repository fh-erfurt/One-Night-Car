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



    public ElectricCar(Type type, String brand, String model, State state,
                       long odometer, double GPSLatitude, double GPSLongitude, String permission,
                       float price, float range, float chargePercent){
        this.type = type;
        this.brand = brand;
        super.model= model;
        super.state= state;
        super.odometer= odometer;
        Location location = new Location(GPSLatitude,GPSLongitude);
        super.permission=permission;
        super.price=price;
        this.range=range;
        this.chargePercent=chargePercent;


        // fragen: was ist richtiger this oder super?

    }

    public ElectricCar(){
        this.type= type.MINI;
        this.brand= "BMW";
        this.model= "i3";
        this.state= state.PERFECT;
        this.odometer = 10999;
        Location location = new Location(50.9787, 11.03283);
        this.permission = "REGULARUSER";
        this.price= 69.00f;
        this.range= 200.00f;
        this.chargePercent= 100.00f;

    }

    private float getChargePercent(){
        return this.chargePercent;
    }
}
