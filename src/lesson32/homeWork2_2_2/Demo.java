package lesson32.homeWork2_2_2;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println(Solution.readNumbers());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
