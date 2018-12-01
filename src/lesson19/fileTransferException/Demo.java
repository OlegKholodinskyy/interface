package lesson19.fileTransferException;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        File fileJpg1 = null;
        try {
            fileJpg1 = new File(1, "photo1", TypeOfFiles.JPG.name(), 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File fileJpg2 = null;
        try {
            fileJpg2 = new File(2, "photo1", TypeOfFiles.JPG.name(), 110);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File fileJpg3 = null;
        try {
             fileJpg3 = new File(3, "photo3", TypeOfFiles.JPG.name(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        File fileDoc1 = null;
        try {
            fileDoc1 = new File(4, "doc1", TypeOfFiles.DOC.name(), 120);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        File fileDoc2 = new File(5, "doc2", TypeOfFiles.DOC.name(), 100);
//        File fileDoc3 = new File(6, "doc3", TypeOfFiles.DOC.name(), 10);
//        File fileXls1 = new File(7, "xls1", TypeOfFiles.XLS.name(), 40);
        File fileResearch = null;
        try {
             fileResearch = new File(8, "research", TypeOfFiles.XLS.name(), 40);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File[] files = new File[0];
        String[] formatsSupportedStorage1 = new String[]{TypeOfFiles.JPG.name(), TypeOfFiles.XLS.name()};
        String[] formatsSupportedStorage2 = new String[]{TypeOfFiles.DOC.name(), TypeOfFiles.XLS.name()};


        Storage storagePictures = new Storage(1, files, formatsSupportedStorage1, "Ukraine", 200);
        Storage storageDocuments = new Storage(2, files, formatsSupportedStorage2, "Ukraine", 1200);

        Controller controller = new Controller();

        try {
            controller.put(storagePictures,fileJpg1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controller.put(storagePictures,fileJpg3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controller.put(storagePictures,fileResearch);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controller.delete(storagePictures,fileJpg1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controller.transferFile(storagePictures,storageDocuments,8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        for (File f : storageDocuments.getFiles()) {
            System.out.println(f.toString());
        }
        System.out.println(storagePictures.getFiles().length);
    }
}
