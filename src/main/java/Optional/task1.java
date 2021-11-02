package Optional;

import java.io.*;
import java.util.Arrays;

public class task1 {


    public static void main(String[] args) throws IOException {
        //1
       File file = new File("src/test.txt");
        FileWriter writer = new FileWriter(file);
        int[] array = new int[10];
       for(int i = 0; i < 10; i++) {
           int x = (int) (Math.random()*(200+1))-100;
           //System.out.println(x);
           array[i] = x;
           //writer.write(String.valueOf(x) + " ");
       }

        Arrays.sort(array);

       for(int i = 0; i < 10; i++){
           writer.write(String.valueOf(array[i]) + " ");
       }

        writer.close();

    }
}
