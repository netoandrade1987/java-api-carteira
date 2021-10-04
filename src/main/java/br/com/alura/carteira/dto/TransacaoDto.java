package br.com.alura.carteira.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.alura.carteira.modelo.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public @Data class TransacaoDto {
	
	@Positive
	@NotNull
	private Long id;
	
	@NotBlank
	@Size(min = 3, max=15)
	private String ticker;
	
	@DecimalMin(value = "0.1")
	private BigDecimal preco;
	
	@Positive
	@NotNull
	private Integer quantidade;
	
	@PastOrPresent
	private LocalDate data;
	
	@NotNull
	private TipoTransacao tipo;
	
	@Positive
	@JsonAlias("usuario_id")
	private Long usuarioId;
	
	
}
