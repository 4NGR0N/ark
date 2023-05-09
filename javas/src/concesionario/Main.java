import java.util.Scanner;

import concesionario.Car;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

    private static String FILENAME="d:/ark/ark/javas/src/concesionario/concesionario.dat";

    public static void main(String[] args) throws ClassNotFoundException, IOException {
	    Main programa = new Main();
	    programa.inicio();
    }

    public void inicio() throws ClassNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        int opcion=-1;
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
                    ReadObjectFromFile();
                    break;
                case 2:
                    System.out.println("Añadiendo coche...");
                    System.out.println("Dime Marca:");
                    String marca=input.next();
                    System.out.println("Dime Modelo:");
                    String modelo=input.next();
                    System.out.println("Nº Asientos:");
                    int asientos=input.nextInt();
                    Car coche = new Car(marca,modelo,asientos);
                    WriteObjectToFile(coche);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        }while(opcion!=3);
        input.close();
    }
    public void ReadObjectFromFile() throws IOException, ClassNotFoundException{
        try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream input= new ObjectInputStream(fileIn);
            while (true) {
                Car coche = input.readObject();
               System.out.println( coche.toString());
            }
           
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }catch (ClassNotFoundException e){
            System.out.println("Coche no encontrado.");
        }
        
    }

    public void WriteObjectToFile(Object serObj) {
 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            System.out.println("The Object  was succesfully written to a file");
            fileOut.close();
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
