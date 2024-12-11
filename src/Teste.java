import java.sql.Connection;
import java.sql.DriverManager;

public class Teste {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/gerenciador_de_casamento?serverTimezone=America/Sao_Paulo";
        String user = "root"; // Substitua pelo seu usuário do MySQL
        String password = "Daniela1904!"; // Substitua pela sua senha do MySQL

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}

