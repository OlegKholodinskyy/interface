package lesson33.hw1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {

        try {
            WriteFromConsole.writeFileFromConsole();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
