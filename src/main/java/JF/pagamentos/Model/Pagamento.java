package JF.pagamentos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento")
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
    private Jogador cod_jogador;

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

    public Jogador getCod_jogador() {
        return this.cod_jogador;
    }

    public void setCod_jogador(Jogador cod_jogador) {
        this.cod_jogador = cod_jogador;
    }

}