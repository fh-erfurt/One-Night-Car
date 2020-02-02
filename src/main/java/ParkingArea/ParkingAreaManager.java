package ParkingArea;

import Car.CombustionCar;

import java.util.ArrayList;

public class ParkingAreaManager {

    public static ArrayList<ParkingArea>            ParkingAreas;
    public static ArrayList<ElectricParkingArea>    ElectricParkingAreas;
    public int parkingAreaCounter;



    public ParkingAreaManager(){
        this.ParkingAreas           = new ArrayList<ParkingArea>();
        this.ElectricParkingAreas   = new ArrayList<ElectricParkingArea>();
        this.parkingAreaCounter = 1;
    }

    public  int getAndIncrementCounter(){
        int oldParkingAreaCounter = this.parkingAreaCounter;
        this.parkingAreaCounter++;
        return oldParkingAreaCounter;
    }

    public void addElectricParkingAreaIntoElectricParkingAreas(ElectricParkingArea electricParkingArea){
        this.ElectricParkingAreas.add(electricParkingArea);
    }

    public void addParkingAreaIntoParkingAreas(ParkingArea parkingArea){
        this.ParkingAreas.add(parkingArea);
    }

    public void removeElectricParkingAreaIntoElectricParkingAreas(ElectricParkingArea electricParkingArea){
        this.ElectricParkingAreas.remove(electricParkingArea);
    }


    public void removeParkingAreaIntoParkingAreas(ParkingArea parkingArea){
        this.ParkingAreas.remove(parkingArea);
    }

    public int getSizeOfElectricParkingAreas() {return ElectricParkingAreas.size() ;}

    public int getSizeOfParkingAreas() {return ParkingAreas.size() ;}

    public int getParkIDFromElectricParkingAreas(ElectricParkingArea electricParkingArea) {
        return ElectricParkingAreas.indexOf(electricParkingArea);
    }

    public int getParkIDFromParkingAreas(ParkingArea parkingArea){
        return ParkingAreas.indexOf(parkingArea);
    }

    protected int returnParkingAreaWithIndex(ParkingArea parkingArea) {                      //protected for Testing purposes
        int ParkingAreaIndex;
        for (ParkingAreaIndex = 0; ParkingAreaIndex < ParkingAreas.size(); ParkingAreaIndex++) {
            if (parkingArea == ParkingAreas.get(ParkingAreaIndex)) {
                break;
            }
        }
        return ParkingAreaIndex;

    }

    protected int returnElectricParkingAreaWithIndex(ElectricParkingArea electricParkingArea) {                      //protected for Testing purposes
        int ElectricParkingAreaIndex;
        for (ElectricParkingAreaIndex = 0; ElectricParkingAreaIndex < ElectricParkingAreas.size();
             ElectricParkingAreaIndex++) {
            if (electricParkingArea == ParkingAreas.get(ElectricParkingAreaIndex)) {
                break;
            }
        }
        return ElectricParkingAreaIndex;

    }


}
