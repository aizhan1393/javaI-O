package Optional;

import java.io.*;
import java.util.Arrays;

public class Task1 {


    public static void main(String[] args) throws IOException {
        File file = new File("src/test.txt");
        FileWriter writer = new FileWriter(file);
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * (200 + 1)) - 100;
            array[i] = x;
        }

        Arrays.sort(array);

        for (int i = 0; i < 10; i++) {
            writer.write(String.valueOf(array[i]) + " ");
        }

        writer.close();

    }
}
