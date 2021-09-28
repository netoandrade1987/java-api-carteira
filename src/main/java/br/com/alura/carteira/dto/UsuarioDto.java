package br.com.alura.carteira.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
