/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
public class RecadoDAO {
    
    Recado[] recados = new Recado[100];
    
    boolean adiciona(Recado recado) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            recados[proximaPosicaoLivre] = recado;
            return true;
        }
        return false;
    }
    
    public boolean vazio() {
        for (Recado recado : recados) {
            if (recado != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        boolean temRecado = false;
        for (Recado r : recados) {
            if (r != null) {
                System.out.println(r);
                temRecado = true;
            }
        }
        if (!temRecado) {
            System.out.println("Nao ha recados cadastrados.");
        }
    }

    public int proximaPosicaoLivre() {
        for (int i = 0; i < recados.length; i++) {
            if (recados[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
}
