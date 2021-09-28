package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
public @Data class Transacao {
	
	private String ticker;
	private BigDecimal preco;
	private int quantidade;
	private LocalDate data;
	private TipoTransacao tipo;
	
	

}
