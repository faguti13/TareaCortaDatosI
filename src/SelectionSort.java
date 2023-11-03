/**
 * Benchmark del algoritmo de ordenamiento Selection Sort con n cantidad de elementos random
 * @author Fabián Gutiérrez Jiménez con la ayuda de I.A. ChatGPT 3.5
 */
public class SelectionSort {
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
}
