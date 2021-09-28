package br.com.alura.carteira.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import br.com.alura.carteira.modelo.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//Obs: no exemplo da aula foi omitido o campo data, somente como demonstração para
//termos um Classe Dto customizada, em alguns casos é necessário.

@NoArgsConstructor
@AllArgsConstructor
public @Data class TransacaoDto {
	
	
	
	@NotBlank
	private String ticker;
	
//	@DecimalMin(value = "0.1")
//	@Positive
	private BigDecimal preco;
	
//	@Positive
	private int quantidade;
	
	@PastOrPresent
	private LocalDate data;
	
	
	private TipoTransacao tipo;
	
	
}
