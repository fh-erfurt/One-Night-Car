package projekt;

public class Car {


    /* /////////////////////Attributes///////////////////////// */

    private int carID;
    private Type type;
    public enum Type{
        MINI,
        LITTLE,
        UTILITARIAN,
        COMPACT,
        MINIVAN,
        MIDDLE,
        VAN,
        SUV;
    }
    private String brand;
    private String model;
    private State state;
    public enum State{
        PERFECT,
        OK,
        DAMAGED;
    }
    private Transmission transmission;
    public enum Transmission{
        MANUAL,
        AUTOMATIC;
    }
    private FuelType fuelType;
    public enum FuelType{
        PETROL,
        DIESEL,
        HYBRID,
        ELECTRIC;
    }
    private float consumption;              //How many liters does the car need to do 1 KM
    private float tankSize;                 //In liters
    private float fuelLevel = 100;          // 100 is Full, 0 is Empty
    private long odometer = 0;
    private double GPSLongitude = 0.00;
    private double GPSLatitude = 0.00;
    private float price;                   //Price pro hour

    /* /////////////////////Methods/////////////////////////// */

    public Car (Type type, String brand, String model, State state, Transmission transmission, FuelType fuelType,
                float consumption, float price, float tankSize, List list) {
        carID = list.getSizeOfCarsID();     //Creates a running counter of cars in list
        list.carsID.add(carID);             //Adds the new car to the global list
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.state = state;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.consumption = consumption;
        this.price = price;
        this.tankSize = tankSize;
    }

    public void changeCarState (State newCarState) {

        this.state = newCarState;

    }

    public State getCarState(){
        return this.state;
    }

    public void setNewGPSLocation (double longitude, double latitude){
        this.GPSLongitude = longitude;
        this.GPSLatitude = latitude;
    }

    public double getGPSLongitude () {
     return this.GPSLongitude;
    }

    public double getGPSLatitude ()  {
        return this.GPSLatitude;
    }

    public float getFuelLevel () {
        return this.fuelLevel;
    }

    public float calculateRemainingFuelInTank (Rental rental) {
        return (tankSize - ((rental.getOdometerAfter() - this.odometer) * consumption));
    }

    public void setFuelLevel (Rental rental) {
        this.fuelLevel = (calculateRemainingFuelInTank(rental) * 100) / tankSize;
    }

    public float getPrice (){
        return this.price;
    }

    public int getCarID (){
        return this.carID;
    }

    public long getOdometer (){
        return this.odometer;
    }

    public void setOdometer (Rental rental) {
        this.odometer = rental.getOdometerAfter();
    }

    public FuelType getFuelType(){
        return this.fuelType;
    }

    public float getTankSize(){
        return this.tankSize;
    }
}
