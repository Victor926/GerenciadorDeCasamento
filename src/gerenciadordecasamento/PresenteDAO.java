/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author victo
 */


public class PresenteDAO {

    private ArrayList<Presente> presentes = new ArrayList<>();

    public boolean adicionar(Presente presente) {
        return presentes.add(presente); // ArrayList gerencia o tamanho automaticamente
    }

    public boolean vazio() {
        return presentes.isEmpty(); // Verifica se a lista está vazia
    }

    public void mostrar() {
        if (presentes.isEmpty()) {
            System.out.println("Nao ha presentes cadastrados.");
            return;
        }
        for (Presente p : presentes) {
            System.out.println(p);
        }
    }

    public boolean selecionarPresente(String nomePresente, String nomePessoa, PessoaDAO pessoaDAO) {
        for (Presente presente : presentes) {
            if (presente.getNome().equalsIgnoreCase(nomePresente)) {

                if (presente.getPessoa() == null) {
                    // Verifica se a pessoa existe
                    Pessoa pessoa = pessoaDAO.buscaPorNome(nomePessoa);
                    if (pessoa != null) {
                        // Adiciona a pessoa ao presente
                        presente.setPessoa(pessoa);
                        presente.setDataModificacao(LocalDate.now());
                        return true;
                    } else {
                        // Caso a pessoa não exista
                        System.out.println("Pessoa NAO encontrada!");
                        return false;
                    }
                } else {
                    // Caso o presente já esteja selecionado
                    System.out.println("\n Esse presente JA FOI SELECIONADO por outra pessoa!");
                    return false;
                }
            }
        }
        // Caso o presente não seja encontrado
        System.out.println("Esse PRESENTE nao foi encontrado! Tente outro!");
        return false;
    }
    
    public boolean removerPresente(Long idPresente) {
        return presentes.removeIf(presente -> presente.getId() == idPresente);
    }

    
}
