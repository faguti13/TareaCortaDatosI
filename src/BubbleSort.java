/**
 * Benchmark del algoritmo de ordenamiento Bubble Sort con n cantidad de elementos random
 * @author Fabián Gutiérrez Jiménez con la ayuda de I.A. ChatGPT 3.5
 */

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int n = 100000;
        int[] arreglo = generarArregloAleatorio(n);

        long startTime = System.currentTimeMillis();
        bubbleSort(arreglo);
        long endTime = System.currentTimeMillis();

        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }

        long tiempoTotal = endTime - startTime;
        System.out.println("\nTiempo de ejecución: " + tiempoTotal + " milisegundos");
    }

    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambio;
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }
    }

    public static int[] generarArregloAleatorio(int n) {
        int[] arreglo = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextInt(1000000); // Números aleatorios en el rango [0, 999]
        }
        return arreglo;
    }
}
