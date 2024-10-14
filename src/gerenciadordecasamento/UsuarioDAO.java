/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
public class UsuarioDAO {
    
    Usuario[] usuarios = new Usuario[100]; 
    
    boolean adiciona(Usuario usuario) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            usuarios[proximaPosicaoLivre] = usuario;
            return true;
        }
        return false;
    }

    public boolean vazio() {
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        boolean temUsuario = false;
        for (Usuario u : usuarios) {
            if (u != null) {
                System.out.println(u);
                temUsuario = true;
            }
        }
        if (!temUsuario) {
            System.out.println("Nao ha usuarios cadastrados.");
        }
    }
    
    Usuario buscaUsuarioLogin(String login, String senha) {
         for (Usuario u : usuarios) {
            if (u != null && u.getLogin().equals(login) &&
                    u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
   

    public boolean alterarLogin(String login, String novoLogin) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getLogin().equals(login)) {
                usuario.setLogin(novoLogin);
                return true;
            }
        }
        return false;
    }

    public Usuario buscaPorLogin(String login) {
        for (Usuario u : usuarios) {
            if (u != null && u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    public boolean remover(String login) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getLogin().equals(login)) {
                usuarios[i] = null;
                return true;
            }
        }
        return false;
    }

    public int proximaPosicaoLivre() {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                return i;
            }
        }
        return -1;
    }
}

