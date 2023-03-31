

public class _11_bubble_sort_array__25_11_2021 {
    public static void main(String[] args) {
        int[] scores = {5,6,8,1,3};
        for (int i=0; i<scores.length-1;i++){
            for (int j=i+1;j<scores.length;j++){
                if (scores[i]>scores[j]){
                    int cambio = scores[i];
                    scores[i] = scores[j];
                    scores[j]=cambio;
                }
            }
        }
        System.out.println("El array ordenado es: ");
        for(int i=0; i<scores.length;i++){
            System.out.print(scores[i]+" ");
        }
        System.out.println();
    }
}
