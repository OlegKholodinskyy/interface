package lesson11.biginterfaceexample;

public class Demo {
    public static void main(String[] args) {

        File file1 = new File("test.txt", "C:/user/home", "txt", 11);
        File file2 = new File("test.txt", "C:/user/home", "txt", 11);
        File file3 = new File("video.txt", "C:/user/home", "txt", 15);
      //  File file4 = new File("test.txt", "C:/user/home", "txt", 11);
        File file5 = new File("myhome", "C:/user/home/jpg", "jpg", 125);
        File[] files = new File[]{file1, file2, file3, null, file5};
        Storage storage = new Storage(files);

        FileReader fileReader = new FileReader();
        SimpleReader simpleReader = new SimpleReader();

        read(storage, fileReader);
        read(storage, simpleReader);
    }

    private static void read (Storage storage , Readable readable){
        readable.readFilesFromStorage(storage);
    }
}
