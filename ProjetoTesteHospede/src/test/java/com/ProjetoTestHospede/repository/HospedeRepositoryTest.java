package com.ProjetoTestHospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ProjetoTestHospede.entity.Hospede;

@DataJpaTest
class HospedeRepositoryTest {

	@Autowired
	private HospedeRepository hospedeRepository;

	@DisplayName("Testando o Save")
	@Test
	void test() {

		// Given / Arrange
		Hospede hospede1 = new Hospede(null, "David",
				"david@gmail.com",
				"(15)997856473");

		// When / Act 
		Hospede saveHospede = hospedeRepository.save(hospede1);

		//Then / Assert
		assertNotNull(saveHospede);
		assertTrue(saveHospede.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Hospedes")
	@Test
	void testGetAllRepository() {
		//given / Arrange 
		Hospede hospede1 = new Hospede (null, "David",
				"David@gmail.com",
				"(15)997856473");
		Hospede hospede2 = new Hospede (null, "Pedro",
				"pedro@gmail.com",
				"(15)997856473");
		hospedeRepository.save(hospede1);
		hospedeRepository.save(hospede2);

		//when / Act 
		List<Hospede> hospedeList =  hospedeRepository.findAll();

		//then / Assert
		assertNotNull(hospedeList);
		assertEquals(2, hospedeList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {

		//given / Arrange 
		Hospede hospede1 = new Hospede (null, "David",
				"David@gmail.com",
				"(15)997856473");
		hospedeRepository.save(hospede1);

		//when / Act 
		Hospede saveHospede =  hospedeRepository.findById(hospede1.getId()).get();


		//then / Assert
		assertNotNull(saveHospede);
		assertEquals(hospede1.getId(), saveHospede.getId());

	}
	@DisplayName("Testando o Update")
	@Test
	void testUpdateHospede() {
		//given / Arrange 
		Hospede hospede1 = new Hospede (null, "David",
				"David@gmail.com",
				"(15)997856473");
		hospedeRepository.save(hospede1);
		//when / Act 
		Hospede saveHospede =  hospedeRepository.findById(hospede1.getId()).get();
		hospede1.setNome("Victor");
		hospede1.setEmail("victor@gmail.com");

		Hospede updateHospede = hospedeRepository.save(saveHospede);

		//then / Assert
		assertNotNull(updateHospede);
		assertEquals("Victor", updateHospede.getNome());
		assertEquals("victor@gmail.com", updateHospede.getEmail());

	}
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteHospede() {


		//given / Arrange 
		Hospede hospede1 = new Hospede (null, "David",
				"David@gmail.com",
				"(15)997856473");
		hospedeRepository.save(hospede1);
		//when / Act 
		hospedeRepository.deleteById(hospede1.getId());

		Optional<Hospede> hospedeOptional = hospedeRepository.findById(hospede1.getId());

		//then / assert

		assertTrue(hospedeOptional.isEmpty());
	}

}
