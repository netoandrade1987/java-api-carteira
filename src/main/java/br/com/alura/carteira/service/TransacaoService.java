package br.com.alura.carteira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;
import br.com.alura.carteira.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	private ModelMapper modelMapper = new ModelMapper();
	
	
	public Page<TransacaoDto> listar(Pageable paginacao) {
		
		 Page<Transacao> transacoes = transacaoRepository.findAll(paginacao);
		
		return transacoes.map(t -> modelMapper.map(t, TransacaoDto.class));

	}
	
	
	@Transactional
	public void cadastrar(@RequestBody @Valid TransacaoFormDto transacaoFormDto) {
		
		
		Transacao transacao = modelMapper.map(transacaoFormDto, Transacao.class);
		transacao.setId(null);
		transacaoRepository.save(transacao);

	}
	
	

}
