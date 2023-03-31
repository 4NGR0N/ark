

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _12_exercici_7_arrays__30_11_2021 {
    public static void main(String[] args) {
        //7. Leer 10 enteros ordenados crecientemente. Leer un número entero
        //   N y buscarlo en el vector. Se tiene que mostrar la posición en
        //   que se encuentra. Si no está, indicarlo con un mensaje.

        Scanner entrada = new Scanner(System.in);
        int[] vector1 = new int[10];

        System.out.println("Entra els 10 números del vector ordenats");
        for (int i = 0; i < vector1.length; i++) {
            vector1[i]= entrada.nextInt();
        }
        entrada.nextLine();

        Arrays.sort(vector1);

        System.out.print("Vector ordenat: ");
        for (int i = 0; i < vector1.length; i++) {
            System.out.print(vector1[i] + " ");
        }
        entrada.nextLine();

        System.out.println("Dona' m el numero que estàs buscant: ");
        int aux = entrada.nextInt();
        Boolean flag = false;
        for (int i = 0; i < vector1.length; i++) {
            if(vector1[i]==aux){
                System.out.println("El nombre buscat "+aux+" es a la posició ["+i+"] del array");
                flag=true;
                break;
            }
        }

        entrada.nextLine();
        if(!flag){
            System.out.println("El nombre buscat no existeix");
        }
    }
}
