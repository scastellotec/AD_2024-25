package ejercicios1_4_Buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejemplo4_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfreader = new BufferedReader(new FileReader("streams2.txt"));

        bfreader.lines()
                .mapToInt(x->Integer.parseInt(x))
                .filter(x -> x>100)
                .forEach(x -> System.out.println(x));

        bfreader.close();
    }
}
