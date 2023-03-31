

public class _16_exercici_1_matrius_2__11_01_2022 {
    public static void main(String[] args) {
        /*
        * 1  2  3  4
        * 1  2  3  4
        * 1  2  3  4
        * 1  2  3  4
        * 1  2  3  4
        * */

        int[][] matriu=new int[5][5];

        //generar els valors de la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = j+1;
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
