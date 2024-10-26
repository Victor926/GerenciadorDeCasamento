/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;


public class Calendario {
    private Pagamento[] pagamentos = new Pagamento[300];
    private LocalDate dataHoje = LocalDate.now();
    
    public Pagamento[] getPagamentos() {
        return pagamentos;
    }
    
    public void verificarPagamento(){
        this.dataHoje = LocalDate.now();
        int i = 0;
        while(i<this.pagamentos.length){
            if(this.pagamentos[i] == null)
            {
                i++;
            }
            else{
                if(this.pagamentos[i].getDataParcela().isEqual(this.dataHoje)){
                    this.pagamentos[i].setPago(true);
                    System.out.println("O pagamento " + this.pagamentos[i].getDescricao() + "foi pago hoje dia" + this.dataHoje.toString());
                }
            }
        }
    }
    
    public int proximaPosicaoLivre() {
        for (int i = 0; i < pagamentos.length; i++) {
            if (pagamentos[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    boolean adiciona(Pagamento p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pagamentos[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
    }
}
