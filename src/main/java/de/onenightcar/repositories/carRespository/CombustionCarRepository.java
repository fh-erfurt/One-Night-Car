package de.onenightcar.repositories.carRespository;

import de.onenightcar.model.car.CombustionCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CombustionCarRepository extends CrudRepository<CombustionCar, Long> {
    @Query("from CombustionCar cc where cc.id=:id")
    CombustionCar GetOneByID(@Param("id") Long id);

    CombustionCar getById(Long id);

//    @Query("from Combustion_Car cr where cr.combustion_car_id=:")
//    List<CombustionCar> getAllByCombustionCarID(CombustionCar combustionCar);


}
