package Optional;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        try (String file = "src/task2.txt";
             File outputFile = new File("src/task3.txt");
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                char[] array = line.toCharArray();
                for (int i = array.length - 1; i >= 0; i--) {
                    bufferedWriter.write(array[i]);
                }
                bufferedWriter.write("\n");
                line = bufferedReader.readLine();
            }
        }
    }
}
