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
public class Recado {
    private static long serial = 0;
    private long id;
    private Pessoa pessoa;
    private String comentario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public long getId() {
        return id;
    }
    
    public Recado() {
        id = Recado.serial++;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Recado other = (Recado) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Recado{" + "id=" + id + ", pessoa=" + pessoa + ", comentario=" + comentario + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
}
