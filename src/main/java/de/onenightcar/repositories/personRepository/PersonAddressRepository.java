package de.onenightcar.repositories.personRepository;

import de.onenightcar.model.person.PersonAddress;
import org.springframework.data.repository.CrudRepository;

public interface PersonAddressRepository extends CrudRepository<PersonAddress, Long> {
}
