

public class _11_mitjana_aritmetica__25_11_2021 {
    public static void main(String[] args) {
        float[] scores = {7.5f,5.0f,8.5f,6.0f,4.0f};
        float sumClassScore = 0;
        for (int i=0; i<scores.length; i++) {
            sumClassScore = sumClassScore + scores[i];
        }
        System.out.println("Media clase: " +sumClassScore/scores.length);
    }
}
