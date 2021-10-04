package br.com.alura.carteira.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.carteira.dto.UsuarioDto;
import br.com.alura.carteira.dto.UsuarioFormDto;
import br.com.alura.carteira.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public Page<UsuarioDto> listar(Pageable paginacao) {

		return usuarioService.listar(paginacao);

	}

	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioFormDto usuarioFormDto,
			
		UriComponentsBuilder uriBuilder) {

		 UsuarioDto usuarioDto =  usuarioService.cadastrar(usuarioFormDto);
		
		 URI uri = uriBuilder
				 .path("/usuarios/{id}")
				 .buildAndExpand(usuarioDto.getId())
				 .toUri();
		
		return ResponseEntity.created(uri).body(usuarioDto);

	}

}
