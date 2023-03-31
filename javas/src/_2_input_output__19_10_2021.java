
// la llibreria scanner s'afegeix automaticament al posar un scanner
import java.util.Scanner;

public class _2_input_output__19_10_2021 {
    public static void main(String[] args) {
    String nom = "Marc";
    int edad = 44;
    // print fa una linea sense retorn
    System.out.print("Hola "+nom+ " te "+edad+" anys");
    // println fa retorn de carry al final
    System.out.println("Adeu!");
    System.out.println("Com Estas? (bé o malament)");

    //Amb aquest constructor podem demanar coses per consola
    Scanner input = new Scanner(System.in);
    // la dada introduida es un String
    String resposta = input.nextLine();
    System.out.println("Quants anys tens?");
    // la dada introduida es un Int
    int anys = input.nextInt();
    // es fa per a netejar el buffer ¿?¿?¿?
    input.nextLine();
        System.out.println("Hola "+nom+" estas "+resposta+" i tens "+anys+" anys");
    }
}
