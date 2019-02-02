package lesson34.task4;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {

        System.out.println("FILES.COPY");
        try {
            Solution.copyFileContent("C:\\java\\test2.txt" , "C:\\java\\test8.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("APACHE UTILS");
        try {
            Solution.copyFileContentApacheIO("C:\\java\\test2.txt" , "C:\\java\\test9.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
