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
public class Fornecedor {
    private static long serial = 0;
    private long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private PagamentoDAO pagamento;
    private String estado;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public Fornecedor() {
        id = Fornecedor.serial++;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
        this.dataModificacao = LocalDate.now();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        this.dataModificacao = LocalDate.now();
    }


    public String getEstado() {
        return estado;
    }

    public void setPagamentoDAO(PagamentoDAO pagamentos) {
        this.pagamento = pagamentos;
    }

    
    
    public void setEstado(String estado) {
        this.estado = estado;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public String toString() {
        return "Esse eh o fornecedor: " + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone=" + telefone + ", estado=" + estado + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Fornecedor other = (Fornecedor) obj;
        return this.id == other.id;
    }

   
}
