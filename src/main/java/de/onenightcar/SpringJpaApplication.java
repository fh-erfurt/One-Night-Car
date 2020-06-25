package de.onenightcar;

import de.onenightcar.model.person.PaymentMethod;
import de.onenightcar.repositories.personRepository.PaymentMethodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}


}
