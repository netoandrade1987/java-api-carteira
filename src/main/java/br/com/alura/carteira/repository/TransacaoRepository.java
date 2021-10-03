package br.com.alura.carteira.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.carteira.dto.ItemCarteiraDto;
import br.com.alura.carteira.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
		
	@Query("select new br.com.alura.carteira.dto.ItemCarteiraDto("
			+ "tr.ticker, "
			+ "sum(tr.quantidade), "
			+ "(sum(tr.quantidade) * 1.0 / (select sum(tr2.quantidade) * 1.0 from Transacao tr2  ) )) "
			+ "FROM Transacao  tr "
			+ "group by tr.ticker")
	List<ItemCarteiraDto> relatorioCarteiraDeInvestimentos();

}
