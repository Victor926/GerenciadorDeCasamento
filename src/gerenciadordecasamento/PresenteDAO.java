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
public class PresenteDAO {
    
    Presente[] presentes = new Presente[100];
    
    boolean adicionar(Presente presente) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            presentes[proximaPosicaoLivre] = presente;
            return true;
        }
        return false;
    }
    
    public boolean vazio() {
        for (Presente presente : presentes) {
            if (presente != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        boolean temRecado = false;
        for (Presente p : presentes) {
            if (p != null) {
                System.out.println(p);
                temRecado = true;
            }
        }
        if (!temRecado) {
            System.out.println("Nao ha presentes cadastrados.");
        }
    }
    

    public int proximaPosicaoLivre() {
        for (int i = 0; i < presentes.length; i++) {
            if (presentes[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean selecionarPresente(String nomePresente, String nomePessoa, PessoaDAO pessoaDAO) {
    for (Presente presente : presentes) {
        if (presente != null && presente.getNome().equalsIgnoreCase(nomePresente)) {
     
            if (presente.getPessoa() == null) {
                //VERIFICANDO SE PESSOA EXISTE
                Pessoa pessoa = pessoaDAO.buscaPorNome(nomePessoa);
                if (pessoa != null) {
                    //ADICIONANDO A PESSOA
                    presente.setPessoa(pessoa);
                    presente.setDataModificacao(LocalDate.now());
                    return true;
                } else {
                    //CASO A PESSOA NAO EXISTA
                    System.out.println("Pessoa NAO encontrada!");
                    return false;
                }
            } else {
                //CASO NAO EXISTA O PRESENTE
                System.out.println("\n Esse presente JA FOI SELECIONADO por outro pessoa!");
                return false;
            }
        }
    }
    System.out.println("Esse PRESENTE nao foi encontrado! Tente Outro!");
        return false;
    }

}
