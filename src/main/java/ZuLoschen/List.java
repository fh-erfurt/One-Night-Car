package ZuLoschen;

import Car.Car;
import ParkingArea.ParkingArea;
import Person.Customer;
import Person.Employee;
import Rental.Rental;

import java.util.ArrayList;

public class List {

    // This Class should just create one Object (Works like a database)

    public ArrayList<Customer> customers;
    public ArrayList<Employee> employees;
    public ArrayList<Car> cars;
    public ArrayList<ParkingArea> parkingAreas;
    public ArrayList<Rental> rentals;

    /* /////////////////////Methods/////////////////////////// */

    public List(){
        this.customers = new ArrayList<Customer>();
        this.employees = new ArrayList<Employee>();
        this.cars = new ArrayList<Car>();
        this.parkingAreas = new ArrayList<ParkingArea>();
        this.rentals = new ArrayList<Rental>();
    }

    public int getSizeOfCustomers(){
        return this.customers.size();
    }

    public int getSizeOfEmployees(){
        return this.employees.size();
    }

    public int getSizeOfCars(){
        return this.cars.size();
    }

    public int getCarIDFromCars(int i){
        return returnCarWithIndex(i).getCarID();
    }

    public Car returnCarWithIndex(int index){
        return cars.get(index);
    }

    public int getSizeOfParkingAreas(){
        return this.parkingAreas.size();
    }

    public int getSizeOfRentals(){
        return this.rentals.size();
    }
}
