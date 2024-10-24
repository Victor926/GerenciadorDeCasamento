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
public class Evento {
    private static long serial = 0;
    private long id;
    private Cerimonial cerimonial;
    private Cartorio cartorio;
    private Igreja igreja;
    private Pessoa noiva;
    private Pessoa noivo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", cerimonial=" + cerimonial.getNome() + ", cartorio=" + cartorio.getNome() + ", noiva=" + noiva.getNome() + ", noivo=" + noivo.getNome() + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    
    public static long getSerial() {
        return serial;
    }

    public long getId() {
        return id;
    }

    public Cerimonial getCerimonial() {
        return cerimonial;
    }

    public Cartorio getCartorio() {
        return cartorio;
    }

    public Pessoa getNoiva() {
        return noiva;
    }

    public Pessoa getNoivo() {
        return noivo;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public static void setSerial(long serial) {
        Evento.serial = serial;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCerimonial(Cerimonial cerimonial) {
        this.cerimonial = cerimonial;
    }

    public void setCartorio(Cartorio cartorio) {
        this.cartorio = cartorio;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public void setNoiva(Pessoa noiva) {
        this.noiva = noiva;
    }

    public void setNoivo(Pessoa noivo) {
        this.noivo = noivo;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Evento other = (Evento) obj;
        return this.id == other.id;
    }
    
    
}
