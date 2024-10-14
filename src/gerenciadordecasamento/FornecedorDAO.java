/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
public class FornecedorDAO {
    
    Fornecedor[] fornecedores = new Fornecedor[100];
    
    boolean adiciona(Fornecedor fornecedor) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            fornecedores[proximaPosicaoLivre] = fornecedor;
            return true;
        }
        return false;
    }
    
    public boolean vazio() {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        boolean temFornecedor = false;
        for (Fornecedor f : fornecedores) {
            if (f != null) {
                System.out.println(f);
                temFornecedor = true;
            }
        }
        if (!temFornecedor) {
            System.out.println("Nao ha fornecedores cadastrados.");
        }
    }

    public boolean remover(String nome) {
        for (int i = 0; i < fornecedores.length; i++) {
            if (fornecedores[i] != null && fornecedores[i].getNome().equals(nome)) {
                fornecedores[i] = null;
                return true;
            }
        }
        return false;
    }

    public int proximaPosicaoLivre() {
        for (int i = 0; i < fornecedores.length; i++) {
            if (fornecedores[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public Fornecedor buscaPorCnpj(String cnpj) {
    for (Fornecedor fornecedor : fornecedores) {
        if (fornecedor != null && fornecedor.getCnpj().equals(cnpj)) {
            return fornecedor;
        }
    }
    return null;
}

    
}
