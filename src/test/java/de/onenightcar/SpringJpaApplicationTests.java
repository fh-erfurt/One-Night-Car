package de.onenightcar;

import de.onenightcar.controller.*;
import de.onenightcar.repositories.personRepository.AdminRepository;
import de.onenightcar.repositories.rentalRepository.RentalTimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringJpaApplicationTests {

	@Autowired
	private MainController mainController;

	@Autowired
	private SignUpController signUpController;

	@Autowired
	private LoginController loginController;

	@Autowired
	private RentalController rentalController;

	@Autowired
	private LogoutController logoutController;

	@Autowired
	private RentalTimeSlotRepository rentalTimeSlotRepository;

	@Autowired
	private AdminRepository adminRepository;


	@Test
	void contextLoads() throws Exception{
		//All Controllers startet successfully
		assertThat(mainController!=null);
		assertThat(signUpController!=null);
		assertThat(loginController!=null);
		assertThat(rentalController!=null);
		assertThat(logoutController!=null);

		//Needed data was added to the database
		assertThat(rentalTimeSlotRepository.count() == 24);
		assertThat(adminRepository.count() >= 1);
	}

}
