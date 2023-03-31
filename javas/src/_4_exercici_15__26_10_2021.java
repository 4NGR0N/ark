

import java.util.Scanner;

/*
--------------------------- EXERCICI 15 --------------------------------------------
    INICI
     fes
		 escriure("Seleccioni una opció")
		 escriure("1.Café,2.Tallat,3.Café amb llet,4.Sortir")
	     llegir(opció)
	     mentre(opció <1 OR opció >4)
		 si(opció = 4) {
		     escriure("Adeu!")
		 sino
	         escriure("Introdueix una moneda.") //Treballem amb euros
	         llegir(moneda)
	         si(moneda >= 0,50)aleshores
	             segons(opció){
			         cas 1:
				         escriure("Reculli el seu café")
				     cas 2:
				         escriure("Reculli el seu tallat")
				     cas 3:
				         escriure("Reculli el seu café amb llet")
             fi
		     si(moneda > 0,50)
		         canvi = moneda - 0,50
			     escriure("Reculli el seu canvi")
		     fi
			 sino
			     escriure("ERROR:Moneda insuficient")
			 fi
		 fi
FINAL
*/
public class _4_exercici_15__26_10_2021 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcio = 0;
         do {
            System.out.println("Tria una opció: ");
            System.out.println("1. Cafè");
            System.out.println("2. Tallat");
            System.out.println("3. Cafè amb llet");
            System.out.println("4. Sortir");
            opcio = entrada.nextInt();
            entrada.nextLine();
        } while (opcio<1 || opcio>4);
        if(opcio==4){
            System.out.println("Adéu");
        }else{
            System.out.println("Introdueix una moneda");
            double moneda = entrada.nextDouble();
            entrada.nextLine(); /* Es fa per a netejar la linea */
            if(moneda>=0.50){
                switch(opcio){
                    case 1:
                        System.out.println("Reculli el seu cafè");
                        break;
                    case 2:
                        System.out.println("Reculli el seu tallat");
                        break;
                    case 3:
                        System.out.println("Reculli el seu cafè amb llet");
                        break;
                }
                if(moneda>0.50){
                    double canvi = moneda - 0.50;
                    System.out.println("Reculli el seu canvi:"+canvi);
                }
            }else{
                System.out.println("ERROR: moneda insuficient");
            }
        }
    }
}