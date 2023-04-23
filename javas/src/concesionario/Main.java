package concesionario;

import java.util.Scanner;

public class Main {

    private static String FILENAME="d:/ark/ark/javas/src/concesionario/concesionario.dat";

    public static void main(String[] args) {
	    Main programa = new Main();
	    programa.inicio();
    }

    public void inicio(){
        Scanner input = new Scanner(System.in);
        int opcion=-1;
        do {
            System.out.println("Concesionario SL");
            System.out.println("¿Qué acción qiueres realizar?");
            System.out.println("[1]Listar coches");
            System.out.println("[2]Añadir coche");
            System.out.println("[3]Salir");
            opcion = input.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Listando coches...");
                    /*insert code here*/
                    break;
                case 2:
                    System.out.println("Añadiendo coche...");
                    /*insert code here*/
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        }while(opcion!=3);
    }


}
