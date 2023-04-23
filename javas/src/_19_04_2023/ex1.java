//Ejercicio 01: Paths
//Los objetivos de este ejercicio son:
//•	Trabajar con la clase java.io.File
//•	Entender métodos que permiten obtener información sobre la ruta
//
//
//La clase java.io.File dispone de diversos métodos para obtener información de su ruta. Algunos de los más importantes son getAbsolutePath(), getName(), getParent(). Investiga sobre ellos en la documentación de Java. 

//A continuación puedes ver el código de una aplicación donde se han definido distintos objetos File (fichero/directorio, con ruta absoluta / ruta relativa) que hace uso de estos métodos. Analiza el código y ejecuta la aplicación en tu ordenador para completar la siguiente tabla:


package _19_04_2023;

import java.io.File;

public class ex1 {
    public static void main(String[] args) {
        ex1 programa = new ex1();
        programa.inicio();
    }

    public void inicio() {

        File directoryAbsPath= new File ("c:/Temp");
        File fileAbsPath = new File ("c:/Temp/data.txt");
        File directoryRelativePath = new File("Temp");
        File fileRelativePath = new File("Temp/data.txt");

        showPaths(directoryAbsPath, false);
        showPaths(fileAbsPath, false);
        showPaths(directoryRelativePath, true);
        showPaths(fileRelativePath, true);

    }

    public void showPaths(File f, boolean relativePath) {
        System.out.println("**********************************");
        if (relativePath) System.out.println("La ruta es " + f.getAbsolutePath());
        System.out.println("Su padre es " + f.getParent());
        System.out.println("Su nombre es " + f.getName());
    }

}
