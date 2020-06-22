package de.onenightcar.bootstrap;

import de.onenightcar.model.person.PaymentMethod;
import de.onenightcar.repositories.carRespository.CombustionCarRepository;
import de.onenightcar.repositories.personRepository.PaymentMethodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BootStrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);

    //Person Package
    private final PaymentMethodRepository paymentMethodRepository;

    //ParkingArea Package


    //Car Package
    private final CombustionCarRepository combustionCarRepository;

    //RentalPackage


    //TODO: If you add something above this, change the constructor underneath this!!
    public BootStrapData(CombustionCarRepository combustionCarRepository, PaymentMethodRepository paymentMethodRepository) {
        this.combustionCarRepository = combustionCarRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Started in Bootstrap");

        ///////Person Package///////

        //Payment Method

        PaymentMethod pm1 = new PaymentMethod();
        LocalDateTime validTrough = LocalDateTime.of(2021,02,20,10,10);
        PaymentMethod pm2 = new PaymentMethod("1111 1111 1111 1111", PaymentMethod.CardType.DEBIT, validTrough, "225");

        try{
            paymentMethodRepository.save(pm1);
            paymentMethodRepository.save(pm2);
        } catch (Exception e) {
            log.debug("Exception" + e);
        }

        log.info("Number of Payment Methods added: " + paymentMethodRepository.count());

        //Person Address

        //Customer

        //Employee

        //Admin

        ///////ParkingArea Package///////

        //Parking Area Address

        //Parking Area

        //Electric Parking Area

        ///////Car Package///////

        //Car Location

        //Combustion Car

        //Electric Car

        ///////RentalPackage///////

        //Fuel Rental

        //Electric Rental

    }
}
