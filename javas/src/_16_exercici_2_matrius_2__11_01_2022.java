

public class _16_exercici_2_matrius_2__11_01_2022 {
    public static void main(String[] args) {
        /*

        * 1  2  3  4  5
        * 6  7  8  9  10
        * 11 12 13 14 15
        * 16 17 18 19 20
        * 21 22 23 24 25

        */

        int[][] matriu=new int[5][5];
        int contador = 1;

        //generar els valors de la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = contador;
                contador++;
            }
        }

        //mostrar els valors de la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.printf("%3s", matriu[i][j]);
            }
            System.out.println();
        }
    }
}
