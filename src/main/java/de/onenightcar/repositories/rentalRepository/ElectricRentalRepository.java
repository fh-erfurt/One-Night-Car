package de.onenightcar.repositories.rentalRepository;

import de.onenightcar.model.rental.ElectricRental;
import org.springframework.data.repository.CrudRepository;

public interface ElectricRentalRepository extends CrudRepository<ElectricRental, Long> {
}
