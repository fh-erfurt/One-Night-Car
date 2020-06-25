package de.onenightcar.repositories.carRespository;

import de.onenightcar.model.car.CarLocation;
import org.springframework.data.repository.CrudRepository;

public interface CarLocationRepository extends CrudRepository<CarLocation, Long> {
}
