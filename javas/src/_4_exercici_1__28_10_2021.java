

import java.util.Scanner;

public class _4_exercici_1__28_10_2021 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero = -1;

        while (numero < 0 || numero >10) {
            System.out.println("Escriu un numero entre 1 y 10");
            numero = entrada.nextInt();
            entrada.nextLine();
        }
        System.out.println("Bravo!");
    }
}
