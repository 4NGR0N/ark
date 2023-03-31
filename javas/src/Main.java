

import jdk.jshell.execution.Util;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean sortir = false;
        ArrayList<Alumne> alumnes = new ArrayList<>();

        alumnes.add(new Alumne("Pep", "Gomez", "Sanchez", 5, 6, 7));
        alumnes.add(new Alumne("Marge", "Simpson", "Simpson", 5, 6, 5));
        alumnes.add(new Alumne("Antonio", "Martin", "Perez", 6, 7, 8));
        alumnes.add(new Alumne("Montgomery", "Burns", "Burns", 6, 6, 6));
        alumnes.add(new Alumne("Maria", "Iturgari", "Hugo", 10, 9, 10));
        alumnes.add(new Alumne("Julian", "Manzano", "Yañez", 7, 8, 9));
        alumnes.add(new Alumne("Olatz", "Errenteria", "Atzatademendi", 6, 7, 8));
        alumnes.add(new Alumne("Alejandro", "Carrasco", "Sanchez", 7, 10, 9));
        alumnes.add(new Alumne("Marc", "Salvador", "Torné", 7, 7, 7));
        alumnes.add(new Alumne("Marta", "Ielatz", "Fernandez", 5, 9, 6));

        while (!sortir) {
            String menu = ANSI_BLUE+"\nBenvingut a la BBDD de alumnes."+ANSI_RESET+ANSI_CYAN+"\nQuina operació vol realitzar\n"+ANSI_GREEN+"1"+ANSI_RESET+" - Mostrar Alumnes\n"+ANSI_GREEN+"2"+ANSI_RESET+" - Buscar Alumne\n"+ANSI_GREEN+"3"+ANSI_RESET+" - Inserir Alumne\n"+ANSI_GREEN+"4"+ANSI_RESET+" - Eliminar Alumne\n"+ANSI_GREEN+"5"+ANSI_RESET+" - Veure mitja nota\n"+ANSI_GREEN+"6"+ANSI_RESET+" - Canviar Notes\n"+ANSI_GREEN+"7"+ANSI_RESET+" - Sortir";
            System.out.println(menu);
            int opcio = Utils.llegirEnter(ANSI_GREEN+"Dona' m una opció"+ANSI_RESET, 1, 7);

            switch (opcio) {
                case 1:
                    mostrarAlumnes(alumnes);
                    break;
                case 2:
                    String menu2= """
                            Com vols buscar a l'alumne:
                            1. Buscar per nom
                            2. Buscar pel primer cognom
                            3. Buscar pel segon cognom
                            """;
                    System.out.println(menu2);
                    int opcio2 = Utils.llegirEnter("Dona'm una opcio",1,3);

                    switch (opcio2){
                        case 1:
                            buscaPerNom(alumnes);
                            break;
                        case 2:
                            buscaPerCognom(alumnes);
                            break;
                        case 3:
                            buscaPerCognom2(alumnes);
                            break;
                        default:
                            break;
                    }
                    System.out.println();
                    break;
                case 3:
                    inserirAlumne(alumnes);
                    break;
                case 4:
                    Alumne ii = buscarAlumne(alumnes);
                    if( comprovaAlumne(ii) ) {
                        eliminarAlumne(alumnes,ii);
                    } else {
                        System.out.println("Alumne no trobat.");
                    }
                    break;
                case 5:
                    Alumne iii = buscarAlumne(alumnes);
                    if( comprovaAlumne(iii) ) {
                        System.out.println("La nota mitja del alumne es: " + veureMitja(iii));
                    } else {
                        System.out.println("Alumne no trobat.");
                    }
                    break;
                case 6:
                    int trimestre = Utils.llegirEnter("Dona'm la nota que vols canviar: ([1] per 1er trimestre, [2] per 2n trimestre, [3] per 3er trimestre]",1,3);
                    int novaNota = Utils.llegirEnter("Dona'm la nova nota a canviar [1 a 10]",1,10);
                    Alumne iv = buscarAlumne(alumnes);
                    if(comprovaAlumne(iv)){
                        iv.cambiarNota(trimestre-1,novaNota);
                        System.out.println("Nota canviada correctament.");
                    } else {
                        System.out.println("Alumne no trobat.");
                    }
                    break;
                case 7:
                    System.out.println(ANSI_PURPLE+"Fins ara!"+ANSI_RESET);
                    sortir = true;
                    break;
            }
        }
    }

    /**
     * Funció que busca alumnes pel seu atribut 'nom' i els mostra per pantalla
     * @param alumnes Arraylist amb l'alumne a cercar
     * @return alumne/s cercat/s
     */
    public static void buscaPerNom(ArrayList<Alumne> alumnes){
        Scanner input = new Scanner(System.in);
        int acc=0;
        String cadenaCercar = Utils.llegirString("Escriu el primer NOM a cercar:");
        header();
        System.out.println();
        for (Alumne alumne: alumnes) {
            if (alumne.getNom().toLowerCase().contains(cadenaCercar.toLowerCase())) {
                System.out.printf("%1$15s%2$15s%3$15s%4$15s%5$15s%6$15s",alumne.getNom(),alumne.getCognom1(),alumne.getCognom2(),alumne.getNotes()[0],alumne.getNotes()[1],alumne.getNotes()[2]);
                System.out.println();
                acc++;
            }
        }
        if(acc==0){
            System.out.println("Alumne no trobat");
        }
    }

    /**
     * Funció que busca alumnes pel seu atribut 'cognom' i els mostra per pantalla
     * @param alumnes Arraylist amb l'alumne a cercar
     * @return alumne/s cercat/s
     */
    public static void buscaPerCognom(ArrayList<Alumne> alumnes){
        Scanner input = new Scanner(System.in);
        int acc=0;
        String cadenaCercar = Utils.llegirString("Escriu el primer COGNOM a cercar:");
        header();
        System.out.println();
        for (Alumne alumne: alumnes) {
            if (alumne.getCognom1().toLowerCase().contains(cadenaCercar.toLowerCase())) {
                System.out.printf("%1$15s%2$15s%3$15s%4$15s%5$15s%6$15s",alumne.getNom(),alumne.getCognom1(),alumne.getCognom2(),alumne.getNotes()[0],alumne.getNotes()[1],alumne.getNotes()[2]);
                System.out.println();
                acc++;
            }
        }
        if(acc==0){
            System.out.println("Alumne no trobat");
        }
    }

    /**
     * Funció que busca alumnes pel seu atribut 'cognom2' i els mostra per pantalla
     * @param alumnes Arraylist amb l'alumne a cercar
     * @return alumne/s cercat/s
     */
    public static void buscaPerCognom2(ArrayList<Alumne> alumnes){
        Scanner input = new Scanner(System.in);
        int acc=0;
        String cadenaCercar = Utils.llegirString("Escriu el segon COGNOM a cercar:");
        header();
        System.out.println();
        for (Alumne alumne: alumnes) {
            if (alumne.getCognom2().toLowerCase().contains(cadenaCercar.toLowerCase())) {
                System.out.printf("%1$15s%2$15s%3$15s%4$15s%5$15s%6$15s",alumne.getNom(),alumne.getCognom1(),alumne.getCognom2(),alumne.getNotes()[0],alumne.getNotes()[1],alumne.getNotes()[2]);
                System.out.println();
                acc++;
            }
        }
        if(acc==0){
            System.out.println("Alumne no trobat");
        }
    }

    /**
     * Funció que insereix un alumne a un arraylist passant per construir-lo
     * @param alumnes Arraylist on inserim l'alumne
     */
    public static void inserirAlumne(ArrayList<Alumne> alumnes) {
        String nom = Utils.llegirString("Dona'm el nom de l'alumne: ");
        String cognom1 = Utils.llegirString("Dona'm el 1er cognom de l'alumne: ");
        String cognom2 = Utils.llegirString("Dona'm el 2n cognom del l'alumne");
        int nota1 = Utils.llegirEnter("Dona'm la primera nota",0,10);
        int nota2 = Utils.llegirEnter("Dona'm la segona nota",0,10);
        int nota3 = Utils.llegirEnter("Dona'm la tercera nota",0,10);
        alumnes.add(new Alumne(nom,cognom1,cognom2, nota1,nota2,nota3));
    }

    /**
     * Funció que elimina un alumne especific d'un arraylist
     * @param alumne Arraylist on inserim l'alumne
     * @param alumneAEliminar alumne a eliminar
     */
    private static void eliminarAlumne(ArrayList<Alumne> alumne, Alumne alumneAEliminar) {
        alumne.remove(alumneAEliminar);
        System.out.println("Alumno Eliminado Correctamente");
    }

    /**
     * Funció que busca un alumne per NOM I COGNOM
     * @param alumnes Arraylist on inserim l'alumne
     * @return l'alumne trobat
     */
    public static Alumne buscarAlumne(ArrayList<Alumne> alumnes){
        String nom = Utils.llegirString("Dona'm el nom");
        String cognom = Utils.llegirString("Dona'm el primer cognom");
        for (Alumne i: alumnes ) {
            if(i.getNom().toLowerCase().contains(nom.toLowerCase())){
                if(i.getCognom1().toLowerCase().contains(cognom.toLowerCase())){
                    System.out.println();
                    return i;
                }
            }
        }
        return null;
    }

    /**
     * Funció que comprova si un objecte de tipus Alumne val <null>
     * @param alumne Alumne a comprovar
     * @return false si val <null>
     */
    public static boolean comprovaAlumne(Alumne alumne){
        if(alumne !=null ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Mostra tots els valors dels atributs d'un alumne concret
     * @param alumne Alumne a mostrar
     */
    public static void mostrarAlumne(Alumne alumne){
        header();
        System.out.println();
        System.out.printf("%1$15s%2$15s%3$15s%4$15s%5$15s%6$15s",alumne.getNom(),alumne.getCognom1(),alumne.getCognom2(),alumne.getNotes()[0],alumne.getNotes()[1],alumne.getNotes()[2]);
        System.out.println();
    }

    /**
     * Calcula la mitja aritmètica de les notes dels 3 trimestres
     * @param alumne alumne a valorar
     * @return mitja aritmètica
     */
    public static float veureMitja(Alumne alumne){
        return ((alumne.getNotes()[0]+alumne.getNotes()[1]+alumne.getNotes()[2])/3);
    }

    /**
     * Mostra una capçalera pels diferents atributs del objecte Alumne
     */
    private static void header() {

        String[] header = {"NOM", "COGNOM1", "COGNOM2", "NOTA1", "NOTA2", "NOTA3"};
        System.out.println(ANSI_RED);
        for (int i = 0; i < header.length; i++) {
            System.out.print(String.format("%1$15s", header[i]));
        }
        System.out.print(ANSI_RESET);

    }

    /**
     * Mostra tots els alumnes de un arraylist
     * @param alumne Arraylist amb l'alumne a cercar
     */
    public static void mostrarAlumnes(ArrayList<Alumne> alumne) {
        header();
        System.out.println();
        for (Alumne Alumne: alumne) {
            System.out.println(String.format("%1$15s%2$15s%3$15s%4$15s%5$15s%6$15s", Alumne.getNom(),Alumne.getCognom1(),Alumne.getCognom2(),Alumne.getNotes()[0],Alumne.getNotes()[1],Alumne.getNotes()[2]));
        }
    }
}