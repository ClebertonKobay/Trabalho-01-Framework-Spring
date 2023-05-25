package JF.pagamentos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JF.pagamentos.Model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
