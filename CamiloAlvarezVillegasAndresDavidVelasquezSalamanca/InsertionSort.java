
//importamos el random
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {

        // creamos cuatro arreglos distintos con diferente orden cumpliendo las
        // características pedidas
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 6, 3, 5, 7, 8 };
        int[] arr3 = { 5, 4, 3, 2, 1 };

        // creamos un arreglo el cual contiene el tamaño del arreglo y el máximo de
        // números aleatorios que va a escoger el programa
        int tamanoArreglo = 10000;
        int maximo = 10000;
        int[] arr4 = crearArreglosAleatorios(tamanoArreglo, maximo);

        // se llama a la función que ordena los arreglos con Insertion Sort
        insertionSort(arr1);
        insertionSort(arr2);
        insertionSort(arr3);

        // se empieza a medir el tiempo desde que inicia el ordenamiento del arr4 hasta
        // que termina para saber cuánto se demoró en ordenarlo
        long inicio = System.nanoTime();
        insertionSort(arr4);
        long fin = System.nanoTime();

        // se imprimen los primeros arreglos que son cortos para saber si funciona la
        // función de ordenamiento Insertion Sort
        imprimirArreglo(arr1);
        imprimirArreglo(arr2);
        imprimirArreglo(arr3);

        // se resta el tiempo final e inicial para que nos dé el intervalo de tiempo el
        // cual se demora y se pasa a segundos después este se imprime
        double tiempoEnSegundos = (fin - inicio) / 1_000_000_000.0;
        System.out.println("Tiempo de ejecución para arr4: " + tiempoEnSegundos + " segundos");
    }

    // algoritmo de Insertion Sort
    public static void insertionSort(int[] arr) {
        // recorre el arreglo comenzando desde el segundo elemento (índice 1)
        for (int i = 1; i < arr.length; i++) {
            // guardamos el valor a insertar
            int aux = arr[i];
            // empezamos a comparar con el elemento anterior a el aux
            int j = i - 1;
            // desplazamos los elementos mayores que el aux una posición a la derecha
            while (j >= 0 && arr[j] > aux) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // colocamos el aux en su posición correcta
            arr[j + 1] = aux;
        }
    }

    // creamos una función que no retorna nada y recibe como parámetro un arreglo
    public static void imprimirArreglo(int[] arr) {
        // este for recorre todo el arreglo
        for (int i = 0; i < arr.length; i++) {
            // se imprime cada elemento del arreglo a medida que se recorre este y lo separa
            // por una coma
            System.out.print(arr[i] + ",");
        }
        // crea un espacio
        System.out.println();
    }

    // creamos una función que retorna un arreglo y recibe como parámetros dos
    // enteros
    // uno que es el tamaño del arreglo y otro que es el máximo de números que va a
    // coger de números aleatorios
    public static int[] crearArreglosAleatorios(int tamanoArreglo, int maximo) {
        // creamos el random
        Random random = new Random();
        // creamos un arreglo y le asignamos el tamaño que recibimos en el parámetro
        int[] arr = new int[tamanoArreglo];
        // este ciclo recorre todo el arreglo
        for (int i = 0; i < tamanoArreglo; i++) {
            // se le asigna a cada índice un valor random de la cantidad máxima pasada por
            // el
            // parámetro
            arr[i] = random.nextInt(maximo);
        }
        // retorna el arreglo una vez completado
        return arr;
    }
}
