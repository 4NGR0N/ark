

import java.util.Scanner;

public class Utils {
    /**
     * Llegeix un enter per consola a partir d'un màxim i un mínim segons el missatge entrat
     * @param message Missatge mostrat per pantalla
     * @param minValue valor minim a entrar
     * @param maxValue valor maxim a entrar
     * @return retorna l' enter introduït correctament segons els paràmetres anteriors
     */
    public static int llegirEnter(String message, int minValue, int maxValue){
        Scanner input = new Scanner(System.in);
        int nombre = 0;
        System.out.println(message);
        boolean correcte = false;
        while(!correcte) {
            if(input.hasNextInt()) {
                nombre = input.nextInt();
                if(nombre >= minValue && nombre <= maxValue){
                    correcte = true;
                }else{
                    System.out.printf("El nombre ha d'estar entre %d i %d\n",minValue,maxValue);
                }
            }else{
                System.out.println("Introdueix un enter!!");
            }
            input.nextLine();
        }
        input.close();
        return nombre;
    }

    /**
     * Mostra missatge per parametre a l'usuari i retorna la seva resposta
     * @param message missatge a mostrar a l'usuari
     * @return resposta de l'usuari
     */
    public static String llegirString(String message){
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        input.close();
        return input.nextLine();
        
    }

}
