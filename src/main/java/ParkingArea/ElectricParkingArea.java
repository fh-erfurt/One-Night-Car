package ParkingArea;

import Car.Car;
import Car.CombustionCar;
import Car.CarManagementSystem;
import Car.ElectricCar;

import java.util.ArrayList;

public class ElectricParkingArea extends ParkingArea {

    private int maxElectricCarCapacity;
    public ArrayList<Car> electricCarsInStation;

    public ElectricParkingArea(int parkID, ParkingAreaAddress ParkingAreaAddress, int maxCapacity,
                               int maxElectricCarCapacity, ParkingAreaManager parkingAreaManager) {
        super(parkID, ParkingAreaAddress, maxCapacity, parkingAreaManager);


        this.maxElectricCarCapacity = maxElectricCarCapacity;
        this.electricCarsInStation = new ArrayList<Car>();
        parkingAreaManager.ElectricParkingAreas.add(this);

    }

    public ElectricParkingArea(ParkingAreaManager parkingAreaManager){
        super(2,new ParkingAreaAddress(), 100, parkingAreaManager);

        this.maxElectricCarCapacity = 100;

    }

    public int getMaxElectricCarCapacity() {
        return this.maxElectricCarCapacity;
    }

    public void assignElectricCarToStation(ElectricCar electricCar) {
        electricCarsInStation.add(electricCar);
    }

    public void removeElectricCarFromStation(ElectricCar electricCar){
        electricCarsInStation.remove(electricCar);
    }
}
