/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadordecasamento;

/**
 *
 * @author victo
 */
public class ConvidadoFamiliaDAO {
    
    ConvidadoFamilia[] familias = new ConvidadoFamilia[100];
    
    boolean adiciona(ConvidadoFamilia f) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            familias[proximaPosicaoLivre] = f;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean vazio() {
        for (ConvidadoFamilia familia : familias) {
            if (familia != null) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrar() {
        boolean temFamilia = false;
        for (ConvidadoFamilia f : familias) {
            if (f != null) {
                System.out.println(f);
                temFamilia = true;
            }
        }
        if (temFamilia == false) {
            System.out.println("Nao ha FAMILIAS cadastradas");
        }
    }
    
    public int proximaPosicaoLivre() {
        for (int i = 0; i < familias.length; i++) {
            if (familias[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean buscaPorNome(String nome) {
        for (ConvidadoFamilia f : familias) {
            if (f != null && f.getNome() != null){
                if(f.getNome().equalsIgnoreCase(nome)){
                   return true; 
                }        
            }
        }
        return false;
    }
    
    public boolean buscarAcesso(String acesso) {
        for (ConvidadoFamilia cf : familias) {
            if (cf.getAcesso() != null) {
                if(cf.getAcesso().equals(acesso)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public ConvidadoFamilia buscarFamilia(String acesso) {
        for (ConvidadoFamilia cf : familias) {
            if(cf != null){
                if (cf.getAcesso() != null) {
                    if(cf.getAcesso().equals(acesso)){
                        return cf;
                    }
                }
            }
            
        }
        return null;
    }
    
    public String buscarAcessoPorFamilia(ConvidadoFamilia familia) {
        if (familia != null) {
            return familia.getAcesso();
        }
        return null;
    }
    
    public ConvidadoFamilia buscarFamiliaPorNome(String familia) {
        for (ConvidadoFamilia cf : familias) {
            if (cf != null && cf.getNome() != null) {
                if(cf.getNome().equals(familia)){
                   return cf; 
                }     
            }
        }
        return null;
    }
}
