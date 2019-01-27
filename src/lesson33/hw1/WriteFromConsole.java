package lesson33.hw1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class WriteFromConsole {
    public static void writeFileFromConsole() throws FileNotFoundException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String path = "C:\\java\\test.txt";
        String line;

        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File with path " + path + " not found");
        }

        System.out.println("Enter file content to write in file: ");
        try {
            fileWriter = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            while (true) {
                line = bufferedReader.readLine();
                if (line.equals("wr")) {
                    break;
                } else {
                    bufferedWriter.append("\n");
                    bufferedWriter.append(line + "\n");
                    bufferedWriter.append("\n");
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Can't write to file with path " + path);
        }
        finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(fileWriter);
            IOUtils.closeQuietly(bufferedWriter);
        }
    }
}
