package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {
        readFile("C:\\java\\test.txt");
        writeFile("C:\\java\\test2.txt", "111");
        testWriteFile("C:\\java\\test3.txt");
    }

    private static void readFile(String path) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("reading fail");
        }
    }

    private static void writeFile(String path, String content) {

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true))){
            bufferedWriter.append("\n" + " " + content);
            bufferedWriter.flush();
        }
        catch (IOException e){
            System.err.println("Can not write to file");
        }
    }

    private static void testWriteFile(String path) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("test" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            IOUtils.closeQuietly(fileWriter);
        }
    }
}
