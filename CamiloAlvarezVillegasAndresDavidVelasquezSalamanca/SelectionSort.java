import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        // Arreglo 1: Lista ordenada del 1 al 5
        int[] arr1 = { 1, 2, 3, 4, 5 };

        // Arreglo 2: Lista desordenada con 10 números
        int[] arr2 = { 2, 6, 3, 5, 7, 8, 9, 1, 4, 0 };

        // Arreglo 3: Lista ordenada inversamente del 5 al 1
        int[] arr3 = { 5, 4, 3, 2, 1 };

        // Arreglo 4: Lista con números aleatorios
        int cantidadAleatoria = 1000000; // Número de elementos aleatorios
        int maxValorAleatorio = 9999; // Rango máximo para los números aleatorios
        int[] arr4 = generarArregloAleatorio(cantidadAleatoria, maxValorAleatorio);// Generar un arreglo aleatorio con
                                                                                   // la cantidad y el valor máximo
                                                                                   // especificados con anterioridad

        // Medimos el tiempo de ordenación para los tres primeros arreglos
        medirTiempoOrdenacion(arr1, "Arreglo 1");
        medirTiempoOrdenacion(arr2, "Arreglo 2");
        medirTiempoOrdenacion(arr3, "Arreglo 3");

        // Para el arreglo 4, mostramos primero los elementos antes de ordenar para
        // confirmar el funcionamiento de la lista aleatoria
        System.out.println("\nPrimeros 10 elementos antes de ordenar (Arreglo 4):");
        for (int i = 0; i < Math.min(10, arr4.length); i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();

        // Medimos el tiempo de ordenación para el arreglo 4
        medirTiempoOrdenacion(arr4, "Arreglo 4");
    }

    // Método para generar un arreglo de números aleatorios con un número específico
    // de elementos
    public static int[] generarArregloAleatorio(int cantidad, int max) {
        int[] arreglo = new int[cantidad];// Crear un arreglo de tamaño cantidad
        Random random = new Random();// Crear un objeto Random
        for (int i = 0; i < cantidad; i++) {// Recorrer el arreglo
            arreglo[i] = random.nextInt(max + 1); // Generar número entre 0 y el valor máximo incluyendolo
        }
        return arreglo;// Retornar el arreglo
    }

    // Método para medir el tiempo de ordenación de un arreglo y mostrar los
    // resultados
    public static void medirTiempoOrdenacion(int[] arreglo, String nombreArreglo) {
        long startTime = System.nanoTime(); // Inicia el tiempo
        selectionSort(arreglo); // Ordenar el arreglo usando Selection Sort
        long endTime = System.nanoTime(); // Termina el tiempo
        long duration = endTime - startTime; // Calcula la duración en nanosegundos
        double durationInSeconds = duration / 1_000_000_000.0; // Convierte de nanosegundos a segundos
        // Imprimir el tiempo de ejecución
        System.out.println(
                "\nTiempo de ejecución para ordenar " + nombreArreglo + ": " + durationInSeconds + " segundos");

        // Imprime los primeros 10 elementos del arreglo ordenado para confirmar que la
        // lista se haya generado normalmente
        System.out.println("Primeros 10 elementos después de ordenar (" + nombreArreglo + "):");
        for (int i = 0; i < Math.min(10, arreglo.length); i++) {// Recorrer los primeros 10 elementos del arreglo
            System.out.print(arreglo[i] + " ");// Imprimir el elemento de la posicion i junto al espacio
        }
        System.out.println();
    }

    // Implementación de Selection Sort
    public static void selectionSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el índice del elemento mínimo en el arreglo no ordenado
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento no ordenado
            int temp = arreglo[minIndex];
            arreglo[minIndex] = arreglo[i];
            arreglo[i] = temp;
        }
    }
}
