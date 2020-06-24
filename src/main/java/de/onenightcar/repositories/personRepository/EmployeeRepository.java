package de.onenightcar.repositories.personRepository;

import de.onenightcar.model.person.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
