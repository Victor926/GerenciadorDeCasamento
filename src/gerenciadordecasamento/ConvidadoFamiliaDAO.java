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
import java.util.Iterator;

public class ConvidadoFamiliaDAO {

    private ArrayList<ConvidadoFamilia> familias = new ArrayList<>();

    public boolean adiciona(ConvidadoFamilia f) {
        return familias.add(f); // Adiciona diretamente à lista
    }

    public boolean vazio() {
        return familias.isEmpty(); // Verifica se a lista está vazia
    }

    public void mostrar() {
        if (familias.isEmpty()) {
            System.out.println("Nao ha FAMILIAS cadastradas");
            return;
        }
        for (ConvidadoFamilia f : familias) {
            System.out.println(f);
        }
    }

    public boolean buscaPorNome(String nome) {
        for (ConvidadoFamilia f : familias) {
            if (f != null && f.getNome() != null && f.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarPorId(long id) {
        for (ConvidadoFamilia ca : familias) {
            if (ca != null && ca.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarAcesso(String acesso) {
        for (ConvidadoFamilia cf : familias) {
            if (cf.getAcesso() != null && cf.getAcesso().equals(acesso)) {
                return true;
            }
        }
        return false;
    }

    public ConvidadoFamilia buscarFamilia(String acesso) {
        for (ConvidadoFamilia cf : familias) {
            if (cf != null && cf.getAcesso() != null && cf.getAcesso().equals(acesso)) {
                return cf;
            }
        }
        return null;
    }

    public String buscarAcessoPorFamilia(ConvidadoFamilia familia) {
        if (familia != null) {
            return familia.getAcesso();
        }
        return null;
    }

    public ConvidadoFamilia buscarFamiliaPorNome(String nomeFamilia) {
        for (ConvidadoFamilia cf : familias) {
            if (cf != null && cf.getNome() != null && cf.getNome().equals(nomeFamilia)) {
                return cf;
            }
        }
        return null;
    }
    
    public boolean remover(long idFamilia) {
        for (int i = 0; i < familias.size(); i++) { 
            ConvidadoFamilia familia = familias.get(i); 
            if (familia != null && familia.getId() == idFamilia) {
                familias.remove(i); 
                return true;
            }
        }
        return false;
    }


}

