/*
La ciutat de Girona està banyada pels rius Ter i Onyar. Quan plouen més de 90 litres
per metre quadrat, el riu Onyar puja de nivell i posa en perill els fonaments dels edificis
de la vora del riu. Quan això passa, s’han d’obrir unes comcomportesFlag per tal de desviar
l’aigua del riu Onyar cap al riu Ter. Crea un algoritme que gestioni les comcomportesFlag.
 */


import java.util.concurrent.TimeUnit;

public class _6_exemple_6__2_11_2021 {
    public static void main(String[] args) throws InterruptedException {
        //throws InterruptedException es per que tenia/podria tenir error, ja que crida el SO.

        // Aquest servei sempre ha d' estar en funcionament
        // per això utilitzem un bucle infinit
        int litresPluja = 0, min = 0, max = 120;
        boolean comportesFlag = false;
        while(true){
            // fem operacio de casting '(int)' davant de Math
            litresPluja = (int)(Math.random()*(max-min+1))+min;
            System.out.print("Ara mateix estan caient: " + litresPluja +" litres/m2");
            if(litresPluja>90 && !comportesFlag){
                System.out.println(" --> Obrir comportes");
                comportesFlag = true;
            } else if(litresPluja<80 && comportesFlag){
                System.out.println(" --> Tanquem comportes");
                comportesFlag = false;
            } else {
                System.out.println();
            }
            TimeUnit.SECONDS.sleep(2); //
        }
    }
}
