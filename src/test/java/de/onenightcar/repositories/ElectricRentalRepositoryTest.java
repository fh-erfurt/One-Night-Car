package de.onenightcar.repositories;

import de.onenightcar.model.rental.ElectricRental;
import de.onenightcar.model.rental.FuelRental;
import de.onenightcar.repositories.rentalRepository.ElectricRentalRepository;
import de.onenightcar.repositories.rentalRepository.FuelRentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ElectricRentalRepositoryTest {

    @Autowired
    private ElectricRentalRepository electricRentalRepository;

    @Test
    public void the_right_rental_are_fetched_by_date () {
        //Bootstrap data is already loaded in the DB
        if(electricRentalRepository.count() > 0) {
            LocalDate lc = LocalDate.of(2020,8,10);
            List<ElectricRental> electricRentals = electricRentalRepository.getAllByDate(lc);

            assertThat(electricRentals.get(0).getCustomer().getId() == 10L);
            assertThat(electricRentals.get(0).getElectricCar().getId() == 51L);
        }
    }
}
