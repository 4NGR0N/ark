

import java.util.Scanner;

public class _11_exercici_3_arrays__25_11_2021 {
    public static void main(String[] args) {
        // 3. Leer 5 números por teclado y a continuación realizar la media
        //    de los números positivos, la media de los números negativos y
        //    contar el número de ceros.
        int [] numeros = new int[5];
        int mitjanaPositius=0,mitjanaNegatius=0,nombreZeros=0,contadorPositius=0,contadorNegatius=0;

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Dona'm un número");
            numeros[i] = input.nextInt();
            input.nextLine();
            if(numeros[i]>0){
                mitjanaPositius = mitjanaPositius + numeros[i];
                contadorPositius++;
            }else if(numeros[i]<0){
                mitjanaNegatius = mitjanaNegatius + numeros[i];
                contadorNegatius++;
            }else if(numeros[i] == 0){
                nombreZeros++;
            }
        }
        if(contadorPositius == 0){
            System.out.println("No hi ha numeros positius");
        }else{
            System.out.println("La mitja dels nombres positius es: " + mitjanaPositius/contadorPositius);
        }
        if(contadorNegatius == 0){
            System.out.println("No hi ha numeros negatius");
        }else{
            System.out.println("La mitja dels nombres negatius es: " + mitjanaNegatius/contadorNegatius);
        }
        System.out.println("El nombre de zeros es: " + nombreZeros);
    }
}
