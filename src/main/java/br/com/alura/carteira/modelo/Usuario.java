package br.com.alura.carteira.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"senha"})
public @Data class Usuario {
	
	private String nome;
	private String login;
	private String senha;

}
