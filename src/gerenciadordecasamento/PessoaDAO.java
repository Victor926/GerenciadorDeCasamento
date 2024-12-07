/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
import java.util.ArrayList;

public class PessoaDAO {

    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    boolean adiciona(Pessoa p) {
        return pessoas.add(p); // O método add() retorna true se a adição for bem-sucedida
    }
    
    public Pessoa getPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            return pessoas.get(index);
        }
        return null; // Retorna null se o índice for inválido
    }
    
    public String getNomePessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            return pessoas.get(index).getNome();
        }
        return null; // Retorna null se o índice for inválido
    }

    public boolean vazio() {
        return pessoas.isEmpty(); // Método próprio do ArrayList
    }

    public void mostrar() {
        if (pessoas.isEmpty()) {
            System.out.println("Nao ha pessoas cadastradas");
        } else {
            for (Pessoa p : pessoas) {
                System.out.println(p);
            }
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equals(nome)) {
                pessoa.setNome(novoNome);
                return true;
            }
        }
        return false;
    }

    public Pessoa buscaPorId(long id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    Pessoa buscaPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean remover(Long idEnviado) {
        return pessoas.removeIf(p -> p.getId() == idEnviado); // Remove se o id coinscidir
    }
}