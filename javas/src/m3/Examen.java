package m3;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import m3.models.transaccio;

public class Examen {
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int opcion=-1;
        ArrayList<transaccio> ingresos =new ArrayList<>();
        ingresos=iniciatlitzaArray("transact.data");
            do {
                System.out.println("Transacciones BitCuco");
                System.out.println("¿Qué acción quieres realizar?");
                System.out.println("[1]Listar transacciones");
                System.out.println("[2]Añadir transaccion");
                System.out.println("[3]Salir");
                opcion = input.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ver Transacciones");
                        System.out.print("Dime el nombre del fichero de transacciones:");
                        String fichero=input.next();
                        ArrayList<transaccio> tempo=iniciatlitzaArray(fichero);
                        System.out.println("Listando transacciones");
                        if (tempo.isEmpty() || tempo.size() == 0 || tempo == null){
                            System.out.println("WARNING: No hi ha dades de transaccions.");
                        }else{
                            for (transaccio ing : tempo) {
                                System.out.println(ing.toString());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Añadir Transaccion:");
                        System.out.println("Dime el fichero donde almacenar transacciones: ");
                        String arxiu=input.next();
                        ingresos=crearTransaccio(ingresos,arxiu);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        guardarDades(ingresos,"transact.data");
                        break;
                }
            }while(opcion!=3);
        
        }
        

    public static ArrayList<transaccio> iniciatlitzaArray(String FILENAME) {
        FileInputStream fitxerIngresos = null;
        ObjectInputStream lecturaFitxer = null;
        ArrayList<transaccio> tempo = new ArrayList<>();

        try{
            fitxerIngresos = new FileInputStream(FILENAME);
            lecturaFitxer = new ObjectInputStream(fitxerIngresos);

            while(true){
                transaccio ingresAux = (transaccio)lecturaFitxer.readObject();
                // Afegim el cotxe llegit del fitxer dins de l'ArrayList.
                tempo.add(ingresAux);
                System.out.println("Hem llegit la transaccio:");
                System.out.println(ingresAux.toString());
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
            if (fitxerIngresos != null){
                try {
                    lecturaFitxer.close();
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
        return tempo;
    }

    public static ArrayList<transaccio> crearTransaccio(ArrayList<transaccio> ingresos, String FILENAME) {
        Scanner llegirTeclat = new Scanner(System.in);
        String tipus, importe;
        LocalDate data;

        System.out.println("Escriu el tipus de moneda: ");
        tipus = llegirTeclat.nextLine();

        System.out.println("Escriu el import de la transaccio: ");
        importe = llegirTeclat.nextLine();

        data = LocalDate.now();
        ingresos.add(new transaccio(tipus, importe, data));
        guardarDades(ingresos,FILENAME);
        System.out.println("La transferencia s'ha guardat correctament");
        return ingresos;
    }

    public static void guardarDades(ArrayList<transaccio> ingresos, String FILENAME) {
        FileOutputStream fitxerCotxes = null;
        ObjectOutputStream escripturaObjecteBinari = null;

        try{
            fitxerCotxes = new FileOutputStream(FILENAME);
            escripturaObjecteBinari = new ObjectOutputStream(fitxerCotxes);

            for (transaccio trans : ingresos) {
                escripturaObjecteBinari.writeObject(trans);
                System.out.println("S'ha guardat la transacció: ");
                System.out.println(trans.toString());
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
}
