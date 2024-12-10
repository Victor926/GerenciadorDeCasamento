/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private List<Pagamento> pagamentos = new ArrayList<>();
    private LocalDate dataHoje = LocalDate.now();

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void verificarPagamento() {
        this.dataHoje = LocalDate.now();
        for (Pagamento pagamento : pagamentos) {
            if (pagamento != null && pagamento.getDataParcela().isEqual(this.dataHoje)) {
                if (!pagamento.isPagoBoolean()) {
                    pagamento.setPago(true);
                    System.out.println("O pagamento " + pagamento.getDescricao() +
                            " foi pago hoje, dia " + this.dataHoje.toString());
                }
            }
        }
    }

    public boolean adiciona(Pagamento p) {
        if (p != null) {
            pagamentos.add(p); // Adiciona diretamente ao ArrayList
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        for (Pagamento pagamento : pagamentos) {
            if (pagamento != null) {
                texto.append("\n | ").append(pagamento.getDescricao())
                        .append(", parcela atual: ").append(pagamento.getParcelaAtual())
                        .append(", total de parcelas: ").append(pagamento.getParcelaTotal())
                        .append(", situação do pagamento: ").append(pagamento.isPago());
            }
        }
        return "Calendario{" + "dataHoje= " + dataHoje + ", pagamentos:" + texto + '}';
    }

    public String relatorioPagamentosNoivos(long idNoivo, long idNoiva) {
        double valorTotal = 0;
        StringBuilder retorno = new StringBuilder("Pagamentos realizados pelos noivos:\n");

        for (Pagamento pagamento : pagamentos) {
            if (pagamento != null && (pagamento.getIdPessoa() == idNoivo || pagamento.getIdPessoa() == idNoiva)) {
                valorTotal += pagamento.getValor();
                retorno.append(" | ").append(pagamento.getDescricao())
                        .append(", parcela atual: ").append(pagamento.getParcelaAtual())
                        .append(", total de parcelas: ").append(pagamento.getParcelaTotal())
                        .append(", situação do pagamento: ").append(pagamento.isPago()).append("\n");
            }
        }

        retorno.append("\nValor total a ser pago: ").append(valorTotal);
        return valorTotal == 0 ? "Os noivos não fizeram nenhum pagamento" : retorno.toString();
    }
}
