
//importamos el random 
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {

        // creamos cuatro arreglos distintos con diferente orden cumpliendo las
        // caracteristicas pedidas
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 6, 3, 5, 7, 8 };
        int[] arr3 = { 5, 4, 3, 2, 1 };

        // creamos un arreglo el cual contiene el tamaño del arreglo y el maximo de
        // numeros aleatorios que va a escoger el programa
        int tamanoArreglo = 10000;
        int maximo = 10000;
        int[] arr4 = crearArreglosAleatorios(tamanoArreglo, maximo);

        // se llama a la funcion que ordena los arreglos
        bubbleSort(arr1);
        bubbleSort(arr2);
        bubbleSort(arr3);

        // se empieza a medeir el tiempo desde que inicia el ordenamiento del arr4 hasta
        // que termina para saber cuanto se demoro en ordenarlo
        long inicio = System.nanoTime();
        bubbleSort(arr4);
        long fin = System.nanoTime();

        // se imprimen los primeros arreglos que son cortos para saber si funciona la
        // funcion de ordenamiento bubble
        imprimirArreglo(arr1);
        imprimirArreglo(arr2);
        imprimirArreglo(arr3);

        // se resta el tiempo final e inicial para que nos de el intervalo de tiempo el
        // cual se demora y se pasa a segundos despues este se imprime
        double tiempoEnSegundos = (fin - inicio) / 1_000_000_000.0;
        System.out.println("Tiempo de ejecución para arr4: " + tiempoEnSegundos + " segundos");
    }

    // se crea una funcion que no retorna nada y recibe como parametro un arreglo
    public static void bubbleSort(int[] arr) {
        // este for i lo que hace es recorrer todo los elementos del arreglo
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // si el elemento actual es mayor que el siguiente, se intercambian
                if (arr[j] > arr[j + 1]) {
                    // Intercambio de valores utilizando una variable auxiliar
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    // creamos una funcion que no retorna nada y recibe como parametro un arreglo
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

    // creamos una funcion que retorna un arreglo y recibe como parametrodos enteros
    // uno que es el tamaño del arreglo y otro que es el maximo de numeros que va a
    // coger de numeros aleatorios
    public static int[] crearArreglosAleatorios(int tamanoArreglo, int maximo) {
        // creamos el random
        Random random = new Random();
        // creamos un arreglo y le asignamos el tamaño que recibimos en el parametro
        int[] arr = new int[tamanoArreglo];
        // este ciclo recorre todo el arreglo
        for (int i = 0; i < tamanoArreglo; i++) {
            // se le asigna a cada indice un valor random de la cantidd maxima pasada por el
            // parametro
            arr[i] = random.nextInt(maximo);
        }
        // retorna el arreglo una vez completado
        return arr;
    }
}
