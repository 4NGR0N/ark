

import java.util.Scanner;

public class _13_exercici_6_arrays__2_12_2021 {
    public static void main(String[] args) {
        // 6. Leer por teclado un vector de 10 elementos numéricos enteros y
        //      una posición (entre 0 y 9). Eliminar el elemento situado en la
        //      posición dada sin dejar vacíos. (Mover los elementos hacía la
        //      izquierda del array, y en el último elemento guardar un -1, este
        //      -1 no se imprimirá en el array final).
        //      Ejemplo:
        //      Array de 10 elementos: 1,2,3,4,5,6,7,8,9,10
        //      Posición del elemento = 3
        //      Array final = 1,2,3,5,6,7,8,9,10,

        Scanner entrada = new Scanner(System.in);
        int longVec = 10, posicio = 0;
        int[] vector = new int[longVec];

        // Omplim el vector
        System.out.println("Dona' m els 10 números del vector");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = entrada.nextInt();
        }
        entrada.nextLine();

        // Demanem la posició
        System.out.println("Dona' m la posició que desitges esborrar");
        posicio = entrada.nextInt();
        entrada.nextLine();

        // Desplacem els números a partir de la posició introduïda
        for (int i = posicio; i < vector.length-1; i++) {
            vector[i]=vector[i+1];
        }

        // Posem -1 al final del array
        vector[vector.length-1] = -1;

        System.out.println("Vector resultant: ");
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] != -1){
                System.out.print(vector[i]+",");
            }
        }
    }
}
