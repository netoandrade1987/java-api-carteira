package br.com.alura.carteira.dto;


public class ItemCarteiraDto {
	
	private String ticker;
	private Long quantidade;
	private Double percentual;
	
	public ItemCarteiraDto(String ticker, Long quantidade, Double percentual) {
		
		this.ticker = ticker;
		this.quantidade = quantidade;
		this.percentual = percentual;
	}

	public String getTicker() {
		return ticker;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public Double getPercentual() {
		return percentual;
	}

}
