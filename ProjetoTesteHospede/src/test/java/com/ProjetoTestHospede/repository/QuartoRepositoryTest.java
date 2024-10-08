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

import com.ProjetoTestHospede.entity.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

	@Autowired
	private QuartoRepository quartoRepository;

	@DisplayName("Testando o Save")
	@Test
	void test() {

		// Given / Arrange
		Quarto quarto1 = new Quarto(null, "15",
				"SUITE MASTER");

		// When / Act 
		Quarto saveQuarto = quartoRepository.save(quarto1);

		//Then / Assert
		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Hospedes")
	@Test
	void testGetAllRepository() {
		//given / Arrange 
		Quarto quarto1 = new Quarto (null, "15",
				"SUITE MASTER");
		
		Quarto quarto2 = new Quarto (null, "12",
				"SUITE 5 ESTRELAS");
		quartoRepository.save(quarto1);
		quartoRepository.save(quarto2);

		//when / Act 
		List<Quarto> quartoList =  quartoRepository.findAll();

		//then / Assert
		assertNotNull(quartoList);
		assertEquals(2, quartoList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {

		//given / Arrange 
		Quarto quarto1 = new Quarto (null, "15",
				"SUITE MASTER");
		quartoRepository.save(quarto1);

		//when / Act 
		Quarto saveQuarto =  quartoRepository.findById(quarto1.getId()).get();


		//then / Assert
		assertNotNull(saveQuarto);
		assertEquals(quarto1.getId(), saveQuarto.getId());

	}
	@DisplayName("Testando o Update")
	@Test
	void testUpdateQuarto() {
		//given / Arrange 
		Quarto quarto1 = new Quarto (null, "15",
				"SUITE MASTER");
		quartoRepository.save(quarto1);
		//when / Act 
		Quarto saveQuarto =  quartoRepository.findById(quarto1.getId()).get();
		quarto1.setNum("17");
		quarto1.setTipo("SUITE 3 ESTRELAS");

		Quarto updateQuarto = quartoRepository.save(saveQuarto);

		//then / Assert
		assertNotNull(updateQuarto);
		assertEquals("17", updateQuarto.getNum());
		assertEquals("SUITE 3 ESTRELAS", updateQuarto.getTipo());

	}
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteQuarto() {


		//given / Arrange 
		Quarto quarto1 = new Quarto (null, "15",
				"SUITE MASTER");
		quartoRepository.save(quarto1);
		//when / Act 
		quartoRepository.deleteById(quarto1.getId());

		Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());

		//then / assert

		assertTrue(quartoOptional.isEmpty());
	}

}
