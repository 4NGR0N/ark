

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class _13_exercici_2_Matrius__2_12_2021 {
    public static void main(String[] args) throws InterruptedException {
        // 2.   Para el ejercicio anterior, cambiar el vector por una matriz
        //      de 3xm y almacenar además de la suma, el valor más alto de
        //      cada columna y el valor más pequeño.

        Scanner input = new Scanner(System.in);
        int fil,col;
        int[][] matriu;
        int[] vectorResultat;

        System.out.println("De quantes files vols la matriu?");
        fil = input.nextInt();
        input.nextLine();

        System.out.println("Quantes columnes vols a la matriu?");
        col = input.nextInt();
        input.nextLine();

        matriu = new int[fil][col];
        vectorResultat = new int[col];

        // Omplim la matriu de dades
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.printf("Introdueix el nombre de la posicio %d %d",i,j);
                matriu[i][j] = input.nextInt();
            }
        }
        input.nextLine();


        // Mostrem la matriu i de pas sumem
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.printf("%3d",matriu[i][j]);
                vectorResultat[j] = vectorResultat[j] + matriu[i][j];
                TimeUnit.MILLISECONDS.sleep(700);
            }
            System.out.println();
        }

        // Mostrem el vector resultant
        System.out.println("+___________________");
        for (int i = 0; i < vectorResultat.length; i++) {
            System.out.printf("%3d",vectorResultat[i]);
        }
    }
}
