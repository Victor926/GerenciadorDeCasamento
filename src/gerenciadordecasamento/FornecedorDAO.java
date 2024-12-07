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

public class FornecedorDAO {

    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();

    public boolean adiciona(Fornecedor fornecedor) {
        return fornecedores.add(fornecedor); // Adiciona diretamente à lista
    }

    public boolean vazio() {
        return fornecedores.isEmpty(); // Verifica se a lista está vazia
    }

    public void mostrar() {
        if (fornecedores.isEmpty()) {
            System.out.println("Nao ha fornecedores cadastrados.");
        } else {
            for (Fornecedor f : fornecedores) {
                System.out.println(f);
            }
        }
    }

    public boolean remover(String nome) {
        for (Fornecedor f : fornecedores) {
            if (f != null && f.getNome().equals(nome)) {
                fornecedores.remove(f);
                return true;
            }
        }
        return false;
    }

    public Fornecedor buscaPorCnpj(String cnpj) {
        for (Fornecedor f : fornecedores) {
            if (f != null && f.getCnpj().equals(cnpj)) {
                return f;
            }
        }
        return null;
    }

    public void verificarVetorPagamentos() {
        for (Fornecedor f : fornecedores) {
            if (f != null) {
                f.verificarPagamento();
            }
        }
    }
    
    public ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }
}

