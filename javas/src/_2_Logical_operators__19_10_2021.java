

public class _2_Logical_operators__19_10_2021 {

    /* Un museo ofrece descuento para jóvenes de hasta 15 años y para personas
mayores de 60 años. Añade el código necesario para asignar a la variable
descuentoMuseo el valor adecuado según la edad de una persona. */

    public static void main(String[] args) {
        int edad = 15;
        boolean descuentoMuseo;
        if (edad<=15 || edad>60){
            descuentoMuseo=true;
            System.out.println("Tens descompte");
        }else{
            System.out.println("No tens cap descompte");
            descuentoMuseo=false;
        }
        System.out.println("Descuento: "+descuentoMuseo);

        // ES POT FER AIXI SENSE IF:
        // boolean descuentoMuseo = edad<=15 || edad>60;


    }
}
