import java.io.File;

public class exercici1 {


        public static void main(String[] args) {
            exercici1 programa = new exercici1();
            programa.inicio();
        }
    
        public void inicio() {
    
            File directoryAbsPath= new File ("c:/Temp");
            File fileAbsPath = new File ("c:/Temp/data.txt");
            File directoryRelativePath = new File("Temp");
            File fileRelativePath = new File("Temp/data.txt");
    
            
            showPaths(directoryRelativePath, true);
            showPaths(fileRelativePath, true);
            showPaths(directoryAbsPath, false);
            showPaths(fileAbsPath, false);
    
        }
    
        public void showPaths(File f, boolean relativePath) {
            System.out.println("**********************************");
            if (relativePath) System.out.println("La ruta es " + f.getAbsolutePath());
            System.out.println("Su padre es " + f.getParent());
            System.out.println("Su nombre es " + f.getName());
            System.out.println("getAbsPath:" + f.getPath());
        }

    
}
