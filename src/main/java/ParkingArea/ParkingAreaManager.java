package ParkingArea;

import java.util.ArrayList;

public class ParkingAreaManager {

    public ArrayList<ParkingArea>            ParkingAreas;
    public ArrayList<ElectricParkingArea>    ElectricParkingAreas;
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


}
