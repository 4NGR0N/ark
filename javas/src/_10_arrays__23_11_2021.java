

public class _10_arrays__23_11_2021 {
    public static void main(String[] args) {

        // String[] planetes = new String[25];
        String[] planetes;
        planetes = new String[]{"Terra","Mart","Venus","Jupiter","Plutó","Tuk Tuk"};

        int[] a = {18,20,30,40,50};
        int[] b = {60,70,80,90,100};
        int[] c = new int[5];

        c[0] = a[0] + b[0];
        c[1] = a[1] + b[1];
        c[2] = a[2] + b[2];
        c[3] = a[3] + b[3];
        c[4] = a[4] + b[4];

        for (int i = 0; i < planetes.length; i++) {
            System.out.println("Planeta " + (i + 1) + ": "+ planetes[i]);
        }
    }
}
