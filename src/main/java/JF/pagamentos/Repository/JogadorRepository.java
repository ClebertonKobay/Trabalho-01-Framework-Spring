package JF.pagamentos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JF.pagamentos.Model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{
    List<Jogador> findByNome(String nome);

    List<Jogador> findByEmail(String email);

}