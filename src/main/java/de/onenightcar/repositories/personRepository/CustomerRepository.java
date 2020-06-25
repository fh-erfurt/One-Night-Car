package de.onenightcar.repositories.personRepository;

import de.onenightcar.model.person.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
