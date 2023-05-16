package concesionario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {

    private static String FILENAME="d:/ark/ark/javas/src/concesionario/concesionario.dat";
    private static ArrayList<Car> cotxes = new ArrayList<>();

    public static void main(String[] args) {
	    Concesionario programa = new Concesionario();
	    programa.inicio();
    }

    public void inicio(){
        Scanner input = new Scanner(System.in);
        int opcion=-1;

        carregaInicial();

        do {
            System.out.println("Concesionario SL");
            System.out.println("¿Qué acción quieres realizar?");
            System.out.println("[1]Listar coches");
            System.out.println("[2]Añadir coche");
            System.out.println("[3]Salir");
            opcion = input.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Listando coches...");
                    if (cotxes.isEmpty() || cotxes.size() == 0 || cotxes == null){
                        System.out.println("WARNING: No hi ha dades de cotxes.");
                    }else{
                        for (Car cotxe : cotxes) {
                            System.out.println(cotxe);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Añadiendo coche...");
                    crearCotxe();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    guardarDades();
                    break;
            }
        }while(opcion!=3);
    }

    private void carregaInicial() {
        FileInputStream fitxerCotxes = null;
        ObjectInputStream lecturaFitxer = null;

        try{
            fitxerCotxes = new FileInputStream(FILENAME);
            lecturaFitxer = new ObjectInputStream(fitxerCotxes);

            while(1 == 1){
                Car cotxeAux = (Car)lecturaFitxer.readObject();
                // Afegim el cotxe llegit del fitxer dins de l'ArrayList.
                cotxes.add(cotxeAux);
                System.out.println("Hem llegit el cotxe:");
                System.out.println(cotxeAux);
            }

        }catch(FileNotFoundException fnfe) {
            System.out.println("ERROR: Fitxer no trobat!");
        }catch(EOFException eofe){
            System.out.println("WARNING: Hem arribat al final del fitxer. No passa res.");
        }catch (IOException ioe) {
            System.out.println("ERROR: Problema d'input-output!");
        }catch(Exception e){
            System.out.println("ERROR: Desconegut!" + e);
        }finally{
            if (fitxerCotxes != null){
                try {
                    fitxerCotxes.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (lecturaFitxer != null){
                try {
                    lecturaFitxer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void guardarDades() {
        FileOutputStream fitxerCotxes = null; //new FileOutputStream("fitxerCotxes.dam");
        ObjectOutputStream escripturaObjecteBinari = null;

        try{
            fitxerCotxes = new FileOutputStream(FILENAME);
            escripturaObjecteBinari = new ObjectOutputStream(fitxerCotxes);

            for (Car cotxe : cotxes) {
                escripturaObjecteBinari.writeObject(cotxe);
                System.out.println("S'ha guardat el cotxe: ");
                System.out.println(cotxe);
            }

        }catch(FileNotFoundException fnfe) {
            System.out.println("ERROR: Fitxer no trobat!");
        }catch (IOException ioe) {
            System.out.println("ERROR: Problema d'input-output!");
        }catch(Exception e){
            System.out.println("ERROR: Desconegut!");
        }finally {
            if (escripturaObjecteBinari != null){
                try {
                    escripturaObjecteBinari.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            if (fitxerCotxes != null){
                try {
                    fitxerCotxes.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void crearCotxe() {
        Scanner llegirTeclat = new Scanner(System.in);
        String marca, modelo;
        int asientos;

        System.out.println("Escriu el nom de la marca del cotxe: ");
        marca = llegirTeclat.nextLine();

        System.out.println("Escriu el nom de model: ");
        modelo = llegirTeclat.nextLine();

        System.out.println("Escriu el nombre de seients: ");
        asientos = llegirTeclat.nextInt();
        llegirTeclat.nextLine();
        llegirTeclat.close();
        cotxes.add(new Car(marca, modelo, asientos));
    }


}
