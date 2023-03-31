

public class MitjaDeTransport {
    private String nom;
    private String tipus;
    private int capacitat;
    private int velocitat;

    public MitjaDeTransport(String nom, String tipus, int capacitat, int velocitat) {
        this.nom = nom;
        this.tipus = tipus;
        this.capacitat = capacitat;
        this.velocitat = velocitat;
    }

    /**
     * Retorna la velocitat del mitjà de transport en ciutat,
     * 50 com a màxim en tots els transports o la velocitat màxima del transport
     * si no es superior a 50 hm/h
     * @return valocitat en ciutat
     */
    public int getVelocitatEnCiutat(){
        if(this.velocitat > 50)
            return 50;
        else
            return this.velocitat;
    }

    @Override
    public String toString() {
        return "MitjaDeTransport{" +
                "nom='" + nom + '\'' +
                ", tipus='" + tipus + '\'' +
                ", capacitat=" + capacitat +
                ", velocitat=" + velocitat +
                ", velocitat  en ciutat =" + this.getVelocitatEnCiutat() +
                '}';
    }
}
