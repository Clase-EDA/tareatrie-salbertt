/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.*;
import java.lang.*;

/**
 *
 * @author imac
 */
public class Trie<T extends Comparable<T>> {

    NodoTrie raiz;
    Character[] simbolos;
    int contador;

    public Trie(Character[] simbolos) {
        Arrays.sort(simbolos);
        this.simbolos = simbolos.clone();
        raiz = new NodoTrie(simbolos.length);
        contador = 0;

    }

    public NodoTrie getRaiz() {
        return raiz;
    }

    public Character[] getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(Character[] simbolos) {
        this.simbolos = simbolos;
    }

    public boolean busca(String llave) {
        return busca(llave, raiz);
    }

    private boolean busca(String llave, NodoTrie actual) {
        if (actual == null) {
            return false;
        }
        if (llave.compareTo("") == 0) {
            return actual.isFinPalabra();
        }
        int pos = buscaCar(llave.charAt(0));
        if (pos > -1) {
            return busca(llave.substring(1), actual.getSig(pos));
        } else {
            return false;
        }
    }

    private int buscaCar(Character c) {
        int i = 0;
        while (i < simbolos.length && simbolos[i].compareTo(c) != 0) {
            i++;
        }
        if (i == simbolos.length) {
            return -1;
        }
        return i;
    }

    public void insertar(String pal) {
        //if (!busca(pal)) {
        insertar(pal, raiz);
        //}
    }

    private void insertar(String llave, NodoTrie actual) {

        if (llave.compareTo("") == 0) {
            actual.setFinPalabra(true);
            contador++;
            return;
        }
        int pos = buscaCar(llave.charAt(0));
        if (pos > -1) {
            NodoTrie temp = actual.getSig(pos);
            if (temp == null) {
                temp = new NodoTrie(simbolos.length);
                temp.setPapa(actual);
                temp.setFinPalabra(false);
                actual.getHijos()[pos] = temp;
            }
            insertar(llave.substring(1), temp);
        }
    }

    public boolean eliminar(String llave) {
        boolean res = false, ban;
        NodoTrie act = buscaFin(llave);
        ban = act != null;
        if (ban && llave != null && !llave.equals("")) {
            act.setFinPalabra(false);
            ban = act.estaVacio();
            System.out.println("ban" + ban);
            res = !ban;
            if (ban) {
                res = eliminar(llave, act.getPapa());
            }
        }
        return res;
    }

    private boolean eliminar(String llave, NodoTrie actual) {
        if (actual == null) {
            return false;
        }
        int pos = buscaCar(llave.charAt(llave.length() - 1));
        actual.getHijos()[pos] = null;
        if (actual.isFinPalabra()) {
            return true;
        }
        if (!actual.estaVacio()) {
            return true;
        }
        if (actual.getPapa() == null) {
            return true;
        }
        return eliminar(llave.substring(0, llave.length() - 1), actual.getPapa());
    }

    public NodoTrie buscaFin(String llave) {
        return buscaFin(llave, raiz);
    }

    private NodoTrie buscaFin(String llave, NodoTrie actual) {
        if (actual == null) {
            return null;
        }
        if (llave.compareTo("") == 0) {
            return actual;
        }
        int pos = buscaCar(llave.charAt(0));

        return buscaFin(llave.substring(1), actual.getSig(pos));
    }

    public String ordena() {
        StringBuilder cad = new StringBuilder();
        NodoTrie<T> act = raiz;
        String res = "";
        res = ordena(act, cad, "");
        return res;
    }

    private String ordena(NodoTrie actual, StringBuilder cad, String pal) {
        if (actual == null) {
            return cad.toString();
        }
        if (actual.isFinPalabra()) {
            cad.append(pal);
            cad.append("\n");
        }
        NodoTrie[] arr = actual.getHijos();

        for (int i = 0; i < actual.getHijos().length; i++) {

            if (arr[i] != null) {
                String aux = pal;
                Character car = simbolos[i];
                aux += car;
                ordena(arr[i], cad, aux);
            }
        }
        return cad.toString();
    }
    /**
     * por alguna razon no capta bien el fin palabra hace falta debug para ver qué onda
     * @return 
     */
 public String[] ordenar(){
     String[] resp = new String [contador];
     int i = 0, pos = 0;
     ArrayList<Integer> lista = new ArrayList();
     String palabra = "";
     NodoTrie<T> aux = raiz;
     while(i < contador){ ///sabemos cuántas palabras son
         NodoTrie[] hijos = aux.getHijos();
         int j = pos;
         while(j<hijos.length-1 && hijos[j]==null) //encontrar al siguiente hijo
             j++;
         if(j==hijos.length-1){ //no hubo más hijos; hay que subir
             aux = aux.getPapa();
             palabra= palabra.substring(0, palabra.length()-1); //borrar la última letra para seguir con la palabra
             pos = lista.get(lista.size()-1); //empezar a checar desde donde te quedaste la vez pasada
             lista.remove(lista.size()-1);
         }
         else{
             palabra+=simbolos[j]; //sí hubo otra letra y la agregamos
             if(aux.isFinPalabra()){ //agregar la palabra al arreglo                
                 resp[i] = palabra;
                 System.out.println(palabra);
                 i++;
             }
             if(aux.getSig(j)!=null){ //siguiente nodoTrie
                 aux = aux.getSig(j);
                 lista.add(j); //hay que recordar dónde te quedaste en el nodo anterior
                 pos = 0;
             }
             else
                 pos=j; //seguimos checando los hijos pues ya no hay otro nodo
         }
     }
     
     return resp;
 }
}
