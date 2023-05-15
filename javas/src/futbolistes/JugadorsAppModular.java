package futbolistes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorsAppModular {
    static Scanner llegir = new Scanner(System.in);
    static String[] header = {"NOM", "CLUB", "DORSAL", "GOLS"};

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IOException {
        try {
            ArrayList<Jugador> jugadors = new ArrayList<>();
            jugadors.add(new Jugador("Leo Messi", "FCB", 10, 30));
            jugadors.add(new Jugador("Benzema", "RMFC", 9, 29));
            jugadors.add(new Jugador("Luis Suarez", "AT Madrid", 9, 25));
            jugadors.add(new Jugador("Neymar", "PSG", 11, 35)); 
            
            WriteObjectToFile(jugadors,"jugadors.dat");
            ArrayList<Jugador> llistat = ReadObjectFromFile("jugadors.dat"); 
            System.out.println(llistat); 
            //menuPrincipal(jugadors);
        } catch (IOException e) {
            System.out.println("Error de entrada/sortida");
        } catch (ClassFormatError e){
            System.out.println("Classe no trobada");
        }
        
    }

    private static void menuPrincipal(ArrayList<Jugador> jugadors) throws InterruptedException {
        int opcio = 0;
        String menu = "Benvingut a la BBDD de jugadors amb menu recursiu.\nQuina operació vol realitzar\n" +
                "1 - Alta jugador\n" + "2 - Mostrar Jugadors\n" +
                "3 - Buscar jugadors\n" + "4 - Esdistiques\n" + "5 - Sortir\n";
        opcio = llegirInt(menu, 1, 5);
        switch (opcio) {
            case 1://alta jugador
                altaJugador(jugadors);
                menuPrincipal(jugadors);
                break;
            case 2: //mostrar jugadors
                mostrarJugadors(jugadors);
                menuPrincipal(jugadors);
                break;
            case 3: //Buscar jugador
                subMenuCercaJugadors(jugadors);
                menuPrincipal(jugadors);
                break;
            case 4: //Estadistiques
                mostrarEstadistiques(jugadors);
                menuPrincipal(jugadors);
                break;
            case 5: //sortir
                Thread.sleep(1000);
                System.out.println("bye bye");
                break;
            default:
                break;
        }
    }

    public static ArrayList<Jugador> ReadObjectFromFile(String FILENAME) throws IOException, ClassNotFoundException{
        ArrayList<Jugador> llista = new ArrayList<>();
        try {
            FileInputStream fileStream = new FileInputStream(FILENAME);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            ArrayList<Jugador> readObject = (ArrayList<Jugador>) objectStream.readObject();
            llista = readObject;
            
            System.out.println(llista);

            objectStream.close();
            fileStream.close();
            return llista;
            
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }catch (ClassNotFoundException e){
            System.out.println("Jugador no trobat.");
        }
        return llista;
    }


    public static void WriteObjectToFile(ArrayList<Jugador> llista, String FILENAME) {
        try {
            FileOutputStream fileStream = new FileOutputStream(FILENAME);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(llista);
            objectStream.close();
            fileStream.close();
            System.out.println("Done by copying...");
        } catch (IOException e) {
            System.out.println("Error de entrada/sortida: " + e.getMessage());
        }
    }

    private static void mostrarEstadistiques(ArrayList<Jugador> jugadors) {
        //jugador amb més gols, jugador amb menys gols i mitjana de gols
        String jugadorAmbMesGols = "";
        int golsJugadorAmbMesGols = 0;
        String jugadorAmbMenysGols = "";
        int golsJugadorAmbMenysGols = 10000;
        int mitjanaGols = 0;
        int totalGols = 0;
        int totalJugadors = 0;
        for(Jugador jugadorActual: jugadors){
            int golsdJugadorActual = jugadorActual.getGols();
            if (golsdJugadorActual > golsJugadorAmbMesGols) {
                jugadorAmbMesGols = jugadorActual.getNom();
                golsJugadorAmbMesGols = golsdJugadorActual;
            }
            if (golsdJugadorActual < golsJugadorAmbMenysGols) {
                jugadorAmbMenysGols = jugadorActual.getNom();
                golsJugadorAmbMenysGols = golsdJugadorActual;
            }
            totalGols += golsdJugadorActual;
            totalJugadors++;

        }
        mitjanaGols = totalGols / totalJugadors;
        System.out.println(String.format("El jugador amb mes gols es %s, ha fet %d gols", jugadorAmbMesGols, golsJugadorAmbMesGols));
        System.out.println(String.format("El jugador amb menys gols es %s, ha fet %d gols", jugadorAmbMenysGols, golsJugadorAmbMenysGols));
        System.out.println("Mitjana de gols:" + mitjanaGols);
    }

    private static void subMenuCercaJugadors(ArrayList<Jugador> jugadors) {
        int opcioSubmenu = 0;

            String menu = "Escull com cercar:\n" +
                    "1-Cercar per NOM\n" +
                    "2-Cercar per CLUB\n" + "3-Cercar per DORSAL\n" + "4-tornar enrere\n";
            opcioSubmenu = llegirInt(menu, 1, 4);
            switch (opcioSubmenu) {
                case 1:
                    cercaPerNom(jugadors);
                    subMenuCercaJugadors(jugadors);
                    break;
                case 2:
                    cercaPerclub(jugadors);
                    subMenuCercaJugadors(jugadors);
                    break;
                case 3:
                    cercaPerDorsal(jugadors);
                    subMenuCercaJugadors(jugadors);
                    break;
                case 4: //sortir
                    break;
            }
    }

    private static void cercaPerDorsal(ArrayList<Jugador> jugadors) {
        int dorsal = llegirInt("Escriu el CLUB a cercar:", 0, 99);
        for (int i = 0; i < header.length; i++) {
            System.out.print(String.format("%1$15s", header[i]));
        }
        System.out.println();
        for (Jugador jugador : jugadors) {
            if (jugador.getDorsal() == dorsal)
                System.out.println(jugador);
        }
    }

    private static void cercaPerclub(ArrayList<Jugador> jugadors) {
        System.out.println("Escriu el CLUB a cercar:");
        String cadenaCercar = llegir.nextLine();
        for (int i = 0; i < header.length; i++) {
            System.out.print(String.format("%1$15s", header[i]));
        }
        System.out.println();
        for (Jugador jugador : jugadors) {
            if (jugador.getClub().toLowerCase().contains(cadenaCercar.toLowerCase()))
                System.out.println(jugador);
        }
    }

    private static void cercaPerNom(ArrayList<Jugador> jugadors) {
        System.out.println("Escriu el NOM a cercar:");
        String cadenaCercar = llegir.nextLine();
        for (int i = 0; i < header.length; i++) {
            System.out.print(String.format("%1$15s", header[i]));
        }
        System.out.println();
        for (Jugador jugador : jugadors) {
            if (jugador.getNom().toLowerCase().contains(cadenaCercar.toLowerCase()))
                System.out.println(jugador);
        }
    }


    /**
     * Mostra tots els jugadors per consola
     *
     * @param jugadors ArrayList de jugadors a mostrarors
     */
    private static void mostrarJugadors(ArrayList<Jugador> jugadors) {
        for (int i = 0; i < header.length; i++) {
            System.out.print(String.format("%1$15s", header[i]));
        }
        System.out.println();
        for (Jugador jugador : jugadors) {
            System.out.println(jugador);
        }
    }

    /**
     * Es dona d'alta un jugador demanant dades a l'usuari
     *
     * @param jugadors
     */
    private static void altaJugador(ArrayList<Jugador> jugadors) {
        System.out.println("-----Alta jugador------");
        System.out.println("Nom del jugador:");
        String nom = llegir.nextLine();
        System.out.println("Nom del club:");
        String club = llegir.nextLine();
        int dorsal = llegirInt("Dorsal:", 1, 99);
        int gols = llegirInt("Gols:", 0, 999);
        //comprovació de jugador repetit
        Jugador nouJugador = new Jugador(nom, club, dorsal, gols);
        if(jugadors.contains(nouJugador)){
            System.out.println("Jugador Existent!!!");
        }
        else{
            jugadors.add(nouJugador);
        }
    }

    /**
     * Demana un valor enter al usuari mostrant el missatge per consola. el valor no es considerarà correcte si no està entre el minValue i MAxValue
     *
     * @param missatge missatge a mostrar per consola
     * @param minValue valor minim acceptat
     * @param maxValue valor máxim acceptat
     * @return valor enter proporcionat per l'usuari
     */
    public static int llegirInt(String missatge, int minValue, int maxValue) {
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String RESET = "\u001B[0m";
        int valorLlegit = 0;
        boolean valorCorrecte = false;
        System.out.print(missatge);
        valorCorrecte = llegir.hasNextInt();

        if (!valorCorrecte) {
            llegir.nextLine();
            System.out.println(RED + "Valor no correcte." + RESET);
            llegirInt(missatge, minValue , maxValue);
        } else {
            valorLlegit = llegir.nextInt();
            llegir.nextLine();
            if (valorLlegit < minValue || valorLlegit > maxValue) {
                System.out.println(String.format("El valor ha d'estar entre %d i %d", minValue, maxValue));
                valorCorrecte = false;
            }
        }

        return valorLlegit;
    }
}
