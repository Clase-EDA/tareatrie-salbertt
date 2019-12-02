/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author imac
 */
public class MergeSort<T extends Comparable<T>> {

    public void mergeSort(T[] datos, int min, int max) { //LAS DOS MITADES YA ESTAN ORDENADAS
        //vas comparando i con j y avanza el que fue menor. si se acaba alguno, copias todo lo que queda del otro
        T[] temp;
        int indice, izq, der;
        if (min == max) {
            return;
        }

        int tam = max - min + 1;
        int mitad = (max + min) / 2;
        izq = min;
        der = mitad + 1;
        temp = (T[]) (new Comparable[tam]);
        mergeSort(datos, min, mitad);
        mergeSort(datos, mitad + 1, max);

        for (int i = 0; i < tam; i++) {
            if (izq <= mitad && der <= max) {
                if (datos[izq].compareTo(datos[der]) < 0) {
                    temp[i] = datos[izq++]; //escibirlo así hace que primero acceda al valor de izq, lo usa, y luego le suma 1. Para que sume 1 primero, se escribe como ++i
                } else {
                    temp[i] = datos[der++];
                }
            } else {
                if (izq <= mitad) {
                    temp[i] = datos[izq++];
                } else {
                    temp[i] = datos[der++];
                }
            }

        }
    }

    public void merge(T arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Object L[] = new Object[n1];
        Object R[] = new Object[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (((T) L[i]).compareTo((T) (R[j])) <= 0) {
                arr[k] = (T) L[i];
                i++;
            } else {
                arr[k] = (T) R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = (T) L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = (T) R[j];
            j++;
            k++;
        }
    }

    public void mergeSort2(T[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }


}
