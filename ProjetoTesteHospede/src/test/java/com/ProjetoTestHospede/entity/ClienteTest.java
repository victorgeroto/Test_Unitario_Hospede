package com.ProjetoTestHospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		
		cliente = new Cliente (null, "Messi", "(11)7868-5846", "46734534534", "22323423");
		
	}
	
	@Test
	@DisplayName("Testando o getter  e setter do campo ID")
	void test() {
		cliente.setId(null);
		assertEquals(null, cliente.getId());
	}

	@Test
	@DisplayName("Testando o getter  e setter do campo Nome")
	void testNome() {
		cliente.setNome("Messi");
		assertEquals("Messi", cliente.getNome());
	}

	@Test
	@DisplayName("Testando o getter  e setter do campo Telefone")
	void testTelefone() {
		cliente.setTelefone("(11)7868-5846");
		assertEquals("(11)7868-5846", cliente.getTelefone());
	}
	@Test
	@DisplayName("Testando o getter  e setter do campo Cpf")
	void testCpf() {
		cliente.setCpf("46734534534");
		assertEquals("(46734534534", cliente.getCpf());
	}
	@Test
	@DisplayName("Testando o getter  e setter do campo Rg")
	void testRg() {
		cliente.setRg("22323423");
		assertEquals("22323423", cliente.getRg());
	}
	@Test
	@DisplayName("Testando o Construtor com todos os argumentos")
	void testConstrutorAll () {
		Cliente novoCliente = new Cliente (null, "pedro", "(14)7868-5846", "(11)9089-5846", "(11)9089-5846");
		assertAll("novoCliente",
			()-> assertEquals(null, novoCliente.getId()),
			()-> assertEquals("pedro", novoCliente.getNome()),
			()-> assertEquals("(14)7868-5846", novoCliente.getTelefone()),
			()-> assertEquals("46734534534", novoCliente.getCpf()),
			()-> assertEquals("(22323423", novoCliente.getRg()));
	}
}
