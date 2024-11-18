import java.util.Random;

public class MergeSort {

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
        int[] arr4 = generarArregloAleatorio(cantidadAleatoria, maxValorAleatorio);

        // Medir el tiempo de ordenación para los tres primeros arreglos
        medirTiempoOrdenacion(arr1, "Arreglo 1");
        medirTiempoOrdenacion(arr2, "Arreglo 2");
        medirTiempoOrdenacion(arr3, "Arreglo 3");

        // Para el arreglo 4, mostramos primero los elementos antes de ordenar
        System.out.println("\nPrimeros 10 elementos antes de ordenar (Arreglo 4):");
        for (int i = 0; i < Math.min(10, arr4.length); i++) {
            System.out.print(arr4[i] + " ");
        }
        System.out.println();

        // Medir el tiempo de ordenación para el arreglo 4
        medirTiempoOrdenacion(arr4, "Arreglo 4");
    }

    // Método para generar un arreglo de números aleatorios con un número específico
    // de elementos
    public static int[] generarArregloAleatorio(int cantidad, int max) {
        int[] arreglo = new int[cantidad];// Crear un arreglo de tamaño cantidad
        Random random = new Random();// Crear un objeto Random
        for (int i = 0; i < cantidad; i++) {// Recorrer el arreglo
            arreglo[i] = random.nextInt(max + 1); // Generar número entre 0 y max (inclusive)
        }
        return arreglo;
    }

    // Método para medir el tiempo de ordenación de un arreglo y mostrar los
    // resultados
    public static void medirTiempoOrdenacion(int[] arreglo, String nombreArreglo) {
        long startTime = System.nanoTime(); // Inicia el tiempo
        mergeSort(arreglo); // Ordenar el arreglo
        long endTime = System.nanoTime(); // Termina el tiempo
        long duration = endTime - startTime; // Calcula la duración en nanosegundos
        double durationInSeconds = duration / 1_000_000_000.0; // Convertir nanosegundos a segundos

        // Imprimir el tiempo de ejecución
        System.out.println(
                "\nTiempo de ejecución para ordenar " + nombreArreglo + ": " + durationInSeconds + " segundos");

        // Imprimir el arreglo ordenado (solo los primeros 10 elementos)
        System.out.println("Primeros 10 elementos después de ordenar (" + nombreArreglo + "):");
        for (int i = 0; i < Math.min(10, arreglo.length); i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    // Implementación de Merge Sort
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length <= 1) {
            return; // Si el arreglo tiene un solo elemento o está vacío, ya está ordenado
        }

        // Dividir el arreglo en dos mitades
        int mid = arreglo.length / 2;// Calcular la mitad del arreglo
        int[] left = new int[mid];// Crear un arreglo para la mitad izquierda
        int[] right = new int[arreglo.length - mid];// Crear un arreglo para la mitad derecha

        System.arraycopy(arreglo, 0, left, 0, mid);// Copiar la mitad izquierda del arreglo
        System.arraycopy(arreglo, mid, right, 0, arreglo.length - mid);// Copiar la mitad derecha del arreglo

        // Ordenar las mitades recursivamente
        mergeSort(left);// Ordenar la mitad izquierda
        mergeSort(right);// Ordenar la mitad derecha

        // Combinar las dos mitades ordenadas
        merge(arreglo, left, right);
    }

    // Método para combinar dos subarreglos ordenados
    public static void merge(int[] arreglo, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Comparar y mezclar los dos arreglos
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arreglo[k++] = left[i++];
            } else {
                arreglo[k++] = right[j++];
            }
        }

        // Agregar los elementos restantes de la lista izquierda, si los hay
        while (i < left.length) {
            arreglo[k++] = left[i++];
        }

        // Agregar los elementos restantes de la lista derecha, si los hay
        while (j < right.length) {
            arreglo[k++] = right[j++];
        }
    }
}
