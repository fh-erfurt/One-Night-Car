package de.onenightcar.domain.model.car;

import java.util.ArrayList;

/** Represents a OneNightCar.Car Management System
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
public class CarManagementSystem {
    public ArrayList<CombustionCar> combustionCarsList;
    public ArrayList<ElectricCar> electricCarsList;


    /** Create a CarManagementSystem with empty lists
     * a list for the Combustion cars and
     * a list for the Electric cars
     * */
    public CarManagementSystem(){
        this.combustionCarsList = new ArrayList<CombustionCar>();
        this.electricCarsList = new ArrayList<ElectricCar>();
    }


    /** gets the size of the electricCar list
     * @return  the size of electricCarList
     * */
    public int getSizeOfElectricCarsList(){
        return electricCarsList.size();
    }



    /** gets the Index(id) of the combustionCar list
     * @return  the Index of combustionCarList
     * @param combustionCar a Combustion OneNightCar.Car
     * */
    public int getCarIDFromCombustion(CombustionCar combustionCar)
    {
        return combustionCarsList.indexOf(combustionCar);
    }


    /** gets the Index(id) of the electricCar list
     * @return  the Index of electricCarList
     * @param electricCar an Electric OneNightCar.Car
     * */
    public int getCarIDFromElectric(ElectricCar electricCar)
    {
        return electricCarsList.indexOf(electricCar);
    }
}
