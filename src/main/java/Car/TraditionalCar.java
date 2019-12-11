package Car;

public class TraditionalCar extends CombustionCar {


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


}
