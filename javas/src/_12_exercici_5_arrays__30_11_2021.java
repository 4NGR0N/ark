
import java.util.Scanner;

public class _12_exercici_5_arrays__30_11_2021 {
    public static void main(String[] args) {
        //5. Crear un programa que lea por teclado un vector de 10 números
        //   enteros y lo desplace una posición hacia la derecha: el primer
        //   elemento pasa a ser el segundo, el segundo pasa a ser el tercero
        //   y así sucesivamente; el último elemento pasa a ser el primero.

        Scanner entrada = new Scanner(System.in);
        int[] vector = new int [10];
        int acc=0;

        //introduïm els 10 nombres.
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Entra un valor per al array (posició nº"+i+") :");
            vector[i]=entrada.nextInt();
        }

        entrada.nextLine();

        System.out.println("Els teus numeros son: ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]+",");
        }
        entrada.nextLine();

        acc = vector[vector.length-1];
        for (int i = vector.length-1; i > 0; i--) {
            vector[i] = vector[i-1];
        }
        vector[0]=acc;
        entrada.nextLine();

        System.out.println("El resultat es: ");

        //treiem els valors per pantalla.
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]+",");
        }
    }
}
