package com.ProjetoTestHospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	
	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		
		hospede = new Hospede (1L, "Meci", "mecipilantrinha@gmail.com", "(11)7868-5846");
		
	}
	
	@Test
	@DisplayName("Testando o getter  e setter do campo ID")
	void test() {
		hospede.setId(2L);
		assertEquals(2L, hospede.getId());
	}

	@Test
	@DisplayName("Testando o getter  e setter do campo Nome")
	void testNome() {
		hospede.setNome("Meci");
		assertEquals("Meci", hospede.getNome());
	}

	@Test
	@DisplayName("Testando o getter  e setter do campo Email")
	void testEmail() {
		hospede.setEmail("mecipilantrinha@gmail.com");
		assertEquals("mecipilantrinha@gmail.com", hospede.getEmail());
	}
	@Test
	@DisplayName("Testando o getter  e setter do campo Telefone")
	void testtelefone() {
		hospede.setTelefone("(11)7868-5846");
		assertEquals("(11)7868-5846", hospede.getTelefone());
	}
	@Test
	@DisplayName("Testando o Construtor com todos os argumentos")
	void testConstrutorAll () {
		Hospede novoHospede = new Hospede (3L, "pedro", "pedropilantrinha@gmail.com", "(11)9089-5846");
		assertAll("novoHospede",
			()-> assertEquals(3L, novoHospede.getId()),
			()-> assertEquals("pedro", novoHospede.getNome()),
			()-> assertEquals("pedropilantrinha@gmail.com", novoHospede.getEmail()),
			()-> assertEquals("(11)9089-5846", novoHospede.getTelefone()));
	}
}
