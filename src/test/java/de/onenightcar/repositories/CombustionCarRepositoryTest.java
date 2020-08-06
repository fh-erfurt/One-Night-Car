package de.onenightcar.repositories;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.repositories.carRespository.CombustionCarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CombustionCarRepositoryTest {

    @Autowired
    CombustionCarRepository combustionCarRepository;

    @Test
    public void the_right_car_should_be_delivered_with_the_id () {
        //Bootstrap data is already loaded in the DB
        if(combustionCarRepository.count() > 0) {
            CombustionCar combustionCar = combustionCarRepository.GetOneByID(39L);
            assertThat(combustionCar.getBrand() == "Opel");
            assertThat(combustionCar.getModel() == "Insignia");
        }
    }
}
