

public class _6_exemple_classe__2_11_2021 {
    public static void main(String[] args) {
        for (int i =0;i<10;i++) {
            double number =Math.random()*(100-50)-50; // (Math.random()*(max-min))+min formula final
            int min = 10;
            int max = 20;
            number = (int)(Math.random()*(max-min+1))+min;
            System.out.println(number);
        }
    }
}
