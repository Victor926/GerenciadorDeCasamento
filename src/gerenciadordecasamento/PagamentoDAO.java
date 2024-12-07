/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.util.ArrayList;

public class PagamentoDAO {
    // ESTE SERVE ESPECIFICAMENTE PARA OS FORNECEDORES
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();

 
    public void adicionar(Pagamento pagamento) {
        this.pagamentos.add(pagamento); // Adiciona diretamente na lista
    }

    public boolean verificarPagamentoCompleto() {
        int contadorDePago = 0;

        for (Pagamento pagamento : pagamentos) {
            if (pagamento.isPagoBoolean()) {
                contadorDePago++;
            }
        }

        return pagamentos.size() == contadorDePago; // Compara o tamanho da lista com os pagos
    }
}
