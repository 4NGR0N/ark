import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;

public class _2023_writingTextFiles {
    public static void main(String[] args) throws FileNotFoundException {
        File file= new File("numbers.txt");
        PrintStream output;
        output = new PrintStream(file);
        for (int i=0;i<5;i++){
            output.print(i+" ");
        }
        output.close();
    }
}