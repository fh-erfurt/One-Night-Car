package de.onenightcar.repositories.rentalRepository;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.ElectricRental;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ElectricRentalRepository extends CrudRepository<ElectricRental, Long> {
    List<ElectricRental> getAllByCustomer(Customer customer);

    // TODO: Repair the Problem with the Time
    //List<ElectricRental> getAllByDate_DayOfYear(LocalDateTime date);
}
