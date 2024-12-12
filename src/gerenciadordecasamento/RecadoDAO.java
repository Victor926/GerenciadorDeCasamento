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

public class RecadoDAO {

    private ArrayList<Recado> recados = new ArrayList<>();

    public ArrayList<Recado> getRecados() {
        return recados;
    }

    public boolean adiciona(Recado recado) {
        return recados.add(recado); // O método add do ArrayList já gerencia a adição
    }

    public boolean vazio() {
        return recados.isEmpty(); // Usa isEmpty para verificar se a lista está vazia
    }

    public void mostrar() {
        if (recados.isEmpty()) {
            System.out.println("Nao ha recados cadastrados.");
            return;
        }
        for (Recado r : recados) {
            System.out.println(r);
        }
    }
    
    public boolean remover(Long idRecado) {
        return recados.removeIf(r -> r.getId() == idRecado);
    }
    
}
