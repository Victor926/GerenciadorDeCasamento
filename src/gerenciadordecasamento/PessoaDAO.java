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

public class PessoaDAO {

    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Pessoa criarPessoa() {
        Pessoa p = new Pessoa();

        // RECEBENDO OS ATRIBUTOS
        // Nome
        System.out.println("Qual o nome: ");
        p.setNome(scanner.nextLine());

        // Data de Nascimento
        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            System.out.println("Qual a data de nascimento (dd/mm/yyyy):");
            String dataNaoFormatada = scanner.nextLine();
            try {
                dataNascimento = LocalDate.parse(dataNaoFormatada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Tente novamente no formato (dd/mm/yyyy):");
            }
        }
        p.setDataNascimento(dataNascimento);

        // Telefone
        String telefone = null;
        while (true) {
            System.out.println("Qual o telefone (xx-xxxxx-xxxx):");
            telefone = scanner.nextLine();
            if (!telefone.matches("\\d{2}-\\d{5}-\\d{4}")) {
                System.out.println("Telefone inválido! Use o formato (xx-xxxxx-xxxx):");
            } else {
                p.setTelefone(telefone);
                break;
            }
        }

        // Adicionando a Pessoa no Banco de Dados
        if (adicionarNoBD(p) && adicionaNoArrayList(p)) {
            System.out.println("\nPessoa adicionada com sucesso!\n");
            System.out.println(p);
            return p;
        } else {
            System.out.println("\nNão foi possível adicionar a pessoa!\n");
            return null;
        }
    }
    
    public boolean adicionarNoBD(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, dataNascimento, telefone, dataCriacao, dataModificacao) VALUES (?, ?, ?, CURRENT_DATE, CURRENT_DATE)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Preenchendo os valores
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(pessoa.getDataNascimento()));
            stmt.setString(3, pessoa.getTelefone());
                    
            stmt.execute();
            stmt.close();
            
            System.out.println("Gravado!");
            
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pessoa no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean adicionaNoArrayList(Pessoa p) {
        return pessoas.add(p);
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