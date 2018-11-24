package lesson19;

public class ThrowExample {
    private static String[] array = {"-1", "4", "", null, "0"};

    private static void test() throws Exception {
        for (String element : array) {
            if (element == null) {
                throw new Exception("null is detected");
            }else{
                System.out.println(element);
            }
        }
        System.out.println("done");
    }

    private static void useOfTestMethod(){

        try {
            test();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        useOfTestMethod();
    }
}
