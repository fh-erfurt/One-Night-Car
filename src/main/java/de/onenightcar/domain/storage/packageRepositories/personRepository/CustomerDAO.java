package de.onenightcar.domain.storage.packageRepositories.personRepository;


import de.onenightcar.domain.model.person.Customer;
import de.onenightcar.domain.storage.core.DataController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CustomerDAO {

    private static final DataController dc = DataController.getInstance();
    private static final EntityManagerFactory emf = dc.getEntityManagerFactory();

    public static void persistCustomer(Customer customer) throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(customer.getPaymentMethod());
            em.persist(customer.getPersonAddress());
            em.persist(customer);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
}
