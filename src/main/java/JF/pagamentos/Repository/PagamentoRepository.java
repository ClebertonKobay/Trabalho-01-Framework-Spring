package JF.Pagamentos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import JF.Pagamentos.Model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @Query(value = "SELECT * FROM pagamentos WHERE cod_jogador = ?", nativeQuery = true)
	List<Pagamento> findPagamentosByJogador(long jogador_cod_jogador);
}
