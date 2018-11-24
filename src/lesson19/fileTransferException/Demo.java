package lesson19.fileTransferException;

public class Demo {
    public static void main(String[] args) {
        File fileJpg1 = new File(1, "photo1", TypeOfFiles.JPG.name(), 200);
        File fileJpg2 = new File(2, "photo2", TypeOfFiles.JPG.name(), 250);
        File fileJpg3 = new File(3, "photo3", TypeOfFiles.JPG.name(), 230);
        File fileDoc1 = new File(4, "doc1", TypeOfFiles.DOC.name(), 220);
        File fileDoc2 = new File(5, "doc2", TypeOfFiles.DOC.name(), 100);
        File fileDoc3 = new File(6, "doc3", TypeOfFiles.DOC.name(), 150);
        File fileXls1 = new File(7, "xls1", TypeOfFiles.XLS.name(), 40);

        File[] files = new File[0];
        String[] formatsSupportedStorage1 = new String[]{TypeOfFiles.JPG.name()};
        String[] formatsSupportedStorage2 = new String[]{TypeOfFiles.DOC.name(), TypeOfFiles.XLS.name()};

        Storage storagePictures = new Storage(1, files, formatsSupportedStorage1, "Ukraine", 400);
        Storage storageDocuments = new Storage(2, files, formatsSupportedStorage2, "Ukraine", 400);

        Controller controller = new Controller();
        controller.put(storageDocuments,fileDoc1 );
        controller.put(storageDocuments, fileDoc2);
        controller.put(storageDocuments, fileDoc3);
        controller.put(storageDocuments, fileXls1);
        controller.delete(storageDocuments,fileXls1);
        controller.put(storagePictures, fileJpg1);
        controller.put(storagePictures, fileJpg2);
        controller.put(storagePictures, fileJpg3);
       // controller.delete(storagePictures, fileXls1);

        for (File f: storagePictures.getFiles()){
            System.out.println(f.toString());
        }
    }
}
