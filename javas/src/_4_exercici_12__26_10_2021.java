

import java.util.Scanner;

public class _4_exercici_12__26_10_2021 {
    public static void main(String[] args) {
        double quotaFixa=6;
        double quotaVariable;
        double quotaTotal;
        int litres=0;
        Scanner entrada = new Scanner(System.in);


        System.out.println("Dona'm el nombre de litres:");

        //Control d'errors fet dies després.

        do{
            if(entrada.hasNextInt()){      // <-- Aqui el JAVA s'espera a que posi alguna cosa.
                litres=entrada.nextInt();  // Sempre que un metode de scanner apareix, la consola es para (si esta buit).
                entrada.nextLine();
                if(litres>0){
                    break;                 // break i continue surten els dos del bucle complert (while en aquest cas)
                }else{
                    System.out.println("Dada erronea, dona'm un numero positiu");
                }
            }else{
                System.out.println("Dada erronea, dona'm un numero enter");
                entrada.nextLine();
            }
        }while(true);

        //Algoritme real

        if (litres<50) {
            quotaVariable=0;
        }else if (litres<200) {
            quotaVariable=litres*0.15;
        }else {
            quotaVariable=litres*0.3;
        }
        quotaTotal=quotaFixa+quotaVariable;
        System.out.println("Total factura:" + quotaTotal + "€");
    }
}
