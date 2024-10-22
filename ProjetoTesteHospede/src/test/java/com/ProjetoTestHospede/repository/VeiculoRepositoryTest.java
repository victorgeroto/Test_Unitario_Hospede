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

import com.ProjetoTestHospede.entity.Veiculo;

@DataJpaTest
class VeiculoRepositoryTest {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@DisplayName("Testando o Save")
	@Test
	void test() {

		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "Fiat",
				"Toro",
				2020,
				"Preta");

		// When / Act 
		Veiculo saveVeiculo = veiculoRepository.save(veiculo1);

		//Then / Assert
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Veiculos")
	@Test
	void testGetAllRepository() {
		//given / Arrange 
		Veiculo Veiculo1 = new Veiculo (null, "Fiat",
				"Toro",
				2020,
				"Preta");
				
		Veiculo Veiculo2 = new Veiculo (null, "Nissan",
				"370Z",
				2018,
				"Cinza");
		veiculoRepository.save(Veiculo1);
		veiculoRepository.save(Veiculo2);

		//when / Act 
		List<Veiculo> veiculoList =  veiculoRepository.findAll();

		//then / Assert
		assertNotNull(veiculoList);
		assertEquals(2, veiculoList.size());
	}
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {

		//given / Arrange 
		Veiculo veiculo1 = new Veiculo (null, "Fiat",
				"Toro",
				2020,
				"Preta");
		veiculoRepository.save(veiculo1);

		//when / Act 
		Veiculo saveVeiculo =  veiculoRepository.findById(veiculo1.getId()).get();


		//then / Assert
		assertNotNull(saveVeiculo);
		assertEquals(veiculo1.getId(), saveVeiculo.getId());

	}
	@DisplayName("Testando o Update")
	@Test
	void testUpdateVeiculo() {
		//given / Arrange 
		Veiculo veiculo1 = new Veiculo (null, "Fiat",
				"Toro",
				2020,
				"Preta");
		veiculoRepository.save(veiculo1);
		//when / Act 
		Veiculo saveVeiculo =  veiculoRepository.findById(veiculo1.getId()).get();
		veiculo1.setMarca("Ford");
		veiculo1.setModelo("F250");
		veiculo1.setAno(2000);
		veiculo1.setCor("Preta");


		Veiculo updateVeiculo = veiculoRepository.save(saveVeiculo);

		//then / Assert
		assertNotNull(updateVeiculo);
		assertEquals("Ford", updateVeiculo.getMarca());
		assertEquals("F250", updateVeiculo.getModelo());
		assertEquals(2000, updateVeiculo.getAno());
		assertEquals("Preta", updateVeiculo.getCor());

	}
	@DisplayName("Testando o Delete")
	@Test
	void testDeleteVeiculo() {


		//given / Arrange 
		Veiculo Veiculo1 = new Veiculo (null, "Fiat",
				"Toro",
				2020,
				"Preta");
		veiculoRepository.save(Veiculo1);
		//when / Act 
		veiculoRepository.deleteById(Veiculo1.getId());

		Optional<Veiculo> clienteOptional = veiculoRepository.findById(Veiculo1.getId());

		//then / assert

		assertTrue(clienteOptional.isEmpty());
	}

}