package de.onenightcar.repositories.personRepository;

import de.onenightcar.model.person.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
