/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author imac
 */
public class NodoTrie <T extends Comparable <T>>{
    NodoTrie[] hijos; 
    boolean finPalabra;
    NodoTrie papa;
    
    public NodoTrie(int numHijos) {
        finPalabra= false;
        hijos = new NodoTrie[numHijos];
        papa = null;
    }

    public NodoTrie(NodoTrie[] hijos) {
        this.hijos = hijos;
        finPalabra = false;
        papa = null;
    }
/**
 * asume que los hijos van a ser las letras del abecedario (26)
 */
    public NodoTrie() {
        finPalabra= true;
        hijos = new NodoTrie[26];
    }
    
    
    

    public NodoTrie[] getHijos() {
        return hijos;
    }

    public void setHijos(NodoTrie[] hijos) {
        this.hijos = hijos;
    }
    
    public NodoTrie getSig(int pos) {
        return hijos[pos];
    }

    public NodoTrie getPapa() {
        return papa;
    }

    public void setPapa(NodoTrie papa) {
        this.papa = papa;
    }
    

    public boolean isFinPalabra() {
        return finPalabra;
    }
    
    public void setFinPalabra(boolean finPalabra) {
        this.finPalabra = finPalabra;
    }
    
    public boolean estaVacio() {
        boolean res = true;
        int i = 0;
        while (res && i < hijos.length) {
            if (hijos[i] != null) {
                res = false;
            }
            i++;
        }
        return res;
    }

    public int cantHijos(){
        int cont=0;
        for(int i=0; i<hijos.length;i++){
            if (hijos[i] != null) {
                cont++;
            }
            
        }
        return cont;
    }    

    @Override
    public String toString() {
        StringBuilder strHijos = new StringBuilder();
        for(int i= 0; i < hijos.length; i++)
            if(hijos[i]!=null)
                strHijos.append(hijos[i] + " ");
        return "NodoTrie{" + "hijos=" + strHijos.toString() + ", finPalabra=" + finPalabra + '}';
    }
    
    
}
