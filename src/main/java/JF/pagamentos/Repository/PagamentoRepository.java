package JF.pagamentos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JF.pagamentos.Model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByAno(short ano);
    
    List<Pagamento> findByMes(short mes);

    List<Pagamento> findbyJogador(int cod_jogador);
}
