/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;

public class ConvidadoIndividual {
    private static long serial = 0;
    private long id;
    private Pessoa pessoa;
    private ConvidadoFamilia familia;
    private String parentesco;
    private boolean confirmacao = false;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    
    public ConvidadoIndividual() {
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

    public ConvidadoFamilia getFamilia() {
        return familia;
    }

    public String getParentesco() {
        return parentesco;
    }

    public boolean isConfirmacao() {
        return confirmacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
    }

    public void setFamilia(ConvidadoFamilia familia) {
        this.familia = familia;
        this.dataModificacao = LocalDate.now();
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
        this.dataModificacao = LocalDate.now();
    }

    public void setConfirmacao(boolean confirmacao) {
        this.confirmacao = confirmacao;
        this.dataModificacao = LocalDate.now();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final ConvidadoIndividual other = (ConvidadoIndividual) obj;
        return this.id == other.id;
    }
    
}
