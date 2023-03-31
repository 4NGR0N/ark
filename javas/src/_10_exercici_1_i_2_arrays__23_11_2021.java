

import java.util.Scanner;

public class _10_exercici_1_i_2_arrays__23_11_2021 {
    public static void main(String[] args) {
        // 1. Leer 5 números por teclado, guardarlos en un vector y mostrarlos
        // en el mismo orden introducido. (Utilizaremos un bucle para pedir
        // los valores al usuario y guardarlos al vector; y otro bucle para
        // mostrarlos).

        int[] numeros = new int[5];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digue'm un número:");
            numeros[i] = input.nextInt();
            input.nextLine();
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("La posicio "+ i +" del array té el "+numeros[i]);
        }

        // 2. Leer 5 números por teclado, guardarlos en un vector y mostrarlos
        // en orden inverso al introducido.

        System.out.println("\nEls numeros inversos:\n");

        for (int j = numeros.length-1; j >= 0 ; j--) {
            if(j==0){
                System.out.print(numeros[j]);
            }else{
                System.out.print(numeros[j] + ", ");
            }
        }
    }
}
