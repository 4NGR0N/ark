

import java.util.Scanner;

public class _8_entradaMuseo__9_11_2021 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int edad=0;
        System.out.println("Introdueix la teva edad (numero enter)");

        do{
            if(entrada.hasNextInt()){
                edad = entrada.nextInt();
                entrada.nextLine();
                break;
            }else{
                System.out.println("Dada no valida, escriu un enter (numero)");
                entrada.nextLine();
            }
        }while(true);

        if(edad<=15 || edad>60){
            System.out.println("Amb "+edad+" anys d'edad tens descompte");
        }else{
            System.out.println("Amb "+edad+" anys d'edad NO tens descompte");
        }
    }
}
