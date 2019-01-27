package lesson33.hw2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFileByConsole {
    public static void readFileByConsolePath() throws IOException {
        String path = askForPath();
        readFile(path);
    }

    private static String askForPath() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Please, enter file path to read: ");
        return bufferedReader.readLine();
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + "not found");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(reader);


        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("reading fail");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(bufferedReader);
        }
    }
}