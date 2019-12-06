package projekt;

import java.util.ArrayList;

public class List {

    // This Class should just create one Object (Works like a database)

    public ArrayList<Integer> customersID;
    public ArrayList<Integer> employeesID;
    public ArrayList<Integer> carsID;
    public ArrayList<Integer> parkingAreasID;
    public ArrayList<Integer> rentalsID;

    /* /////////////////////Methods/////////////////////////// */

    public List(){
        this.customersID = new ArrayList<Integer>();
        this.employeesID = new ArrayList<Integer>();
        this.carsID = new ArrayList<Integer>();
        this.parkingAreasID = new ArrayList<Integer>();
        this.rentalsID = new ArrayList<Integer>();
    }

    public int getSizeOfCustomersID(){
        return this.customersID.size();
    }

    public int getSizeOfEmployeeID(){
        return this.employeesID.size();
    }

    public int getSizeOfCarsID(){
        return this.carsID.size();
    }

    public int getSizeOfParkingAreasID(){
        return this.parkingAreasID.size();
    }

    public int getSizeOfRentalsID (){
        return this.rentalsID.size();
    }
}
