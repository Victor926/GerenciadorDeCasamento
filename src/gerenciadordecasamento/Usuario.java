/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author victo
 */
public class Usuario {
    
    private static long serial = 0;
    private long id;
    private Pessoa pessoa;
    private String tipo;
    private String login;
    private String senha;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public Usuario() {
        id = Usuario.serial++;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
    }
    
    public Usuario(Pessoa noivo, String login, String senha){
        id = Usuario.serial++;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = this.dataCriacao;
        this.pessoa = noivo;
        this.login = login;
        this.senha = senha;
        this.tipo = "N";
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.dataModificacao = LocalDate.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        this.dataModificacao = LocalDate.now();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        return " Esse eh o usuario: " + "id=" + id + ", pessoa=" + pessoa + ", tipo=" + tipo + ", login=" + login + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }
    
}
