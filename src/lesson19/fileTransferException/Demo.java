package lesson19.fileTransferException;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        File fileJpg1 = new File(1, "photo1", TypeOfFiles.JPG.name(), 200);
        File fileJpg2 = new File(2, "photo2rrrrrrrr", TypeOfFiles.JPG.name(), 10);
        File fileJpg3 = new File(3, "photo3", TypeOfFiles.JPG.name(), 11120);
        File fileDoc1 = new File(4, "doc1", TypeOfFiles.DOC.name(), 120);
        File fileDoc2 = new File(5, "doc2", TypeOfFiles.DOC.name(), 100);
        File fileDoc3 = new File(6, "doc3", TypeOfFiles.DOC.name(), 10);
        File fileXls1 = new File(7, "xls1", TypeOfFiles.XLS.name(), 40);
        File fileResearch = new File(8, "research", TypeOfFiles.XLS.name(), 40);

        File[] files = new File[0];
        String[] formatsSupportedStorage1 = new String[]{TypeOfFiles.JPG.name(), TypeOfFiles.XLS.name()};
        String[] formatsSupportedStorage2 = new String[]{TypeOfFiles.DOC.name(), TypeOfFiles.XLS.name()};


        Storage storagePictures = new Storage(1, files, formatsSupportedStorage1, "Ukraine", 1200);
        Storage storageDocuments = new Storage(2, files, formatsSupportedStorage2, "Ukraine", 1200);

        Controller controller = new Controller();
        try {
            controller.put(storagePictures, fileDoc1);
        } catch (IllegalArgumentException e) {
        }
        try {
            controller.put(storagePictures, fileXls1);
        } catch (IllegalArgumentException e) {
        }
        try {
            controller.put(storagePictures, fileJpg3);
        } catch (IllegalArgumentException e) {
        }
        try {
            controller.transferFile(storagePictures, storageDocuments,3 );
        } catch (IllegalArgumentException e) {
        }

        System.out.println("list");
        for (File f : storagePictures.getFiles()) {
            System.out.println(f.toString());
        }
    }
}
