package com.ProjetoTestHospede.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ProjetoTestHospede.entity.Hospede;
import com.ProjetoTestHospede.repository.HospedeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional

class HospedeServiceTest {

	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@BeforeEach
	void setUp() {
		hospedeRepository.deleteAll();
	}
	
@DisplayName("Testando salvar Hospede")
@Test
void testSalvarHospede() {
	Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(15)0000-0000");
	
	Hospede resultado = hospedeService.salvarHospede(hospede);
	
	assertNotNull(resultado);
	assertEquals("Julia Maria", resultado.getNome());
	assertTrue(resultado.getId() > 0);
}

@DisplayName("Testando listar hospedes")
@Test
void testListarTodos() {
	Hospede hospede1 = new Hospede(null, "Julia", "julia@gmail.com", "(00)0000-0000");
	Hospede hospede2 = new Hospede(null, "Julio", "julio@gmail.com", "(00)0000-0000");
	
	hospedeService.salvarHospede(hospede1);
	hospedeService.salvarHospede(hospede2);
	
	List<Hospede> resultado = hospedeService.listarTodos();
	assertNotNull(resultado);
	assertEquals(2, resultado.size());
	
	}
@DisplayName("Testando buscar hospede por ID")
@Test
void testBuscarPorId() {
	Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "(00)0000-0000");
	
	Hospede salvo = hospedeService.salvarHospede(hospede);
	Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
	
	assertNotNull(resultado.isPresent());
	assertEquals("Julia Maria", resultado.get().getNome());
	
	}
@DisplayName("Testando atualizar hospede")
@Test
void testAtualizarHospede() {
	Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "(00)0000-0000");
	Hospede salvo = hospedeService.salvarHospede(hospede);
	
	salvo.setNome("Leonardo");
	salvo.setEmail("leonardo@gmail.com");
	
	Hospede atualizado = hospedeService.atualizarHospede(salvo);
	
	assertNotNull(atualizado);
	assertEquals("Leonardo", atualizado.getNome());
	assertEquals("leonardo@gmial.com", atualizado.getEmail());
	
	}
@DisplayName("Testando deletar hospede")
@Test
void testDeletarHospede() {
	Hospede hospede = new Hospede(null, "Julia", "julia@gmail.com", "(00)0000-0000");
	
	Hospede salvo = hospedeService.salvarHospede(hospede);
	hospedeService.deletarHospede(salvo.getId());
	
	Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
	
	assertTrue(resultado.isEmpty());
	
	}
}


