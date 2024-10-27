/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
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
        boolean temFamilia = false;
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null) {
                System.out.println(ci);
                temFamilia = true;
            }
        }
        if (temFamilia == false) {
            System.out.println("Nao ha CONCIDADOS INDIVIDUAIS cadastrados");
        }
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

    
    public ConvidadoIndividual[] buscarConvidadosPorFamilia(ConvidadoFamilia familia) {
        ConvidadoIndividual[] convidadosDaFamilia = new ConvidadoIndividual[100];
        int count = 0;
        
        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.getFamilia() != null ) {
                if(ci.getFamilia().equals(familia)){
                  if (count < convidadosDaFamilia.length) {
                    convidadosDaFamilia[count] = ci;
                    count++;
                  } else {
                      System.out.println("Nao ha mais espaco para pessoa dessa familia.");
                      break;
                  }   
                }
            }
        }
        return convidadosDaFamilia;
    }
    
    public ConvidadoIndividual[] obterConvidadosConfirmados() {
        ConvidadoIndividual[] convidadosConfirmados = new ConvidadoIndividual[100];
        int count = 0;

        for (ConvidadoIndividual ci : convidadosIndividuais) {
            if (ci != null && ci.isConfirmacao() == true) { 
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
    
