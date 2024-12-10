/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;

public class ConvidadoIndividualDAO {

    private ArrayList<ConvidadoIndividual> convidadosIndividuais = new ArrayList<>();

    public boolean adiciona(ConvidadoIndividual ci) {
        return convidadosIndividuais.add(ci); // Adiciona diretamente à lista
    }

    public boolean vazio() {
        return convidadosIndividuais.isEmpty(); // Verifica se a lista está vazia
    }

    public void mostrar() {
        StringBuilder sb = new StringBuilder();
        if (convidadosIndividuais.isEmpty()) {
            sb.append("Nao ha CONVIDADOS INDIVIDUAIS cadastrados");
        } else {
            for (ConvidadoIndividual ci : convidadosIndividuais) {
                sb.append(ci).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public double mostrarConfirmados(double totalPontos) {
        boolean temConfirmados = false;
        totalPontos = 0;

        System.out.println("-------- LISTA DE CONVIDADOS CONFIRMADOS --------:");
        System.out.println("\n NOME \t\t IDADE \t\t PONTOS\n");
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.isConfirmacao().equals("confirmado")) {
                temConfirmados = true;
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

                System.out.printf("%s\t\t%d\t\t%.1f%n", pessoa.getNome(), idade, pontos);
                totalPontos += pontos;
            }
        }

        if (!temConfirmados) {
            System.out.println("Nao ha CONVIDADOS INDIVIDUAIS cadastrados");
        }

        return totalPontos;
    }

    private int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public ConvidadoIndividual buscaPorPessoa(Pessoa pessoa) {
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.getPessoa().equals(pessoa)) {
                return ci;
            }
        }
        return null;
    }

    public ConvidadoIndividual buscaPorNome(String nome) {
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.getPessoa().getNome().equalsIgnoreCase(nome)) {
                return ci;
            }
        }
        return null;
    }
    
    public boolean buscaPorId(Long id) {
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.getPessoa().getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void confirmarPresenca(ConvidadoFamilia familia, String confirmacao) {
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.getFamilia().equals(familia)) {
                ci.setConfirmacao(confirmacao);
            }
        }
    }
    

    public ArrayList<ConvidadoIndividual> obterConvidadosConfirmados() {
        ArrayList<ConvidadoIndividual> convidadosConfirmados = new ArrayList<>();
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.isConfirmacao().equals("confirmado")) {
                convidadosConfirmados.add(ci);
            }
        }

        if (convidadosConfirmados.isEmpty()) {
            System.out.println("Nenhum convidado confirmado.");
        }

        return convidadosConfirmados;
    }
    
    public boolean removerPorIdPessoa(long idPessoa){
        return convidadosIndividuais.removeIf(p -> p.getPessoa().getId() == idPessoa);
    }
    
    public boolean remover(long idConvidado) {
        for (int i = 0; i < convidadosIndividuais.size(); i++) {
            ConvidadoIndividual convidado = convidadosIndividuais.get(i);
            if (convidado != null && convidado.getId() == idConvidado) {
                convidadosIndividuais.remove(i);
                return true; 
            }
        }
        return false;
    }
    public boolean removerPorFamiliaId(long idFamilia) {
    int cont = 0;
    Iterator<ConvidadoIndividual> iterator = convidadosIndividuais.iterator();

    while (iterator.hasNext()) {
        ConvidadoIndividual ci = iterator.next();
        if (ci != null && ci.getFamilia().getId() == idFamilia) {
                iterator.remove();
                cont++;
            }
        }
        return cont != 0;
    }

}

