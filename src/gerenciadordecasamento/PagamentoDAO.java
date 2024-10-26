/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

public class PagamentoDAO {
    //ESTE SERVE ESPECIFICAMENTE PARA OS FORNECEDORES
    private Pagamento[] pagamentos = new Pagamento[300];
    private int indiceAtual = 0;

    public void setPagamentos(Pagamento[] pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    public void adicionar(Pagamento pagamento){
        this.pagamentos[indiceAtual] = pagamento;
        this.indiceAtual++;
    }
    
    public boolean verificarPagamentoCompleto(){
        int i = 0;
        int contadorDePago = 0;
        while(i < this.pagamentos.length){
            if(this.pagamentos[i] != null){
                if(this.pagamentos[i].isPago()){
                contadorDePago++;
                }
            }
            i++;
        }
        return indiceAtual + 1 == contadorDePago;
    }
    
}
