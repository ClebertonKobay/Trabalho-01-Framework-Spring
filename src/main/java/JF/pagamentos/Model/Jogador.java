package JF.Pagamentos.Model;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cod_jogador;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private Date datanasc;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_jogador")
    private List<Pagamento> pagamentos;

    public Jogador(){}

    public Jogador(String nome, String email, Date datanasc){
        this.nome =  nome;
        this.email = email;
        this.datanasc = datanasc; 
    }

    public List<Pagamento> getPagamentos() {
        return this.pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public long getCod_jogador() {
        return this.cod_jogador;
    }

    public void setCod_jogador(long cod_jogador) {
        this.cod_jogador = cod_jogador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    };

    public Date getDatanasc() {
        return this.datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    
}
