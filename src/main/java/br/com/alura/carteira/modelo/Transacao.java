package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author neto_
 * @version 1.0
 * 
 * Description:
 * Essa classe representa uma transacao no sistema de compra e venda de A��es.
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transacoes")
public @Data class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ticker;
	private LocalDate data;
	private BigDecimal preco;
	private Integer quantidade;
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipo;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	

}
