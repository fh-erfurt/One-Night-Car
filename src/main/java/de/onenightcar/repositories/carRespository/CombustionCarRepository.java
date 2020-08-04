package de.onenightcar.repositories.carRespository;

import de.onenightcar.model.car.CombustionCar;
import de.onenightcar.model.rental.FuelRental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CombustionCarRepository extends CrudRepository<CombustionCar, Long> {
    @Query("from CombustionCar cc where cc.id=:id")
    CombustionCar GetOneByID(@Param("id") Long id);
}
