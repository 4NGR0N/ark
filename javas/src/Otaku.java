

import java.util.Scanner;

public class Otaku {
    public static void main(String[] args) {
        boolean bonEstat; //bon estat = true / mal estat = false
        double valorFigura;
        Scanner entrada = new Scanner(System.in);
        for (int i=1;i<=5;i++) {

            System.out.println("Escriu el valor de la figura "+i+" (€): ");
            valorFigura = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Escriu si el estat de la figura es bò (s/n):");
            String estat = entrada.nextLine();

            //manera de comparar Strings, no va amb "==".  Va amb equals.
            // A més, ens podem saltar el keySensitive
            // amb el mètode equalsignoreCase

            if(estat.equalsIgnoreCase("s")){
                valorFigura = valorFigura * 1.25;
            }else{
                valorFigura = valorFigura * 1.1;
            }
            System.out.println(valorFigura);
        }
    }
}
