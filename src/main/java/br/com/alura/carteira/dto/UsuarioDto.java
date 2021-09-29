package br.com.alura.carteira.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class UsuarioDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String login;

}
