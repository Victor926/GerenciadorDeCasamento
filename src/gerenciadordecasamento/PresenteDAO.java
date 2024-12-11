/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import gerenciadordecasamento.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import gerenciadordecasamento.PagamentoDAO;
/**
 *
 * @author victo
 */


public class PresenteDAO {

    private ArrayList<Presente> presentes = new ArrayList<>();
    
    PessoaDAO pessoaDAO = new PessoaDAO();

    public boolean adicionar(Presente presente) {
        if (presente.getPessoa() == null) {
            System.out.println("Erro: Presente não pode ser associado a nenhuma pessoa.");
            return false;
        }

        String sql = "INSERT INTO presente (nome, tipo, valor, pessoa_id, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, CURRENT_DATE, CURRENT_DATE)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Preenchendo os valores
            stmt.setString(1, presente.getNome());
            stmt.setString(2, presente.getTipo());
            stmt.setDouble(3, presente.getValor());
            stmt.setLong(4, presente.getPessoa().getId());

            // Executa a inserção
            stmt.executeUpdate();

            // Se chegou aqui, a inserção foi bem-sucedida
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar presente no banco de dados: " + e.getMessage());
            return false;
        }
    }


    public boolean remover(Long idPresente) {
        return presentes.removeIf(p -> p.getId() == idPresente); // Remove se o ID coincidir
    }

    public Presente buscaPorId(long id) {
        for (Presente presente : presentes) {
            if (presente.getId() == id) {
                return presente;
            }
        }
        return null;
    }

    

    public boolean adicionarNoArrayList(Presente presente) {
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
    
    public boolean declararPresente(long idPresente, long idPessoa) {
        Presente presente = buscaPorId(idPresente); // Busca o presente pelo ID
        if (presente != null) {
            Pessoa pessoa = pessoaDAO.buscaPorId(idPessoa); // Busca a pessoa pelo ID
            if (pessoa != null) {
                presente.setPessoa(pessoa); // Associa a pessoa ao presente
                if (adicionar(presente)) {
                    System.out.println("Presente declarado com sucesso para a pessoa " + pessoa.getNome());
                    return true;
                } else {
                    System.out.println("Erro ao declarar presente.");
                    return false;
                }
            } else {
                System.out.println("Pessoa não encontrada.");
                return false;
            }
        } else {
            System.out.println("Presente não encontrado.");
            return false;
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
