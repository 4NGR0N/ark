package practica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class salvadorMarc_Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) throws FileNotFoundException {
        
        //Es convenientment necessari un block try/catch per capturar el FileNotFoundExcepcion en cas d'error
        try {
            
            //Creem les variables necessaries:
            //llista personatges es un arraylist de objectes tipus salvadorMarc_Character
            ArrayList<salvadorMarc_Character> llista_personatges = new ArrayList<salvadorMarc_Character>();
            
            //creem les variables f i arxiu per posar al buffer la ubicació e inicialitzar l'objecte 'File'
            File arxiu = new File("characters_wh_semicolon.csv");
            
            //creem el punter de lectura
            Scanner input = new Scanner(arxiu);

            //Com que la primera linia del arxiu és una capçalera, adelantem el punter una linia.
            input.nextLine();

            //Llegim el contingut del arxiu, passem cadascuna de les linies a un objecte de tipus "salvadorMarc_Character" i
            //l'afegim a l'arraylist
            while(input.hasNextLine()){
                String linia = input.nextLine();
                String[] valors = linia.split(";");
                salvadorMarc_Character cromo = new salvadorMarc_Character(valors[0],valors[1], valors[2], valors[3], valors[4], valors[5], valors[6], valors[7], valors[8], valors[9]);
                llista_personatges.add(cromo);          
            }

            //Treiem el contingut del arraylist per pantalla:
            for (int i = 0; i < llista_personatges.size(); i++) {
                salvadorMarc_Character personaje = llista_personatges.get(i);
                personaje.enPantalla();
            }
            input.close();
        } 

        //En cas d'error de lectura al no trobar l'arxiu, o tenint un error de lectura, avisem al usuari:
        catch (FileNotFoundException e) {
            System.out.println(ANSI_RED+"No es pot accedir a l'arxiu. Comprova si existeix i si hi tens permisos."+ANSI_RESET);

        }
    }   
    
}
