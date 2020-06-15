package de.onenightcar.domain.model.car;

import de.onenightcar.domain.model.parkingArea.ElectricParkingArea;
import de.onenightcar.domain.model.person.Customer;

import javax.persistence.Entity;

/** Represents a Electric OneNightCar.Car
 * extent OneNightCar.Car
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

@Entity
public class ElectricCar extends Car {

    /* /////////////////////Attributes/////////////////////////// */

    private float electricalRange;         //in Km
    private float chargePercent; //current

    /* /////////////////////Constructors/////////////////////////// */

    // Needed to be able to create the entity
    public ElectricCar() {}

    /** Creates an ElectricCar with specified ElectricCar Parameters.
     * @param type A enum representing the Type of the OneNightCar.Car
     * @param brand A String representing a OneNightCar.Car Brand
     * @param model A String representing a OneNightCar.Car Model
     * @param state A enum representing the State of the OneNightCar.Car (Perfect, Ok, Damaged)
     * @param odometer A Long representing the odometer Number of the OneNightCar.Car
     * @param GPSLatitude  A double representing the OneNightCar.Car position
     * @param GPSLongitude A double representing the OneNightCar.Car position
     * @param customerLevel A user Level from Customer representing the User Permission
     * @param price A float representing the costs of the OneNightCar.Car per Day
     * @param electricalRange A float representing the range the car can drive before it needs to be recharged
     * @param chargePercent A float representing the electric OneNightCar.Car charge
     */
    public ElectricCar(Type type, String brand, String model, State state,
                       long odometer, double GPSLatitude, double GPSLongitude, Customer.CustomerLevel customerLevel,
                       float price, float electricalRange, float chargePercent,  ElectricParkingArea electricParkingArea){
                    super(type, brand, model, state,  GPSLatitude, GPSLongitude, odometer, customerLevel , price);

        this.electricalRange = electricalRange;
        this.chargePercent=chargePercent;

        if(electricParkingArea.numberOfElectricCarsAssignedToStation() < electricParkingArea.getMaxElectricCarCapacity()) {
            electricParkingArea.assignElectricCarToStation(this);
        }
        else{
            System.out.println("there is no more place in this park!");
        }
    }
/**
 /** Creates an Electric OneNightCar.Car OneNightCar.Car  with default Values.
 * It is used to increment speed of UnitTests.
 * @param electricParkingArea A CarManagementSystem with the management from the Packet OneNightCar.Car
 */
    public ElectricCar( ElectricParkingArea electricParkingArea){
        super(Type.MINI,"BMW","i3", State.PERFECT, 50.9787, 11.03283,
                10999, Customer.CustomerLevel.NEWUSER , 69.00f);
        this.electricalRange = 200.00f;
        this.chargePercent= 100.00f;
        if(electricParkingArea.numberOfElectricCarsAssignedToStation() < electricParkingArea.getMaxElectricCarCapacity()) {
            electricParkingArea.assignElectricCarToStation(this);
        }
        else{
            System.out.println("there is no more place in this parking Area!");
        }
    }

    /* /////////////////////Methods/////////////////////////// */

    /** Gets the Charge Percent
     * @return The Electric OneNightCar.Car current ChargePercent
     */
    public float getChargePercent(){
        return this.chargePercent;
    }

    /** Change the Electric OneNightCar.Car ChargePercent .
     * @param chargePercent a float representing the new charge level
     */
    public void setChargePercent(float chargePercent){
        try {
            this.chargePercent = chargePercent;
        }
        catch(Exception e){
            System.out.print("Setting charge percent has failed!");
        }
    }

    /** Gets the range of an ElectricCar
     * @return The Electric OneNightCar.Car current Range
     */
    public float getElectricalRange(){
        return this.electricalRange;
    }

    public void setElectricalRange(float range) { this.electricalRange = range;}

    /** set the Charge on 100 %
     */
    public void getChargedUp(){
        setChargePercent(100);
    }
}
