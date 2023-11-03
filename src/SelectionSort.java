/**
 * Benchmark del algoritmo de ordenamiento Selection Sort con n cantidad de elementos random
 * @author Fabián Gutiérrez Jiménez con la ayuda de I.A. ChatGPT 3.5
 */

import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int n = 100000;
        int[] arreglo = generarArregloAleatorio(n);

        long startTime = System.currentTimeMillis();
        selectionSort(arreglo);
        long endTime = System.currentTimeMillis();

        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }

        long tiempoTotal = endTime - startTime;
        System.out.println("\nTiempo de ejecución: " + tiempoTotal + " milisegundos");
    }

    public static void selectionSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = arreglo[i];
            arreglo[i] = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = temp;
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
