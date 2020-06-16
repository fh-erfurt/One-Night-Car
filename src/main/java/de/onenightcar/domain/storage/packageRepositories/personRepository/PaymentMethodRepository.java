package de.onenightcar.domain.storage.packageRepositories.personRepository;

import de.onenightcar.domain.model.person.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
    List<PaymentMethod> findByCardNumber(String cardNumber);

    PaymentMethod findById(long id);
}
