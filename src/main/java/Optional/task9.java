package Optional;

import java.io.*;

public class task9 {
    public static void main(String[] args) throws IOException {
        String file = "C:/Users/77751/Documents/epam/stage-2/javaI/O/task2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuffer inputBuffer = new StringBuffer();
        String line = bufferedReader.readLine();

        while(line != null){
            inputBuffer.append(line.replaceAll("//"," ").replaceAll("/\\*", " ").replaceAll("\\*/", " "));
            inputBuffer.append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(inputBuffer.toString().getBytes());
        outputStream.close();

    }
}
