

import java.util.Scanner;

public class _11_exercici_4_arrays__25_11_2021 {
    public static void main(String[] args) {
        //4. Leer por teclado dos vectores de 10 números y mezclarlos en un
        //   tercer vector con el siguiente orden:
        //   • el primer elemento del vector 1
        //   • el primer elemento del vector 2
        //   • el segundo elemento del vector 1
        //   • el segundo elemento del vector 2
        //   • ……

        Scanner input = new Scanner(System.in);
        int[] vector1 = new int[10];
        int[] vector2 = new int[10];
        int[] vector3 = new int[20];

        //Omplim el primer vector
        for (int i = 0; i < vector1.length; i++) {
            System.out.println("Dona'm un numero per al vector 1: ");
            vector1[i] = input.nextInt();
        }
        input.nextLine();

        //Omplim el segon vector
        for (int i = 0; i < vector2.length; i++) {
            System.out.println("Dona'm un numero per al vector 2: ");
            vector1[i] = input.nextInt();
        }
        input.nextLine();


        for (int i = 0; i < 10; i++) {
            vector3[i*2]=vector1[i];
            vector3[i*2+1]=vector2[i];
        }

        for (int i = 0; i < vector3.length; i++) {
            System.out.printf(vector3[i]+",");
        }
    }
}
