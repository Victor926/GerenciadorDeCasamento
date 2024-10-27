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
    private LocalDate dataParcela;
    private int parcelaAtual;
    private int parcelaTotal;
    private boolean pago;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
  
    
    public Pagamento(Pessoa pessoa, String descricao, double valorParcela, int parcelaTotal, int parcelaAtual, LocalDate dataParcela){
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
        this.id = ++this.serial;
        this.descricao = descricao;
        this.parcelaAtual = parcelaAtual;
        this.parcelaTotal = parcelaTotal;
        this.pessoa = pessoa;
        this.pago = false;
        this.dataParcela = dataParcela;
        this.valor = valorParcela;
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

    public LocalDate getDataParcela() {
        return dataParcela;
    }

    public int getParcelaAtual() {
        return parcelaAtual;
    }

    public int getParcelaTotal() {
        return parcelaTotal;
    }
    
    public long getIdPessoa(){
        return this.pessoa.getId();
    }

    public String isPago() {
        if(this.pago){
            return "pago";
        }
        else{
            return "a pagar";
        }
    }
    
    public boolean isPagoBoolean(){
        return this.pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
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

    public void setValor(double valor) {
        this.valor = valor;
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
