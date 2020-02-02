package ParkingArea;

import Car.Car;
import Car.CombustionCar;
import Car.CarManagementSystem;
import Car.ElectricCar;

import java.util.ArrayList;

public class ElectricParkingArea extends ParkingArea {

    private int maxElectricCarCapacity;
    public ArrayList<ElectricCar> electricCarsInStation;
    public ArrayList<ElectricCar> availableElectricCars;
    public ArrayList<ElectricCar> notAvailableElectricCars;

    public ElectricParkingArea(int parkID, ParkingAreaAddress ParkingAreaAddress, int maxCapacity,
                               int maxElectricCarCapacity, ParkingAreaManager parkingAreaManager) {
        super(parkID, ParkingAreaAddress, maxCapacity, parkingAreaManager);

        this.maxElectricCarCapacity = maxElectricCarCapacity;
        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
        parkingAreaManager.ElectricParkingAreas.add(this);

    }

    public ElectricParkingArea(ParkingAreaManager parkingAreaManager){
        super(2,new ParkingAreaAddress(), 100, parkingAreaManager);

        this.electricCarsInStation = new ArrayList<ElectricCar>();
        this.availableElectricCars = new ArrayList<ElectricCar>();
        this.notAvailableElectricCars = new ArrayList<ElectricCar>();
        this.maxElectricCarCapacity = 100;
    }

    public int getMaxElectricCarCapacity() {
        return this.maxElectricCarCapacity;
    }

    public void setMaxElectricCarCapacity(int maxElectricCarCapacity) {
        this.maxElectricCarCapacity = maxElectricCarCapacity;
    }

    public void assignElectricCarToStation(ElectricCar electricCar) {
        electricCarsInStation.add(electricCar);
    }

    public void removeElectricCarFromStation(ElectricCar electricCar){
        electricCarsInStation.remove(electricCar);
    }

    public int getElectricCarID(ElectricCar electricCar) {
        return electricCarsInStation.indexOf(electricCar);
    }
}
