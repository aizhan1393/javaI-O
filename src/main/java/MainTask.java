import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;


public class MainTask {
    public static void printDirectoryTree(File folder) throws IOException {
        int indent = 5;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        System.out.println(sb.toString());
    }

    public static void printDirectoryTree(File folder, int indent, StringBuilder sb) {
        sb.append(folder.toPath().getFileName());
        sb.append("\n");

        int count = 0;
        for (File file : folder.listFiles()) {
            count++;
            if (file.isDirectory()) {
                sb.append("|-----");
                long millis = file.lastModified();
                LocalDateTime date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
                sb.append(date.getYear());
                sb.append("-");
                printDirectoryTree(file, indent + 1, sb);
            } else {
                sb.append("|");
                for (int i = 0; i < indent; i++) {
                    sb.append(" ");
                }
                sb.append("0");
                sb.append(count).append(" - ");
                sb.append(file.toPath().getFileName());
                sb.append("\n");
            }
            sb.append("\n");
        }
        sb.append("|");
    }

    public static void printTreeInformation(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int filesNumber = 0;
        int foldersNumber = 0;
        int averageFileNumber = 0;
        int averageFileNameLength = 0;


        String line = bufferedReader.readLine();
        ArrayList<Integer> fileNamesLengths = new ArrayList<>();
        while (line != null) {
            if (line.startsWith("|-----")) {
                foldersNumber++;

            } else if (line.contains("|     ")) {
                filesNumber++;
                char[] charArray = line.toCharArray();
                int startIndex = 0;
                int endIndex = 0;


                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] == '-') {
                        startIndex = i;
                        break;
                    }
                }

                for (int i = startIndex + 1; i < charArray.length; i++) {
                    if (charArray[i] == '.') {
                        endIndex = i;
                        break;
                    }
                }
                fileNamesLengths.add(endIndex - startIndex);
            }
            line = bufferedReader.readLine();
        }
        int sumOfAllFilesNamesLengths = 0;
        for (Integer lengths : fileNamesLengths) {
            sumOfAllFilesNamesLengths += lengths;
        }
        averageFileNumber = filesNumber / foldersNumber;
        averageFileNameLength = sumOfAllFilesNamesLengths / filesNumber;

        System.out.println("Folders number: " + foldersNumber);
        System.out.println("Files number: " + filesNumber);
        System.out.println("Average file number: " + averageFileNumber);
        System.out.println("Average file name length: " + averageFileNameLength);
    }


    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            if (file.isDirectory()) {
                printDirectoryTree(file);
            }

            if (file.getAbsolutePath().endsWith(".txt")) {
                printTreeInformation(file);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
