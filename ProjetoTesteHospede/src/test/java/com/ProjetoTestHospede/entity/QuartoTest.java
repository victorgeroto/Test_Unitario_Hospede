package com.ProjetoTestHospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {
	private Quarto quarto;
	@BeforeEach
	void setUp(){
		//Arrange
			quarto = new Quarto(1L, "457", "suiteMaster");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Id")
	void testId() {
		//Act
		quarto.setId(2L);
		//Assert
		assertEquals(2L, quarto.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testNum() {
		//Act
		quarto.setNum("60");
		//Assert
		assertEquals("60", quarto.getNum());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
		//Act
		quarto.setTipo("suite mega blaster");
		//Assert
		assertEquals("suite mega blaster", quarto.getTipo());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testeConstrutorAll() {
		//Act
		Quarto novoQuarto = new Quarto(3L, "14", "suite");
		//Assertion
		assertAll("novoQuarto",
				()-> assertEquals(3L,novoQuarto.getId()),
				()-> assertEquals("14", novoQuarto.getNum()),
				()-> assertEquals("suite",novoQuarto.getTipo()));
			
		
	}

}
