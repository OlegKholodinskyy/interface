package lesson34.task2;

import java.io.*;

public class Solution {
    /*
    file transfer content
     */
    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validation(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath), fileFromPath);
    }

    private static void writeToFile(String fileToPath, StringBuffer content, String fileFromPath) {
        try (BufferedWriter bwFileToPath = new BufferedWriter(new FileWriter(fileToPath, true));
             BufferedReader brFileToPath = new BufferedReader(new FileReader(fileToPath));
             BufferedWriter bwFileFromPath = new BufferedWriter(new FileWriter(fileFromPath))) {
            if (brFileToPath.readLine() == null) {
                bwFileToPath.append(content);
            } else {
                bwFileToPath.append("\n" + content);
            }
            bwFileFromPath.write("");
            bwFileFromPath.flush();
        } catch (IOException e) {
            System.err.println("Can not write to file");
        }
    }

    private static StringBuffer readFromFile(String fileFromPath) {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line +  "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static void validation(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) {
            throw new Exception("File " + fileFromPath + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new Exception("File " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFromPath + " does not have permission to read");
        }
        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFromPath + " does not have permission to write");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to write");
        }
    }
}
