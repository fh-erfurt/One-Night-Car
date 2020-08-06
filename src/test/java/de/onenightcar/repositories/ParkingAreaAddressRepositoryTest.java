package de.onenightcar.repositories;

import de.onenightcar.repositories.parkingAreaRepository.ParkingAreaAddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ParkingAreaAddressRepositoryTest {

    @Autowired
    ParkingAreaAddressRepository parkingAreaAddressRepository;

    @Test
    public void the_right_cities_should_be_delivered () {
        //Bootstrap data is already loaded in the DB
        if(parkingAreaAddressRepository.count() > 0) {
            List<String> cities = parkingAreaAddressRepository.getDistinctCity();

            assertThat(cities.contains("Jena"));
            assertThat(cities.contains("Erfurt"));
            assertThat(cities.contains("Weimar"));
            assertThat(cities.size() == 3);
        }
    }
}
