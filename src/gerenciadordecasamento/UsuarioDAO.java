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

public class UsuarioDAO {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean adiciona(Usuario usuario) {
        return usuarios.add(usuario); // Adiciona o usuário ao ArrayList
    }

    public boolean vazio() {
        return usuarios.isEmpty(); // Verifica se o ArrayList está vazio
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


