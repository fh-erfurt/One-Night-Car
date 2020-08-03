package de.onenightcar.repositories.rentalRepository;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.ElectricRental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ElectricRentalRepository extends CrudRepository<ElectricRental, Long> {
    List<ElectricRental> getAllByCustomer(Customer customer);

    @Query("from ElectricRental er where er.rentalDate=:date")
    List<ElectricRental> getAllByDate(@Param("date") LocalDate date);
}
