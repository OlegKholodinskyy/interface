package lesson34.task3;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.transferSentences("C:\\java\\test2.txt" , "C:\\java\\test3.txt", "www");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
