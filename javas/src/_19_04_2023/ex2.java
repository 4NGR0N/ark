/*
Ejercicio 02: Downloads
Los objetivos de este ejercicio son:
•	Trabajar con la clase java.io.File
•	Entender métodos que permiten listar contenido de un directorio
•	Entender métodos que permiten comprobar estado, propiedades de un objeto File

Ejercicio 02 Tarea #1
    Para inicializar un objeto File tenemos que indicar una ruta, pero el elemento al que hará referencia el objeto File, sea fichero o directorio, podrá existir o no en el sistema de ficheros. Los métodos exists(), isFile(), isDirectory() nos ayudan a comprobar el estado del objeto File: Consulta la documentación de Java para entender su uso. 

Hint:
    El método exists() retorna un boolean para indicar si el fichero o directorio existe en el sistema de ficheros. Comprueba que es diferente del método isFile() o del método isDirectory(), que permiten indicar si el elemento existente en el sistema de ficheros es un fichero o directorio

El método listFiles() permite consultar el contenido de un directorio. Este método retorna un array de objetos File (File[]) que podremos recorrer con un bucle. 

Desarrolla una aplicación Java que acceda a la carpeta “descargas” (o downloads) del PC y de cada elemento que contenga indique, además de su nombre, si es fichero o es directorio
 */

package _19_04_2023;

import java.io.File;
import java.util.ArrayList;

public class ex2 {
    public static void main(String[] args) {
        File carpeta= new File ("C:/Users/wulfm/Downloads");
        File[] arxius = carpeta.listFiles();
        System.out.println(arxius.toString());
        System.out.println(arxius.length);
        System.out.println(arxius[1].getName());
        System.out.println(carpeta.listFiles());
        System.out.println(carpeta);
    }
}
