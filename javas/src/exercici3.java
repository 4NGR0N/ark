import java.io.File;
import java.io.IOException;

public class exercici3 {

    public static void main(String[] args) throws IOException{
        try {
            File carpetaDescargas = new File("C:/Users/Predator/Downloads");
            File carpetaFotos = new File("G:/github/ark/javas/src/fotos");
            
            //Creamos carpeta
            if (!carpetaFotos.exists()) {
                carpetaFotos.mkdir();
            }

            //Metemos el nombre de todos los ficheros que hay en Downloads
            File[] archivosEncontrados = carpetaDescargas.listFiles();

            //Movemos los archivos con extension .PNG a la carpeta /fotos
            for (File archivo : archivosEncontrados) {
                String nombre = archivo.getName();
                String extension = ".png";
                if(nombre.contains(extension)){
                    if (archivo.renameTo(carpetaFotos)) {
                        System.out.println("El archivo se movió correctamente");
                    } else {
                        System.out.println("No se pudo mover el archivo");
                    }
                }
            }

            //Borramos todos los archivos de la carpeta fotos
            File[] archivos = carpetaFotos.listFiles();
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    archivo.delete();
                }
            }

            //Borramos la carpeta
            carpetaFotos.delete();

        } catch (Exception e) {
            System.out.println("Problemas de lectura/escritura de archivos");
        }
    }
}
