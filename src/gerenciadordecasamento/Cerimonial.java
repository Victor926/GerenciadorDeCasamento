/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;

/**
 *
 * @author Ruam
 */
public class Cerimonial {
    private static long serial = 0;
    private long id;
    private String nome;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Cerimonial(String nome){
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
        this.id = ++this.serial;
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Cerimonial other = (Cerimonial) obj;
        return this.id == other.id;
    }
    
    public static long getSerial() {
        return serial;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDate.now();
    }
}
