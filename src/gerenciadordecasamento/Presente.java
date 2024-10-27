/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;

/**
 *
 * @author victo
 */
public class Presente {
    private static long serial = 0;
    private long id;
    private String nome;
    private String tipo;
    private double valor;
    private Pessoa pessoa;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Presente() {
        id = Presente.serial++;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDate.now();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.dataModificacao = LocalDate.now();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Presente other = (Presente) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Presente{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", pessoa=" + pessoa + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
}
