

public class _16_exercici_5_matrius_2__11_01_2022 {
    public static void main(String[] args) {
        /*

        * 25 24 23 22 21
        * 20 19 18 17 16
        * 15 14 13 12 11
        * 10  9  8  7  6
        * 5  4  3  2  1

        */

        int[][] matriu=new int[5][5];
        int contador = 25;

        //generar els valors de la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = contador;
                contador--;
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
