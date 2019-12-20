package Person;

import Car.*;
import ZuLöschen.List;

import java.util.GregorianCalendar;
import java.util.Random;

public class Employee extends Person {

    /* /////////////////////Attributes///////////////////////// */

    private int employeeID;
    private float salary;
    private TypeOfActivity typeOfActivity;
    private enum TypeOfActivity{
        CUSTOMERSUPPORT,
        MAINTAINER,
        BOSS;
    }

    /* /////////////////////Methods/////////////////////////// */


    public static void employeeHelpsCustomer(int customerId){
        /* *********** we don't know how to help our Customer (yet) **********
        * the idea is to do something with an interface like start a chat or something like that*/
    }

    // Used to generate Random Booleans for employeeRepairsCar
    public boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public void employeeRepairsCar(Car car){
        if(car.getCarState() == car.getCarState().DAMAGED){
            boolean carSuccessfullyRepaired;
            /* *********** Repairs with the magical powers of Employee ********** */
            carSuccessfullyRepaired = getRandomBoolean();
            if (carSuccessfullyRepaired == true){
                System.out.println("We were able to fix the car");
                car.changeCarState(Car.State.OK);
            }
            else{
                System.out.println("Sorry the car is not repairable");
                car.changeCarState(Car.State.DAMAGED);
            }
        }
    }

    /* public void employeeRepairsElectricCar(ElectricCar electricCar) {
        if(ElectricCar.getCarState() == ElectricCar.getCarState().DAMAGED){
            boolean carSuccessfullyRepaired;
            // *********** Repairs with the magical powers of Employee **********
            carSuccessfullyRepaired = getRandomBoolean();
            if (carSuccessfullyRepaired == true){
                System.out.println("We were able to fix the car");
                car.changeCarState(Car.State.OK);
            }
            else{
                System.out.println("Sorry the car is not repairable");
                car.changeCarState(Car.State.DAMAGED);
            }
        }
    }
    */

}




