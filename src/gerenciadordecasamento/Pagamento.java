/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;


public class Pagamento {
    private static long serial= 0;
    private long id;
    private Pessoa pessoa;
    private String descricao;
    private double valor;
    private int parcelaAtual;
    private int parcelaTotal;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public Pagamento(){
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
        this.id = ++this.serial;
    }

    public static long getSerial() {
        return serial;
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getDescricao() {
        return descricao;
    }


    public double getValor() {
        return valor;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Pagamento other = (Pagamento) obj;
        return this.id == other.id;
    }
    
}
