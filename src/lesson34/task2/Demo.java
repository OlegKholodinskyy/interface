package lesson34.task2;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.transferFileContent("C:\\java\\test2.txt" , "C:\\java\\test3.txt");
        } catch (Exception e) {
            System.err.println(e.getMessage());;
        }
    }
}
