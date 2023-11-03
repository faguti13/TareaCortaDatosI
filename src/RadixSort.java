/**
 * Benchmark del algoritmo de ordenamiento Radix Sort con n cantidad de elementos random
 * @author Fabián Gutiérrez Jiménez con la ayuda de I.A. ChatGPT 3.5
 */

import java.util.Random;

public class RadixSort {
    public static void main(String[] args) {
        int n = 1000000;
        int[] arreglo = generarArregloAleatorio(n);

        long startTime = System.currentTimeMillis();
        radixSort(arreglo);
        long endTime = System.currentTimeMillis();

        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }

        long tiempoTotal = endTime - startTime;
        System.out.println("\nTiempo de ejecución: " + tiempoTotal + " milisegundos");
    }

    public static void radixSort(int[] arreglo) {
        int n = arreglo.length;
        int maximo = encontrarMaximo(arreglo);

        for (int exp = 1; maximo / exp > 0; exp *= 10) {
            contarOrdenarPorDigito(arreglo, n, exp);
        }
    }

    public static void contarOrdenarPorDigito(int[] arreglo, int n, int exp) {
        int[] resultado = new int[n];
        int[] cuenta = new int[10];

        for (int i = 0; i < n; i++) {
            cuenta[(arreglo[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            cuenta[i] += cuenta[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            resultado[cuenta[(arreglo[i] / exp) % 10] - 1] = arreglo[i];
            cuenta[(arreglo[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arreglo[i] = resultado[i];
        }
    }

    public static int encontrarMaximo(int[] arreglo) {
        int maximo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }
        return maximo;
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
