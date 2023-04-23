package practica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class salvadorMarc_Main {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<salvadorMarc_Character> llista_personatges = new ArrayList<salvadorMarc_Character>();

        File f = new File("G:/github/ark/javas/src/practica");
        File arxiu = new File(f,"characters_wh_semicolon.csv");
        Scanner input = new Scanner(arxiu);
        input.nextLine();
        while(input.hasNextLine()){
            String linia = input.nextLine();
            String[] valors = linia.split(";");
            salvadorMarc_Character cromo = new salvadorMarc_Character(valors[0],valors[1], valors[2], valors[3], valors[4], valors[5], valors[6], valors[7], valors[8], valors[9]);
            llista_personatges.add(cromo);
            System.out.println("Name:"+valors[0]+" Height:"+valors[1]+" Mass:"+valors[2]+" Hair Color:"+valors[3]+" Skin Color:"+valors[4]+" Eye Color:"+valors[5]+" Birth Year:"+valors[6]+" Gender:"+valors[7]+" Homewrold:"+valors[8]+" Species:"+valors[9]);
        }
        input.close();
    }    
}
