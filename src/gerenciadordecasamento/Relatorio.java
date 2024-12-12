/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Relatorio {
    
   public void gerarRelatorioRecados(List<Recado> recados, String caminhoArquivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Criar tabela com duas colunas
            PdfPTable table = new PdfPTable(2); // Número de colunas
            table.setWidthPercentage(100);

            // Cabeçalho da tabela
            PdfPCell header1 = new PdfPCell();
            header1.setPhrase(new com.itextpdf.text.Phrase("De"));
            header1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(header1);

            PdfPCell header2 = new PdfPCell();
            header2.setPhrase(new com.itextpdf.text.Phrase("Recado"));
            header2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(header2);

            // Adicionar dados dos recados
            for (Recado recado : recados) {
                table.addCell(recado.getPessoa().getNome());
                table.addCell(recado.getComentario());
            }

            // Adicionar a tabela ao documento
            document.add(table);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        System.out.println("Relatório gerado com sucesso em: " + caminhoArquivo);
    }
   
   public void gerarConvitesIndividuais(List<ConvidadoIndividual> convidados, String nomeNoivo, String nomeNoiva, String caminhoArquivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Adicionar título do documento
            Paragraph titulo = new Paragraph("Convites Individuais");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n"));

            // Gerar um convite para cada convidado
            for (ConvidadoIndividual convidado : convidados) {
                Paragraph convite = new Paragraph();
                convite.add("Casamento de " + nomeNoivo + " e " + nomeNoiva + "\n\n");
                convite.add("Querido(a) " + convidado.getPessoa().getNome() + ",\n\n");
                convite.add("Convidamos você a participar da nossa celebração de casamento!\n\n");
                convite.add("Esperamos você lá!\n\n");
                convite.add("--------------------\n\n");
                document.add(convite);
            }

            System.out.println("Convites individuais gerados com sucesso em: " + caminhoArquivo);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
   
   public static void gerarConvitesFamiliares(List<ConvidadoFamilia> familias, String nomeNoivo, String nomeNoiva, String caminhoArquivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Adicionar título do documento
            Paragraph titulo = new Paragraph("Convites Familiares");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n"));

            // Gerar um convite para cada família
            for (ConvidadoFamilia familia : familias) {
                Paragraph convite = new Paragraph();
                convite.add("Casamento de " + nomeNoivo + " e " + nomeNoiva + "\n\n");
                convite.add("Querida Família " + familia.getNome() + ",\n\n");
                convite.add("Convidamos vocês a participarem da nossa celebração de casamento!\n\n");
                convite.add("Esperamos vocês lá!\n\n");
                convite.add("O código de acesso de vocês é: " + familia.getAcesso() + "\n\n");
                convite.add("----------------------\n\n");
                document.add(convite);
            }

            System.out.println("Convites familiares gerados com sucesso em: " + caminhoArquivo);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

   public void gerarRelatorioPagamentosNoivos(List<Pagamento> pagamentos, long idNoivo, long idNoiva, String caminhoArquivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Adicionar título do documento
            Paragraph titulo = new Paragraph("Relatório de Pagamentos dos Noivos");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n"));

            // Adicionar detalhes dos pagamentos
            double valorTotal = 0;
            Paragraph detalhes = new Paragraph();
            detalhes.add("Pagamentos realizados pelos noivos:\n\n");

            for (Pagamento pagamento : pagamentos) {
                if (pagamento != null && (pagamento.getIdPessoa() == idNoivo || pagamento.getIdPessoa() == idNoiva)) {
                    valorTotal += pagamento.getValor();
                    detalhes.add("Descrição: " + pagamento.getDescricao() + "\n");
                    detalhes.add("Parcela atual: " + pagamento.getParcelaAtual() + ", Total de parcelas: " + pagamento.getParcelaTotal() + "\n");
                    detalhes.add("Situação do pagamento: " + (pagamento.isPagoBoolean() ? "pago" : "a pagar") + "\n\n");
                }
            }

            detalhes.add("Valor total a ser pago: R$ " + String.format("%.2f", valorTotal) + "\n");
            document.add(detalhes);

            System.out.println("Relatório de pagamentos dos noivos gerado com sucesso em: " + caminhoArquivo);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
   
   public void gerarRelatorioConvidadosIndividuais(List<ConvidadoIndividual> convidadosIndividuais, String caminhoArquivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // Adicionar título do documento
            Paragraph titulo = new Paragraph("Relatório de Convidados Individuais");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n"));

            // Verificar se há convidados individuais
            if (convidadosIndividuais.isEmpty()) {
                Paragraph semConvidados = new Paragraph("Não há convidados individuais cadastrados.");
                semConvidados.setAlignment(Element.ALIGN_CENTER);
                document.add(semConvidados);
            } else {
                Paragraph detalhes = new Paragraph();
                for (ConvidadoIndividual ci : convidadosIndividuais) {
                    detalhes.add(ci.toString() + "\n");
                }
                document.add(detalhes);
            }

            System.out.println("Relatório de convidados individuais gerado com sucesso em: " + caminhoArquivo);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
   
   public void gerarRelatorioConvidadosConfirmados(ConvidadoIndividualDAO convidados, List<Fornecedor> fornecedores, String caminhoArquivo) {
    double totalPontos = 0;
    // Criar o documento PDF
    Document document = new Document();
    try {
        // Especificar o caminho do arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
        document.open();

        // Adicionar título
        Paragraph titulo = new Paragraph("Relatório de Convidados Confirmados\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);

        // Adicionar tabela para convidados confirmados
        PdfPTable tabelaConvidados = new PdfPTable(3); // 3 colunas: Nome, Idade, Pontos
        tabelaConvidados.setWidthPercentage(100);
        tabelaConvidados.addCell("Nome");
        tabelaConvidados.addCell("Idade");
        tabelaConvidados.addCell("Pontos");

        for (ConvidadoIndividual ci : convidados.getConvidadosIndividuais()) {
            if (ci != null && ci.isConfirmacao().equals("confirmado")) {
                Pessoa pessoa = ci.getPessoa();
                int idade = calcularIdade(pessoa.getDataNascimento());

                double pontos;
                if (idade <= 8) {
                    pontos = 0; // Crianças que não contam
                } else if (idade >= 9 && idade <= 13) {
                    pontos = 0.5; // Crianças que contam
                } else {
                    pontos = 1.0; // Adultos
                }

                tabelaConvidados.addCell(pessoa.getNome());
                tabelaConvidados.addCell(String.valueOf(idade));
                tabelaConvidados.addCell(String.format("%.1f", pontos));

                totalPontos += pontos;
            }
        }
        document.add(tabelaConvidados);

        // Adicionar fornecedores
        document.add(new Paragraph("\n-------- FORNECEDORES --------\n"));
        PdfPTable tabelaFornecedores = new PdfPTable(2); // 2 colunas: Nome, Pontos
        tabelaFornecedores.setWidthPercentage(100);
        tabelaFornecedores.addCell("Fornecedor");
        tabelaFornecedores.addCell("Pontos");

        for (Fornecedor f : fornecedores) {
            if (f != null) {
                double pontosFornecedor = 0.5;
                tabelaFornecedores.addCell(f.getNome());
                tabelaFornecedores.addCell(String.format("%.1f", pontosFornecedor));
                totalPontos += pontosFornecedor;
            }
        }
        document.add(tabelaFornecedores);

        // Adicionar pontuação total
        document.add(new Paragraph("\nPONTUAÇÃO TOTAL: " + String.format("%.1f", totalPontos)));

    } catch (DocumentException | IOException e) {
        e.printStackTrace();
    } finally {
        document.close();
    }

    System.out.println("Relatório gerado com sucesso!");
}
   private int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
