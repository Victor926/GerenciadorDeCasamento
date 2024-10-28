/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

import java.time.LocalDate;
import java.time.Period;

public class ConvidadoIndividualDAO {
    
    ConvidadoIndividual[] convidadosIndividuais = new ConvidadoIndividual[100];
    
    boolean adiciona(ConvidadoIndividual ci) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            convidadosIndividuais[proximaPosicaoLivre] = ci;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean vazio() {
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        StringBuilder sb = new StringBuilder();
        boolean temFamilia = false;
        
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null) {
                sb.append(ci).append("\n");
                temFamilia = true;
            }
        }
        
        if (!temFamilia) {
            sb.append("Nao ha CONVIDADOS INDIVIDUAIS cadastrados");
        }
        
        System.out.println(sb.toString());
    }
    
    public double mostrarConfirmados(double totalPontos) {
        boolean temFamilia = false;
        totalPontos = 0;
        
        System.out.println("-------- LISTA DE CONVIDADOS CONFIRMADOS --------:");
        System.out.println("\n NOME \t\t IDADE \t\t PONTOS\n");
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null) {
                if (ci.isConfirmacao().equals("confirmado")) {
                    temFamilia = true;
                    Pessoa pessoa = ci.getPessoa();
                    int idade = calcularIdade(pessoa.getDataNascimento());

                    double pontos;
                    if (idade <= 8) {
                        // CRIANCAS QUE NAO CONTAM
                        pontos = 0;
                    } else if (idade >= 9 && idade <= 13) {
                        // CRIANCAS QUE CONTAM
                        pontos = 0.5;
                    } else {
                        // ADULTOS
                        pontos = 1.0;
                    }

                    System.out.printf("%s\t\t%d\t\t%.1f%n", pessoa.getNome(), idade, pontos);
                    totalPontos += pontos;
                }
            }
        }
        
        if (!temFamilia) {
            System.out.println("Nao ha CONVIDADOS INDIVIDUAIS cadastrados");
        }
        
        return totalPontos;
    }
    
    private int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    
    public int proximaPosicaoLivre() {
        for (int i = 0; i < convidadosIndividuais.length; i++) {
            if (convidadosIndividuais[i] == null) {
                return i;
            }
        }
        return -1;
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

    public void confirmarPresenca(ConvidadoFamilia familia, String confirmacao) {
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null) {
                if (ci.getFamilia().equals(familia)) {
                    ci.setConfirmacao(confirmacao);
                }
            }
        }
    }

    public ConvidadoIndividual[] obterConvidadosConfirmados() {
        ConvidadoIndividual[] convidadosConfirmados = new ConvidadoIndividual[100];
        int count = 0;

        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.isConfirmacao().equals("confirmado")) { 
                if (count < convidadosConfirmados.length) {
                    convidadosConfirmados[count] = ci;
                    count++;
                } else {
                    System.out.println("Limite de convidados confirmados atingido.");
                    break;
                }
            }
        }

        return convidadosConfirmados;
    }
}
