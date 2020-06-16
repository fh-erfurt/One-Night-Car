package de.onenightcar.domain;

import de.onenightcar.domain.model.person.PaymentMethod;
import de.onenightcar.domain.storage.packageRepositories.personRepository.PaymentMethodRepository;
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

	@Bean
	public CommandLineRunner demo(PaymentMethodRepository repository) {
		return (args) -> {
			// Save a couple Payment Methods
			repository.save(new PaymentMethod());
			repository.save(new PaymentMethod());
			repository.save(new PaymentMethod());
			repository.save(new PaymentMethod());

			// fetch all paymentMethod
			log.info("PaymentMethod found with findAll():");
			log.info("-------------------------------");
			for (PaymentMethod paymentMethod : repository.findAll()) {
				log.info(paymentMethod.toString());
			}
			log.info("");

			// fetch an individual paymentMethod by ID
			PaymentMethod paymentMethod = repository.findById(1L);
			log.info("PaymentMethod found with findById(1L):");
			log.info("--------------------------------");
			log.info(paymentMethod.toString());
			log.info("");

			// fetch customers by last name
			log.info("PaymentMethod found with findByCardNumber('0000 0000 0000 0000'):");
			log.info("--------------------------------------------");
			repository.findByCardNumber("0000 0000 0000 0000").forEach(pm -> {
				log.info(pm.toString());
			});

			log.info("");
		};
	}
}
