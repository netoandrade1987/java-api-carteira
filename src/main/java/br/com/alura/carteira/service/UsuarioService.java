package br.com.alura.carteira.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	

	public Page<UsuarioDto> listar(Pageable paginacao) {

		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);

		return usuarios.map(u -> modelMapper.map(u, UsuarioDto.class));

	}

	@Transactional
	public UsuarioDto cadastrar(UsuarioFormDto usuarioFormDto) {

		Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);
		
		usuario.setSenha(GeneratePassword.generatePass());
		
		//usuario.setId(null);
		
		return modelMapper.map(usuarioRepository.save(usuario), UsuarioDto.class);

	}

}
