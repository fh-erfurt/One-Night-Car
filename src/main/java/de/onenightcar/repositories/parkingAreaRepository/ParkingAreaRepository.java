package de.onenightcar.repositories.parkingAreaRepository;

import de.onenightcar.model.parkingArea.ParkingArea;
import org.springframework.data.repository.CrudRepository;

public interface ParkingAreaRepository extends CrudRepository<ParkingArea, Long> {
    Iterable<ParkingArea> getAllByParkingAreaAddressCity(String city);

    ParkingArea getById(Long id);
}
