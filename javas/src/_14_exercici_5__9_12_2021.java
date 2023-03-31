

public class _14_exercici_5__9_12_2021 {
    public static void main(String[] args) {

        // 5. Se tiene una matriz de 20 filas donde cada fila representa las
        // notas parciales de cada alumno (cada alumno posee 3 notas
        // parciales), en cada fila se tiene además una columna para el
        // promedio de notas, para la nota más alta y para la nota más
        // baja. Se pide que:
        //  a. Se ingrese las notas parciales de cada alumno.
        //  b. Se recorra la matriz y se calcule la nota promedio, la
        //     nota más alta y baja del alumno.
        //  c. Imprimir la matriz resultante (en forma de matriz).
        //  d. Imprimir la mejor nota del curso y la peor nota.

        int numAlumnes = 20;
        double[][] matriu = new double[numAlumnes][6];
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        // a) Inicialitzem Notes amb Random
        for (int i = 0; i < numAlumnes; i++) {
            for (int j = 0; j < 3; j++) {
                matriu[i][j] = Math.random() * 10;
            }
            // b) i d)
            matriu[i][3] = (matriu[i][2] + matriu[i][1] + matriu[i][0]) / 3;                // Promig
            matriu[i][4] = Math.max(matriu[i][0], Math.max(matriu[i][1], matriu[i][2]));    // Max
            matriu[i][5] = Math.min(matriu[i][0], Math.min(matriu[i][1], matriu[i][2]));    // Min
        }

        // c) Mostrem Matriu Resultant:
        System.out.println();
        System.out.println(" Nota1  Nota2 Nota3 Promig  Max  Min");

        for (int i = 0; i < numAlumnes; i++) {
            for (int j = 0; j < 6; j++) {
                if (matriu[i][j] < 5) {
                    System.out.printf(RED + "%6.1f" + RESET, matriu[i][j]);
                } else {
                    System.out.printf("%6.1f", matriu[i][j]); //4 posicions per la part entera i 1 per la part decimal
                    // (f de float)
                }
            }
            System.out.println();
        }
    }
}
