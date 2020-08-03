package de.onenightcar.repositories.parkingAreaRepository;

import de.onenightcar.model.parkingArea.ParkingAreaAddress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingAreaAddressRepository extends CrudRepository<ParkingAreaAddress, Long> {
    @Query("SELECT distinct a.city from ParkingAreaAddress a")
    List<String> getDistinctCity();
}
