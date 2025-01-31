/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */

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
import gerenciadordecasamento.PessoaDAO;
import gerenciadordecasamento.Pessoa;

public class UsuarioDAO {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    
    
        
    public boolean adicionarNoBD(Usuario usuario) {
        String sql = "INSERT INTO usuario (pessoa_id, tipo, login, senha, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, CURRENT_DATE, CURRENT_DATE)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Preenchendo os valores
            stmt.setLong(1, usuario.getPessoa().getId()); // ID da Pessoa associada
            stmt.setString(2, usuario.getTipo());         // Tipo do usuário
            stmt.setString(3, usuario.getLogin());        // Login
            stmt.setString(4, usuario.getSenha());        // Senha

            // Executa a inserção
            stmt.execute();
            stmt.close();
            System.out.println("\n Usuario gravado com sucesso!");

            // Se chegou aqui, a inserção foi bem-sucedida
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println("\n Erro ao adicionar usuário no banco de dados: " + e.getMessage());
            return false;
        }
    }   
    
    public boolean adicionaNoArrayList(Usuario usuario) {
        return usuarios.add(usuario);
    }

    public boolean vazio() {
        return usuarios.isEmpty();
    }

    public void mostrar() {
        if (usuarios.isEmpty()) {
            System.out.println("Nao ha usuarios cadastrados.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public Pessoa getPessoa(int index){
        if (index >= 0 && index < usuarios.size()) {
            return usuarios.get(index).getPessoa();
        }
        return null; // Retorna null se o índice for inválido
    }
    public Usuario buscaUsuarioLogin(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public boolean alterarLogin(String login, String novoLogin) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuario.setLogin(novoLogin);
                return true;
            }
        }
        return false;
    }

    public Usuario buscaPorLogin(String login) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    public boolean remover(String login) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                usuarios.remove(u); // Remove o usuário do ArrayList
                return true;
            }
        }
        return false;
    }
    
    public boolean removerPorIdPessoa(Long idPessoa) {
        for (Usuario u : usuarios) {
            if (u.getPessoa().getId() == idPessoa) {
                return usuarios.remove(u); // Remove o usuário do ArrayList
            }
        }
        return false;
    }

    public boolean buscarPorId(long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public boolean buscarPorPessoaId(long idPessoa){
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getPessoa().getId() == idPessoa) {
                return true;
            }
        }
        return false;
    }
}


