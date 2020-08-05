package de.onenightcar.repositories.parkingAreaRepository;

import de.onenightcar.model.parkingArea.ElectricParkingArea;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectricParkingAreaRepository extends CrudRepository<ElectricParkingArea, Long> {
    Iterable<ElectricParkingArea> getAllByParkingAreaAddressCity(String city);

    ElectricParkingArea getById(Long id);
}
