import java.util.Random;
import java.util.Scanner;

public class Benchmark {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos deseados en el arreglo");
        int n = scanner.nextInt();
        int[] arreglo = generarArregloAleatorio(n);
        System.out.println("Arreglo generado:");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("\nSeleccione el algoritmo de ordenamiento que desea usar\n\t1 -> Bubble Sort\n\t2 -> Selection Sort\n\t3 -> Insertion Sort\n\t4 -> Shell Sort\n\t5 -> Merge Sort\n\t6 -> Quick Sort\n\t7 -> Radix Sort\n");
        int opt = scanner.nextInt();
        String algoritmo= " ";

        long startTime = System.currentTimeMillis();
        switch (opt){
            case 1:
                algoritmo="Bubble Sort";
                BubbleSort.bubbleSort(arreglo);
                break;
            case 2:
                algoritmo="Selection Sort";
                SelectionSort.selectionSort(arreglo);
                break;
            case 3:
                algoritmo="Insertion Sort";
                InsertionSort.insertionSort(arreglo);
                break;
            case 4:
                algoritmo="Shell Sort";
                ShellSort.shellSort(arreglo);
                break;
            case 5:
                algoritmo="Merge Sort";
                MergeSort.mergeSort(arreglo);
                break;
            case 6:
                algoritmo="Quick Sort";
                QuickSort.quickSort(arreglo);
                break;
            case 7:
                algoritmo="Radix Sort";
                RadixSort.radixSort(arreglo);
                break;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Arreglo de "+ n +" elementos, ordenado mediante el método "+algoritmo+": ");
        /*for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }*/

        long tiempoTotal = endTime - startTime;
        System.out.println("\nTiempo de ejecución: " + tiempoTotal + " milisegundos");
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
