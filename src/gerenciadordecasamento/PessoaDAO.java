/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
public class PessoaDAO {
    
    Pessoa[] pessoas = new Pessoa[100];
    
    boolean adiciona(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean vazio() {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        boolean temPessoa = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
                temPessoa = true;
            }
        }
        if (temPessoa == false) {
            System.out.println("Nao ha pessoas cadastradas");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getNome().equals(nome)) {
                pessoa.setNome(novoNome);
                return true;
            }
        }
        return false;
    }
     
    public Pessoa buscaPorId(long id) {
    for (Pessoa pessoa : pessoas) {
        if (pessoa != null && pessoa.getId() == id) { 
            return pessoa; 
        }
    }
    return null;
}
    
    Pessoa buscaPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
}
