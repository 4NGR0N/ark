

import java.util.Scanner;

public class _15_exercici1_Strings__14_12_2021 {
    public static void main(String[] args) {
        //1. Escriu un programa per calcular la longitud d'una cadena i que ho mostri per pantalla.

        // Variables.
        Scanner entrada = new Scanner(System.in);
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        String frase;
        boolean flag = true;

        // Programa.
        while (flag){
            System.out.println("Escriu una paraula/frase:");
            frase=entrada.nextLine();
            System.out.println("La teva entrada té "+RED+frase.length()+RESET+" lletres");
            System.out.println("Vols continuar?: (s/n)");
            frase=entrada.nextLine();
            if(frase.equals("n")){
                flag = false;
            }
        }
        System.out.println("Fins ara!");

    }
}
