package lesson33.hw;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {
        readFile("C:\\java\\test.txt");
        writeFile("C:\\java\\test2.txt","111");
        testWriteFile("C:\\java\\test3.txt");
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
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

    private static void writeFile(String path, String content) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n" + " " + content);
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println("Can not write to file");
            return;
        } finally {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(bufferedWriter);
        }
    }
    private static void testWriteFile(String path){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("test" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        finally {
            IOUtils.closeQuietly(fileWriter);
        }
    }
}
