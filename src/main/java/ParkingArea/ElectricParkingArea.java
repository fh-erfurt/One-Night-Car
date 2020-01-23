package ParkingArea;

import Car.Car;

import java.util.ArrayList;

public class ElectricParkingArea extends ParkingArea {

    private int maxElectricCarCapacity;
    public ArrayList<Car> electricCarsInStation;

    public ElectricParkingArea(int parkID, String ParkingAreaAddress, int maxCapacity,
                               ArrayList carsInStation, ArrayList availableCars,
                               ArrayList notAvailableCars, int maxElectricCarCapacity,
                               ElectricParkingArea electricCarsInStation) {
        super();


        this.maxElectricCarCapacity = maxElectricCarCapacity;
        this.electricCarsInStation = new ArrayList<Car>();

    }

    public int getMaxElectricCarCapacity() {
        return this.maxElectricCarCapacity;
    }

    public void assignElectricCarToStation(Car carID) {
        electricCarsInStation.add(carID);
    }

    public void removeElectricCarFromStation(Car carID){
        electricCarsInStation.remove(carID);
    }
}
