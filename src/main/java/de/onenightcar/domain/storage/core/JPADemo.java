package de.onenightcar.domain.storage.core;

import de.onenightcar.domain.model.car.CarManagementSystem;
import de.onenightcar.domain.model.car.CombustionCar;
import de.onenightcar.domain.model.parkingArea.ParkingArea;
import de.onenightcar.domain.model.parkingArea.ParkingAreaManager;
import de.onenightcar.domain.model.person.*;
import de.onenightcar.domain.model.rental.FuelRental;
import de.onenightcar.domain.model.rental.RentalManager;
import de.onenightcar.domain.storage.DatabaseConnection;
import de.onenightcar.domain.storage.packageRepositories.carRespository.PersonAddressRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static de.onenightcar.domain.storage.packageRepositories.personRepository.CustomerDAO.persistCustomer;


// This class it´s just there for testing purposes //
public class JPADemo {

    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final DataController dc = DataController.getInstance();

    private static final EntityManagerFactory emf = dc.getEntityManagerFactory();

    public static void main(String[] args) throws Exception {

        EntityManager em = emf.createEntityManager();

        PersonAddress personAddress = new PersonAddress();

//        // Save the Person Address
//        em.getTransaction().begin();
//        em.persist(personAddress);
//        em.getTransaction().commit();
//
//        //Used to modify and check the changes in DB
//        em.getTransaction().begin();
//        personAddress.setZIP("00000");
//        em.getTransaction().commit();

//        // Read existing entries
//        Query q = em.createQuery("select t from PersonAddress t");
//        List<PersonAddress> personAddressList = q.getResultList();
//        for (PersonAddress personAddresses : personAddressList) {
//            System.out.println(personAddresses);
//        }
//        System.out.println("Size: " + personAddressList.size());
//
//        // Try with the DatabaseConnection directly
//        Connection conn = DatabaseConnection.getConnection();
//        PersonAddressRepository.printAllPersonsAddressesFromDatabase(conn);
//
//        DatabaseConnection.disconnectDatabase(conn);


        //////////////////////////////////////////////////////////////////////////


//        RentalManager rentalManager = new RentalManager();
//
//        CarManagementSystem carManagementSystem = new CarManagementSystem();
//
//        PersonManager personManager = new PersonManager();
//
//        PaymentMethod pm = new PaymentMethod();
//        PersonAddress pa = new PersonAddress();
//        LocalDateTime date = LocalDateTime.now();
//
//        Customer customer = new Customer("firstName", "surname", date, pa, personManager, Customer.CustomerLevel.NEWUSER , pm);
//
//        em.getTransaction().begin();
//        em.persist(pm);
//        em.persist(pa);
//        em.persist(customer);
//        em.getTransaction().commit();

//        ParkingAreaManager parkingAreaManager = new ParkingAreaManager();
//        ParkingArea parkingArea = new ParkingArea(parkingAreaManager);
//
//        LocalDateTime rDate = LocalDateTime.now();
//        LocalDateTime departure;
//        departure = LocalDateTime.of(2020,01,31,00,00);
//        LocalDateTime arrival;
//        arrival= LocalDateTime.of(2020,02,04,00,00);
//
//
//        CombustionCar combustionCar = new CombustionCar(carManagementSystem, parkingArea);
//        FuelRental rental2 = new FuelRental(rentalManager, combustionCar, carManagementSystem, customer.getCustomerID(), date, departure, arrival);

//        em.getTransaction().begin();
//        em.persist(customer);
//        em.persist(combustionCar);
//        em.persist(rental2);
//        em.getTransaction().commit();

        /////////////////////////////////////////////////////////////

        PersonManager personManager = new PersonManager();
        Customer customer = new Customer(personManager);

        persistCustomer(customer);

        em.getTransaction().begin();
        customer.setPaymentMethod("12344332124345", PaymentMethod.CardType.DEBIT, new GregorianCalendar(2020,GregorianCalendar.JANUARY,10), "303");
        em.getTransaction().commit();
    }
}