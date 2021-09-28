package br.com.alura.carteira.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UsuarioFormDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String login;
	

}
