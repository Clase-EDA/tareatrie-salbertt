/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author imac
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder merge = new StringBuilder();
        StringBuilder tries = new StringBuilder();
        for (int palabras = 1000; palabras <= 9000; palabras += 200) {
            Character arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
            Trie<String> t = new Trie(arr);
            Scanner sc = null;
            String[] lista = new String[90000], aux = new String[90000];
            int i = 0, numPalabras;
            boolean ban;
            double TInicio, TFin, tiempo;
            MergeSort m = new MergeSort();
            try {
                File ent = new File("/Users/imac/Desktop/eda/palabras.txt");
                sc = new Scanner(new FileReader(ent));

            } catch (FileNotFoundException e) {
                System.out.println("Input file not found");
                System.exit(1);
            }
            while (i<9000&&sc.hasNext()) {
                String text = sc.nextLine().toLowerCase();
                ban = true;
                if ((text != null) && (!text.equals(""))) {
                    lista[i] = text;
                    i++;
                }
            }
            numPalabras = i;

            for (int k = 0; k < i; k++) {
                aux[k] = lista[k];
            }

            
            for (int j = 0; j < palabras; j++) {
                t.insertar(lista[j]);
            }
            TInicio = System.currentTimeMillis();
            t.ordena();
            TFin = System.currentTimeMillis();
            //System.out.println(Arrays.toString(res));
            tiempo = TFin - TInicio;
            //System.out.println("TRIE: tiempo en insertar y ordenar " + t.contador + " palabras: " + tiempo + "milisegundos");
            tries.append(tiempo+ "\n");
            
            TInicio = System.currentTimeMillis();            
            m.mergeSort(aux, 0, palabras - 1);
            TFin = System.currentTimeMillis();
            tiempo = TFin - TInicio;
            //System.out.println("MERGE SORT: se acomodaron " + palabras + " en " + tiempo + " milisegundos");
            merge.append(tiempo + "\n");
            
        }
        System.out.println("TRIE: " + tries.toString());
        System.out.println("MERGE: " + merge.toString());
    }//main
}
