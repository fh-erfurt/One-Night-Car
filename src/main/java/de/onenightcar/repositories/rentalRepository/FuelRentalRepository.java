package de.onenightcar.repositories.rentalRepository;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.ElectricRental;
import de.onenightcar.model.rental.FuelRental;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FuelRentalRepository extends CrudRepository<FuelRental, Long> {
    List<FuelRental> getAllByCustomer(Customer customer);

//    List<FuelRental> getAllByDate(LocalDate date);
}
