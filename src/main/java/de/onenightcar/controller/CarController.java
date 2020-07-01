package de.onenightcar.controller;

import de.onenightcar.repositories.carRespository.CarLocationRepository;
import de.onenightcar.repositories.carRespository.CombustionCarRepository;
import de.onenightcar.repositories.carRespository.ElectricCarRepository;
import org.springframework.stereotype.Controller;


@Controller
public class CarController {

    private final CarLocationRepository carLocationRepository;
    private final CombustionCarRepository combustionCarRepository;
    private final ElectricCarRepository electricCarRepository;

    public CarController(CarLocationRepository carLocationRepository, CombustionCarRepository combustionCarRepository, ElectricCarRepository electricCarRepository) {
        this.carLocationRepository = carLocationRepository;
        this.combustionCarRepository = combustionCarRepository;
        this.electricCarRepository = electricCarRepository;
    }

}
