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
    private double GPSLongitude = 0.00;
    private double GPSLatitude = 0.00;

    /* /////////////////////Methods/////////////////////////// */

    public void Car(Type type, String brand, String model, State state, Transmission transmission, FuelType fuelType){
        // A Car manager should be done and here somehow the ID should be given
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.state = state;
        this.transmission = transmission;
        this.fuelType = fuelType;
    }

    public void changeCarState(State newCarState){
        this.state = newCarState;
    }

    public void setNewGPSlocation(double longitude, double latitude){
        this.GPSLongitude = longitude;
        this.GPSLatitude = latitude;
    }

}
