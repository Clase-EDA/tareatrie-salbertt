/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author hca
 */
public class Tries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Character[] simbolos = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Trie trie = new Trie(simbolos);
//
//        trie.inserta("ama");
//        trie.inserta("bobo");
//        trie.inserta("bob");
//        trie.inserta("drake");
//        trie.inserta("draker");
//        trie.inserta("agua");
//
//        trie.borra("drake");
//        trie.borra("agua");
//        System.out.println(trie.toString());
        
        Scanner sc=null;

        try {
            File file = new File("C:\\Users\\Natalia\\Documents\\ITAM\\Estructuras de Datos Avanzadas\\palabras.txt");
            sc = new Scanner(new FileReader(file));

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            System.exit(1);
        }

        String[] arre=new String[10000];
        int i=0;
        while (i < 10000) {
            String text = sc.nextLine().toLowerCase();
            if ((text != null) && (!text.equals("")) && (text.matches("^[a-zA-Z]*$"))) {
                arre[i]=text;
                i++;
            }
        }
        long TInicio, tiempoTrie, tiempoMerge;
        Double tTrie, tMerge;
        TInicio=System.currentTimeMillis();
        trie.ordLex(arre);
        tiempoTrie=System.currentTimeMillis()-TInicio;
        tTrie=tiempoTrie/1000.00;
        System.out.println("El algoritmo de Trie tardó "+tTrie);
        
        TInicio=System.currentTimeMillis();
        MergeSort.mergeSort(arre);
        tiempoTrie=System.currentTimeMillis()-TInicio;
        tTrie=tiempoTrie/1000.00;
        System.out.println("El algoritmo de Merge tardó "+tTrie);

    }
}
