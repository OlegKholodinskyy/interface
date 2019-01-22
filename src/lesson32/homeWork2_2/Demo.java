package lesson32.homeWork2_2;

import lesson32.homeWork2.BadInputException;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {

        try {
            System.out.println(Solution.readNumbers());
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

