package lesson34.task1;

import java.io.*;

public class Practice {
    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        /*
        1- перевірити чи файл існує
        2 - перевірити права
        3- зчитати з fileFromPath
        4 - записати в fileToPath
         */
        validate(fileFromPath, fileToPath);


        StringBuffer res = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.append(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("reading fail");
        }

    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permossion to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permossion to be written");
        }


    }
}
