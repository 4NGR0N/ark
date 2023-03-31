

import java.util.Scanner;

public class _12_Matrius__2_12_2021 {
    public static void main(String[] args) {

        // 1. Crear una matriz de nxm de números enteros ingresados por el
        //      usuario, realizar la suma de cada columna y almacenarla en un
        //      vector de dimensión m.

        Scanner input = new Scanner(System.in);
        int longVec = 5;
        int[][] matriu = new int[3][longVec];

        // Omplim la primera fila de la matriu
        System.out.println("Introdueix els "+longVec+" valors de la primera fila");
        for (int i = 0; i < matriu[0].length; i++) {
            matriu[0][i]= input.nextInt();
        }
        input.nextLine();

        // Omplim la segona fila de la matriu
        System.out.println("Introdueix els "+longVec+" valors de la segona fila");
        for (int i = 0; i < matriu[1].length; i++) {
            matriu[1][i]= input.nextInt();
        }
        input.nextLine();

        for (int i = 0; i < matriu[2].length; i++) {
            matriu[2][i] = matriu[0][i]+matriu[1][i];
        }

        // Mostrem la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.printf("%3d",matriu[i][j]);
            }
            System.out.println();
        }
    }
}
