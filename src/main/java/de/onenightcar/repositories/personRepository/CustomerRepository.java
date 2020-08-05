package de.onenightcar.repositories.personRepository;

import de.onenightcar.model.person.Customer;
import de.onenightcar.model.rental.FuelRental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer getById(Long id);
    Customer getByMail(String mail);
}
