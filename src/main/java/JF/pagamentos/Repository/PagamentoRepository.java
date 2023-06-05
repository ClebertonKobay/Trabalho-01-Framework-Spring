package JF.Pagamentos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JF.Pagamentos.Model.Jogador;
import JF.Pagamentos.Model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByAno(short ano);
    
    List<Pagamento> findByMes(short mes);

    List<Pagamento> findByJogador(Jogador jogador);
}
