

/**
 * Classe Principal
 */
public class Alumne {
    String nom;
    String cognom1;
    String cognom2;
    int[] notes = new int[3];

    /**
     * Constructor de la classe Alumne
     * @param nom Nom de l'alumne
     * @param cognom1 1er Cognom de l'alumne
     * @param cognom2 2on Cognom de l'alumne
     * @param nota1 nota mitja del 1er trimestre
     * @param nota2 nota mitja del 2on trimestre
     * @param nota3 nota mitja del 3er trimestre
     */
    public Alumne(String nom, String cognom1, String cognom2, int nota1, int nota2, int nota3) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.notes[0] = nota1;
        this.notes[1] = nota2;
        this.notes[2] = nota3;
    }

    /**
     * Getter del atribut 'nom' d'un alumne
     * @return valor del atribut 'nom'
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter del atribut 'cognom1' d'un alumne
     * @return valor del atribut 'cognom1'
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * Getter del atribut 'cognom2' d'un alumne
     * @return valor del atribut 'cognom2'
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * Getter del atribut 'notes'(Array int[3]) d'un alumne
     * @return valor del atribut 'notes'(Array int[3])
     */
    public int[] getNotes() {
        return notes;
    }

    /**
     * Mètode que canvia la nota d'un determinat trimestre
     * @param indexNota trimestre on es trova la nota a canviar
     * @param novaNota nou valor de nota
     */
    public void cambiarNota (int indexNota,int novaNota){
        this.notes[indexNota] = novaNota;
    }
}
