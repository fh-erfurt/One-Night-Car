package de.onenightcar.repositories.rentalRepository;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.FuelRental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FuelRentalRepository extends CrudRepository<FuelRental, Long> {
    List<FuelRental> getAllByCustomer(Customer customer);

    @Query("from FuelRental fr where fr.rentalDate=:date")
    List<FuelRental> getAllByDate(@Param("date") LocalDate date);
}
