package de.onenightcar.repositories.carRespository;

import de.onenightcar.model.car.ElectricCar;
import org.springframework.data.repository.CrudRepository;

public interface ElectricCarRepository extends CrudRepository<ElectricCar, Long> {
}
