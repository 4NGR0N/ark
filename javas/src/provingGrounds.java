

import java.util.ArrayList;

public class provingGrounds {
    public static void main(String[] args) {

        ArrayList<Alumne> alumnes = new ArrayList<>();

        alumnes.add(new Alumne("Pep", "Gomez", "Sanchez", 5, 6, 7));
        alumnes.add(new Alumne("Antonio", "Martin", "Perez", 6, 7, 8));
        alumnes.add(new Alumne("Julian", "Manzano", "Yañez", 7, 8, 9));
        alumnes.add(new Alumne("Josema", "Iturgari", "Hugo", 8, 9, 10));


        alumnes.get(0).cambiarNota(2,9);
        System.out.println(alumnes.get(0).getNotes()[2]);
        System.out.println(veureMitja(buscarAlumne(alumnes,"Pep","Gomez")));
        mostrarAlumnes(alumnes);

    }
    public static void inserirAlumne(ArrayList<Alumne> alumnes) {
        String nom = Utils.llegirString("Dona'm el nom de l'alumne: ");
        String cognom1 = Utils.llegirString("Dona'm el 1er cognom de l'alumne: ");
        String cognom2 = Utils.llegirString("Dona'm el 2n cognom del l'alumne");
        int nota1 = Utils.llegirEnter("Dona'm la primera nota",0,10);
        int nota2 = Utils.llegirEnter("Dona'm la segona nota",0,10);
        int nota3 = Utils.llegirEnter("Dona'm la tercera nota",0,10);
        alumnes.add(new Alumne(nom,cognom1,cognom2, nota1,nota2,nota3));
    }

    private static void eliminarAlumne(ArrayList<Alumne> alumne, Alumne alumneAEliminar) {
        alumne.remove(alumneAEliminar);
        System.out.println("Alumno Eliminado Correctamente");
    }

    public static Alumne buscarAlumne(ArrayList<Alumne> alumnes, String nom, String cognom){
        for (Alumne i: alumnes ) {
            if(i.getNom().toLowerCase().contains(nom.toLowerCase())){
                if(i.getCognom1().toLowerCase().contains(cognom.toLowerCase())){
                    return i;
                }
            }
        }
        return null;
    }

    public static void mostrarAlumne(Alumne alumne){
        System.out.print("Nom: " + alumne.getNom());
        System.out.print(" Cognom 1: " + alumne.getCognom1());
        System.out.print(" Cognom 2: " + alumne.getCognom2());
        System.out.print(" Nota 1: " + alumne.getNotes()[0]);
        System.out.print(" Nota 2: " + alumne.getNotes()[1]);
        System.out.print(" Nota 3: " + alumne.getNotes()[2]);
    }

    public static float veureMitja(Alumne alumne){
        return ((alumne.getNotes()[0]+alumne.getNotes()[1]+alumne.getNotes()[2])/3);
    }
    private static void header(){
        String[] header = {"NOM", "COGNOM1", "COGNOM2", "NOTA1", "NOTA2", "NOTA3"};
        for (int i = 0; i < header.length; i++) {
            System.out.print(String.format("%1$15s", header[i]));
        }
    }
    public static void mostrarAlumnes(ArrayList<Alumne> alumne) {
        header();
        System.out.println();
        for (Alumne Alumne: alumne) {
            System.out.println(String.format("%1$15s%2$15s%3$15s%4$15s%5$15s%6$15s", Alumne.getNom(),Alumne.getCognom1(),Alumne.getCognom2(),Alumne.getNotes()[0],Alumne.getNotes()[1],Alumne.getNotes()[2]));
        }
    }
}
