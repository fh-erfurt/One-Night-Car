package de.onenightcar.repositories;

import de.onenightcar.model.rental.FuelRental;
import de.onenightcar.repositories.rentalRepository.FuelRentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FuelRentalRepositoryTest {

    @Autowired
    private FuelRentalRepository fuelRentalRepository;

    @Test
    public void the_right_rental_are_fetched_by_date () {
        //Bootstrap data is already loaded in the DB
        if(fuelRentalRepository.count() > 0) {
            LocalDate lc = LocalDate.of(2020,8,10);
            List<FuelRental> fuelRentalList = fuelRentalRepository.getAllByDate(lc);

            assertThat(fuelRentalList.get(0).getCustomer().getId() == 12L);
            assertThat(fuelRentalList.get(0).getCombustionCar().getId() == 39L);
        }
    }
}
