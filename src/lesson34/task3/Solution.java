package lesson34.task3;

import java.io.*;

public class Solution {
    /*
    transfer sentences
     */
    static StringBuffer stringBufferTo = new StringBuffer();
    static StringBuffer stringBufferFrom = new StringBuffer();

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validation(fileFromPath, fileToPath);
        fillStringBuffers(readFromFile(fileFromPath), word);
        writeFiles(fileFromPath, fileToPath);

    }

    private static void writeFiles(String fileFromPath, String fileToPath) {
        try (BufferedWriter brFrom = new BufferedWriter(new FileWriter(fileFromPath));
             BufferedWriter brTo = new BufferedWriter(new FileWriter(fileToPath))) {

            brTo.append(stringBufferTo);
            brFrom.append(stringBufferFrom);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static StringBuffer readFromFile(String fileFromPath) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringBuffer;
    }

    private static void fillStringBuffers(StringBuffer sb, String word) throws Exception {
        String s = sb.toString();
        String[] sentence = s.split("\\.");
        for (String curentSentence : sentence) {

            if (curentSentence == null)
                throw new Exception("Something  wrong with input text");

            if (curentSentence.contains(word)   &&   curentSentence.length()>=10) {
                stringBufferTo.append(curentSentence);
            } else {
                stringBufferFrom.append(curentSentence);
            }
        }
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
