package de.onenightcar.domain.storage.core;

import de.onenightcar.domain.model.person.PersonAddress;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


// This class it´s just there for testing purposes //
public class JPADemo {

    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final DataController dc = DataController.getInstance();

    private static final EntityManagerFactory emf = dc.getEntityManagerFactory();

    public static void main(String[] args) throws Exception {

        EntityManager em = emf.createEntityManager();

        PersonAddress personAddress = new PersonAddress();

        // Save the Person Address
        em.getTransaction().begin();
        em.persist(personAddress);
        em.getTransaction().commit();

        //Used to modify and check the changes in DB
//        em.getTransaction().begin();
//        personAddress.setZIP("00000");
//        em.getTransaction().commit();

        // Read existing entries
        Query q = em.createQuery("select t from PersonAddress t");
        List<PersonAddress> personAddressList = q.getResultList();
        for (PersonAddress personAddresses : personAddressList) {
            System.out.println(personAddresses);
        }
        System.out.println("Size: " + personAddressList.size());

        // Try with the DatabaseConnection directly
        Connection conn = DatabaseConnection.getConnection();
        PersonAddressRepository.printAllPersonsAddressesFromDatabase(conn);

        DatabaseConnection.disconnectDatabase(conn);

    }
}