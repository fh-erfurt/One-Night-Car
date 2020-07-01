package de.onenightcar.repositories.rentalRepository;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.FuelRental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuelRentalRepository extends CrudRepository<FuelRental, Long> {
    List<FuelRental> getAllByCustomer(Customer customer);
}
