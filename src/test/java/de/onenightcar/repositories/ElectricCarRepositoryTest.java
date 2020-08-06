package de.onenightcar.repositories;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.car.ElectricCar;
import de.onenightcar.repositories.carRespository.ElectricCarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ElectricCarRepositoryTest {

    @Autowired
    ElectricCarRepository electricCarRepository;

    @Test
    public void the_right_car_should_be_delivered_with_the_id () {
        //Bootstrap data is already loaded in the DB
        if(electricCarRepository.count() > 0) {
            ElectricCar electricCar = electricCarRepository.GetOneByID(51L);
            assertThat(electricCar.getBrand() == "BMW");
            assertThat(electricCar.getModel() == "i3s");
        }
    }
}
