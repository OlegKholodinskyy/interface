package lesson11.biginterfaceexample;

public class FileReader implements Readable {
    @Override
    public void readFilesFromStorage(Storage storage) {
        //знайти найбільший файл
        //вивести інформацію про нього

        printFile(findMaxSizeFile(storage.getFiles()));

    }

    private File findMaxSizeFile(File[] files) {
        File maxSizeFile = files[0];
        for (File file : files) {
            if (file != null)
                if (file.getSize() > maxSizeFile.getSize()) {
                    maxSizeFile = file;
                }
        }
        return maxSizeFile;
    }

    private void printFile(File file) {
        System.out.println("Max File will be printed now ...");
        System.out.println(file.getName());
        System.out.println(file.getExtension());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
        System.out.println();
    }
}
