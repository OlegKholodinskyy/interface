package lesson18.StorageTryCatch;

public class Main {

    public static void main(String[] args) {
        Storage cs = new CodeStorage();
        Storage ps = new PictureStorage();
        Storage fs = new FileStorage();


        cs.setFiles(new String[]{"one","two","three"});
        ps.setFiles(new String[]{"one","two","three", "four", "five", "six"});
        fs.setFiles(new String[]{"one","two","three"});

        Task task = new Task();
        task.printer(cs);
        task.printer(ps);
        task.printer(fs);
    }
}
