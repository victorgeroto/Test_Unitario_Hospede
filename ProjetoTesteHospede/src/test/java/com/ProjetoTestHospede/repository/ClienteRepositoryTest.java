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

import com.ProjetoTestHospede.entity.Cliente;

@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;

	@DisplayName("Testando o Save")
	@Test
	void test() {

		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "David",
				"(15)997856473",
				"23423456789",
				"43543656");

		// When / Act 
		Cliente saveCliente = clienteRepository.save(cliente1);

		//Then / Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Clientes")
	@Test
	void testGetAllRepository() {
		//given / Arrange 
		Cliente Cliente1 = new Cliente (null, "David",
				"(15)997856473",
				"23423456789",
				"43543656");
				
		Cliente Cliente2 = new Cliente (null, "Pedro",
				"(15)997856473",
				"23423456789",
				"43543659");
		clienteRepository.save(Cliente1);
		clienteRepository.save(Cliente2);

		//when / Act 
		List<Cliente> clienteList =  clienteRepository.findAll();

		//then / Assert
		assertNotNull(clienteList);
		assertEquals(2, clienteList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {

		//given / Arrange 
		Cliente cliente1 = new Cliente (null, "David",
				"(15)997856473",
				"23423456789",
				"43543659");
		clienteRepository.save(cliente1);

		//when / Act 
		Cliente saveCliente =  clienteRepository.findById(cliente1.getId()).get();


		//then / Assert
		assertNotNull(saveCliente);
		assertEquals(cliente1.getId(), saveCliente.getId());

	}
	@DisplayName("Testando o Update")
	@Test
	void testUpdateCliente() {
		//given / Arrange 
		Cliente cliente1 = new Cliente (null, "David",
				"(15)997856473",
				"23423456789",
				"43543659");
		clienteRepository.save(cliente1);
		//when / Act 
		Cliente saveCliente =  clienteRepository.findById(cliente1.getId()).get();
		cliente1.setNome("Victor");
		cliente1.setTelefone("(15)997556473");
		cliente1.setCpf("23533456789");
		cliente1.setRg("48543659");


		Cliente updateCliente = clienteRepository.save(saveCliente);

		//then / Assert
		assertNotNull(updateCliente);
		assertEquals("Victor", updateCliente.getNome());
		assertEquals("(15)997556473", updateCliente.getTelefone());
		assertEquals("23533456789", updateCliente.getCpf());
		assertEquals("48543659", updateCliente.getRg());

	}
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteCliente() {


		//given / Arrange 
		Cliente cliente1 = new Cliente (null, "David",
				"(15)997856473",
				"23423456789",
				"43543659");
		clienteRepository.save(cliente1);
		//when / Act 
		clienteRepository.deleteById(cliente1.getId());

		Optional<Cliente> clienteOptional = clienteRepository.findById(cliente1.getId());

		//then / assert

		assertTrue(clienteOptional.isEmpty());
	}

}