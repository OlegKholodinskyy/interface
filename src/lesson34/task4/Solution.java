package lesson34.task4;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    /*
    copy standart methods
     */


    public static void copyFileContent(String fileFromPath, String fileToPath) throws IOException {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.canRead()) {
            throw new IOException("Can not read file " + fileFromPath);
        }

        Files.copy(fileFrom.toPath(), fileTo.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.canRead()) {
            throw new IOException("Can not read file " + fileFromPath);
        }

        FileUtils.copyFile(fileFrom, fileTo);



    }
}