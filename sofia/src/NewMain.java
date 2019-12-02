/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author imac
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Character abc[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Trie t = new Trie(abc);
        t.insertar("a");
        t.insertar("amo");
        System.out.println(t.contador);
        String b[];
        b = t.ordenar();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
    
}
