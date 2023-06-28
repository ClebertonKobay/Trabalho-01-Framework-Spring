package JF.Pagamentos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cod_pagamento;

    @Column
    private short ano;

    @Column
    private short mes;

    @Column
    private double valor;

    @ManyToOne
	@JoinColumn(name = "cod_jogador")
    @JsonIgnore
	private Jogador jogador;

    public Pagamento(){}

    public Pagamento(short ano, short mes, double valor, Jogador jogador){
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.jogador = jogador;
    }

    public long getCod_pagamento() {
        return this.cod_pagamento;
    }

    public void setCod_pagamento(long cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public short getAno() {
        return this.ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public short getMes() {
        return this.mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

}
