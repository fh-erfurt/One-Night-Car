package de.onenightcar.repositories.carRespository;

import de.onenightcar.model.car.ElectricCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ElectricCarRepository extends CrudRepository<ElectricCar, Long> {
    @Query("from ElectricCar cc where cc.id=:id")
    ElectricCar GetOneByID(@Param("id") Long id);
}
