package Car;

import java.util.ArrayList;

/**
 * <h2> Cars Management System  class </h2>
 * it has lists of the cars
 * @see {@link ElectricCar}
 * @see {@link CombustionCar}
 *
 * @author OneNightCar Team
 * @version 1.1.0
 * @since 2020-01-18*/

public class CarManagementSystem {
    public ArrayList<CombustionCar> combustionCarsList;
    public ArrayList<ElectricCar> electricCarsList;

    public CarManagementSystem(){
        this.combustionCarsList = new ArrayList<CombustionCar>();
        this.electricCarsList = new ArrayList<ElectricCar>();
    }

/**
 * Method to Add a electric Car to the Array List
 * @param electricCar
 * the Position of the added Car is at the End of the List
 *
 * @see {@link ElectricCar}*/
    public void addCarIntoElectrics(ElectricCar electricCar)
    {
        this.electricCarsList.add(electricCar);
    }


    /**
     * Method to Add a combustion Car to the Array List
     * @param combustionCar
     * the Position of the added Car is at the End of the List
     *
     * @see {@link CombustionCar}*/
    public void addCarIntoCombustion(CombustionCar combustionCar)
    {

        this.combustionCarsList.add(combustionCar);
    }

    /**
     * Method to Delete a electric Car from the Array List
     * @param electricCar
     *
     * @see {@link ElectricCar}*/

    public void deleteCarFromElectric(ElectricCar electricCar){
        this.electricCarsList.remove(electricCar);
    }

    /**
     * Method to Delete a combustion Car from the Array List
     * @param combustionCar
     *
     * @see {@link CombustionCar}*/
    public void deleteCarFromCombustion(CombustionCar combustionCar){
        this.combustionCarsList.remove(combustionCar);
    }

    public int getSizeOfElectricCarsList(){
        return electricCarsList.size();
    }

    public int getSizeOfCombustionCarsList(){
        return combustionCarsList.size();
    }

    public void getCarIDFromElectrics(String brandName)
    {
        int index;
        CarManagementSystem listsAdding = new CarManagementSystem();
        for (index = 0; index < listsAdding.combustionCarsList.size(); index++)
        {
            if(listsAdding.combustionCarsList.get(index).brand == brandName)
            {
                System.out.println("index: "+ index);
            }
        }
    }
}
