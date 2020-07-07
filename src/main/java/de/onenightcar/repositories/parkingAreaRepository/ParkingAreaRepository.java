package de.onenightcar.repositories.parkingAreaRepository;

import de.onenightcar.model.parkingArea.ParkingArea;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingAreaRepository extends CrudRepository<ParkingArea, Long> {
    public List<ParkingArea> getAllByParkingAreaAddressCity(String city);
}
