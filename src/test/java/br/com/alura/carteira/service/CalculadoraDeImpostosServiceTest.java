package br.com.alura.carteira.service;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;
import br.com.alura.carteira.modelo.Usuario;

class CalculadoraDeImpostosServiceTest {

	@Test
	void TransacaoDoTipoCompraNaoTemImposto() {
		
		
		Transacao t1 = new Transacao(
				
				111l,
				"XPTO1",
				LocalDate.now(),
				new BigDecimal("30.00"),
				10,
				TipoTransacao.COMPRA,
				
				new Usuario(
						
						1l,
						"João",
						"joao@joao.com",
						"123456"
						
						)
		
				);
		
		
		CalculadoraDeImpostosService calc = new CalculadoraDeImpostosService();
		BigDecimal imposto = calc.calcular(t1);
		
		Assertions.assertEquals(BigDecimal.ZERO, imposto);
		
	}
	
	
	@Test
	void TransacaoDoTipoVendaComValorInferiorVintMilNaoTemImposto() {
		
		
		Transacao t1 = new Transacao(
				
				111l,
				"XPTO1",
				LocalDate.now(),
				new BigDecimal("19.00"),
				1000,
				TipoTransacao.VENDA,
				
				new Usuario(
						
						1l,
						"João",
						"joao@joao.com",
						"123456"
						
						)
		
				);
		
		
		CalculadoraDeImpostosService calc = new CalculadoraDeImpostosService();
		BigDecimal imposto = calc.calcular(t1);
		
		Assertions.assertEquals(BigDecimal.ZERO, imposto);
		
	}
	
	
	@Test
	void TransacaoDoTipoVendaComValorSuperiorVintMilTemImpostoQuinzePorcento() {
		
		
		Transacao t1 = new Transacao(
				
				111l,
				"XPTO1",
				LocalDate.now(),
				new BigDecimal("21.00"),
				1000,
				TipoTransacao.VENDA,
				
				new Usuario(
						
						1l,
						"João",
						"joao@joao.com",
						"123456"
						
						)
		
				);
		
		
		CalculadoraDeImpostosService calc = new CalculadoraDeImpostosService();
		BigDecimal imposto = calc.calcular(t1);
		
		Assertions.assertEquals(new BigDecimal("3150.00"), imposto);
		
	}
	
	

}
