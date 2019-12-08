package projekt;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    List cars = new List();
    Car car1 = new Car(Car.Type.MIDDLE, "Mercedes", "S500", Car.State.PERFECT,
            Car.Transmission.AUTOMATIC, Car.FuelType.HYBRID, 13, 300, 100, cars);
    //List rentals = new List();
    //Rental rental1 = new Rental(car1, 1, format.parse() , 12, 13, rentals);


    @Test
    public void test_Get_Fuel_Type() {

        assertTrue(car1.getFuelType() == Car.FuelType.HYBRID);
    }

    @Test
    public void should_change_Car_State() {

        car1.changeCarState(Car.State.OK);

        assertTrue(Car.State.OK == car1.getCarState());
    }

    @Test
    public void test_CarID() {
        assertTrue(car1.getCarID() == 0);
    }
}


