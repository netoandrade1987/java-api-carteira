package br.com.alura.carteira.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.carteira.dto.UsuarioDto;
import br.com.alura.carteira.dto.UsuarioFormDto;
import br.com.alura.carteira.modelo.Usuario;
import br.com.alura.carteira.repository.UsuarioRepository;
import br.com.alura.carteira.util.GeneratePassword;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public List<UsuarioDto> listar() {

		List<Usuario> usuarios = usuarioRepository.findAll();

		return usuarios.stream().map(u -> modelMapper.map(u, UsuarioDto.class))
				.collect(Collectors.toList());

	}

	public void cadastrar(UsuarioFormDto usuarioFormDto) {

		Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);
		usuario.setSenha(GeneratePassword.generatePass());

		System.out.println(usuario.getLogin() + " " + usuario.getSenha());

		usuarioRepository.save(usuario);

	}

}
