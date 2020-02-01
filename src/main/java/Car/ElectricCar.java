package Car;

import Person.Customer;

import javax.swing.text.Position;

/** Represents a Electric Car
 * extent Car
 * @see {@link Car}
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
public class ElectricCar extends Car {
    private float range;   // in Km
    private float chargePercent; //current


    /** Creates an ElectricCar with specified ElectricCar Parameters.
     * @param type A enum representing the Type of the Car
     * @param brand A String representing a Car Brand
     * @param model A String representing a Car Model
     * @param state A enum representing the State of the Car (Perfect, Ok, Damaged)
     * @param odometer A Long representing the odometer Number of the Car
     * @param GPSLatitude  A double representing the Car position
     * @param GPSLongitude A double representing the Car position
     * @param customerLevel A user Level from Customer representing the User Permission
     * @param price A float representing the costs of the Car per Day
     * @param range
     * @param chargePercent A float representing the electric Car charge
     */
    public ElectricCar(Type type, String brand, String model, State state,
                       long odometer, double GPSLatitude, double GPSLongitude, Customer.CustomerLevel customerLevel,
                       float price, float range, float chargePercent, CarManagementSystem carManagementSystem){
        super(type, brand, model, state,  GPSLatitude, GPSLongitude,odometer, customerLevel , price);
        this.range=range;
        this.chargePercent=chargePercent;
        carManagementSystem.electricCarsList.add(this);
    }
/**
 /** Creates an Electric Car Car  with default Values.
 * It is used to increment speed of UnitTests.
 * @param carManagementSystem A CarManagementSystem with the management from the Packet Car
 */
    public ElectricCar(CarManagementSystem carManagementSystem){
        super(Type.MINI,"BMW","i3", State.PERFECT, 50.9787, 11.03283,
                10999, Customer.CustomerLevel.NEWUSER , 69.00f);
        this.range= 200.00f;
        this.chargePercent= 100.00f;
        carManagementSystem.electricCarsList.add(this);
    }


    /** Gets the Charge Percent
     * @return The Electric Car current ChargePercent
     */
    public float getChargePercent(){
        return this.chargePercent;
    }


    /** Gets the range of an ElectricCar
     * @return The Electric Car current Range
     */
    public float getRange(){
        return this.range;
    }


    /** Change the Electric Car ChargePercent .
     * @param chargePercent
     */
    public void setChargePercent(float chargePercent){
        this.chargePercent = chargePercent;
    }



    /** set the Charge on 100 %
     */
    public void getChargedUp(){
        setChargePercent(100);
    }
}
